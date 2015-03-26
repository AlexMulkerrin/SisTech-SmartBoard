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
        
        JLabel title = new JLabel("Todo list goes here:");
        
        add(title, BorderLayout.NORTH);
        taskContainer = new JPanel();
        taskContainer.setLayout(new GridLayout(6,0,5,5));
        add(taskContainer, BorderLayout.CENTER);
        
//        add(new TaskBlock());
//        add(new TaskBlock());
//        add(new TaskBlock());
//        add(new TaskBlock());
//        add(new TaskBlock());
//        add(new TaskBlock());
        
        //button = new JButton("UpdateTasks");
        //add(button);
        //go();
        Thread t = new Thread(this);
        t.start();
    }
    
    public void go() {
        //button.addActionListener(this);
    }
    
//    @Override
//    public void actionPerformed(ActionEvent event) {
//        taskContent="UpdateFailed :(";
//        taskContainer.setText(taskContent);            
//    }
    
    @Override
    public void run() {
        while (true) {

            String[][] reminders = sistech.DBInformation.getReminder("2015-05-01");
            // repopulate Todo list
            taskContainer.removeAll();
            
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
            setLayout(new GridLayout(0,3));
            
            JTextArea nameContainer = new JTextArea("task "+text);
            add(nameContainer);

            JLabel dateContainer = new JLabel("time due "+time);
            add(dateContainer);

            JCheckBox tickBox = new JCheckBox("id:"+key);
            tickBox.addItemListener(new CheckBoxListener(key));
            add(tickBox);
        }
    }
    
    public class CheckBoxListener implements ItemListener {
        String taskID;
        
        public CheckBoxListener(String key) {
            taskID = key;
        }
        @Override
        public void itemStateChanged(ItemEvent ev) {
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


   

