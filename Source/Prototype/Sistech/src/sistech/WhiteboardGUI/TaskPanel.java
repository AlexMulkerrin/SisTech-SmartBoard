package sistech.WhiteboardGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Sub-panel displaying list of tasks for the current day. List is gotten by
 * querying database on a separate thread. Each task displays a name, due date
 * and interface element to mark as complete. TODO HAVE CHECKBOXES THAT UPDATE
 * DATABASE.
 *
 * @author Alex Mulkerrin
 */
class TaskPanel extends JPanel  implements Runnable {
    JPanel taskContainer;
    
    public TaskPanel() {
        //this.setBorder(new TextBubbleBorder(Color.RED,4,16,0));
        setBackground(new Color(200,200,255));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new BorderLayout());
        
        JLabel title = new Styling.SLabel("Todo list goes here:");
        
        add(title, BorderLayout.NORTH);
        taskContainer = new JPanel();
        taskContainer.setLayout(new GridLayout(6,0,10,10));

        JPanel headers = new JPanel();
        headers.setLayout(new GridLayout(0,3));
        headers.add(new Styling.SLabel("Task"));
        headers.add(new Styling.SLabel("Time due"));
        headers.add(new Styling.SLabel("Tick list"));
        
        taskContainer.add(headers);
        add(taskContainer, BorderLayout.CENTER);

        Thread t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        while (true) {

            String[][] reminders = sistech.DBInformation.getReminder("2015-05-01");
            // repopulate Todo list
            taskContainer.removeAll();
            
            JPanel headers = new JPanel();
            headers.setLayout(new GridLayout(0,3));
            headers.add(new Styling.SLabel("Task"));
            headers.add(new Styling.SLabel("Time due"));
            headers.add(new Styling.SLabel("Tick list"));

            taskContainer.add(headers);
            
            for (int i=0; i<reminders.length; i++) {

                String text = reminders[i][0];
                String time = reminders[i][1];
                String key = reminders[i][2];
                if (text!=null) {
                    taskContainer.add(new TaskBlock(text, time, key));
                }                
            }

            add(taskContainer);
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }
    }
    
    public class TaskBlock extends JPanel {
        public TaskBlock(String text, String time, String key) {
            setLayout(new GridLayout(0,3,10,10));
            
            JTextArea nameContainer = new Styling.STextArea(text);
            add(nameContainer);

            JTextArea dateContainer = new Styling.STextArea(time);
            add(dateContainer);

            JButton tickBox = new Styling.SButton("id:"+key);
            tickBox.addActionListener(new CheckBoxListener(key));
            add(tickBox);
        }
    }
    
    public class CheckBoxListener implements ActionListener {
        String taskID;
        
        public CheckBoxListener(String key) {
            taskID = key;
            
        }
        @Override
        public void actionPerformed(ActionEvent event) {
            // change text of button when triggered
            JButton source = (JButton) event.getSource();
            source.setText("Done!");
            System.out.println("Clicked check box for"+ taskID);
            Thread t = new Thread(new TaskSender(taskID));
            t.start();
        }
    }
    
    public class TaskSender implements Runnable {
        String key;
        public TaskSender(String taskID) {
            key = taskID;
        }
        @Override
        public void run() {
            System.out.println("Amending database"+ key);
            sistech.DBInformation.editReminder(key, true);
            System.out.println("Clicked check box for"+ key);
        }
    }
    
}


   

