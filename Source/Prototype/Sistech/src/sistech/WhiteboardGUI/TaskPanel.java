package sistech.WhiteboardGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Sub-panel displaying list of tasks for the current day. List is gotten by
 * querying database on a separate thread. Each task displays a name, due date
 * and interface element to mark as complete. TODO HAVE CHECKBOXES THAT UPDATE
 * DATABASE.
 *
 * @author Alex Mulkerrin
 */
class TaskPanel extends JPanel  implements ActionListener, Runnable {
    public String taskContent = "Task list goes here\n\n";
    JTextArea taskContainer;
    
    public TaskPanel() {
        //this.setBorder(new TextBubbleBorder(Color.RED,4,16,0));
        setBackground(new Color(200,200,255));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new GridLayout(10,0));

        taskContainer = new JTextArea(taskContent);
        add(taskContainer);
        
        add(new TaskBlock());
        add(new TaskBlock());
        add(new TaskBlock());
        add(new TaskBlock());
        add(new TaskBlock());
        add(new TaskBlock());
        
        //button = new JButton("UpdateTasks");
        //add(button);
        //go();
        Thread t = new Thread(this);
        t.start();
    }
    
    public void go() {
        //button.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        taskContent="UpdateFailed :(";
        taskContainer.setText(taskContent);            
    }
    
    @Override
    public void run() {
        while (true) {
            try {
            String[][] reminders = sistech.DBInformation.getReminder("2015-05-01");
            String messageString ="\n";
            for (int i=0; i<reminders.length; i++) {
                for (int j=0; j<reminders.length; j++) {
                    System.out.println(reminders[i][j].toString());
                    taskContent= taskContent + reminders[i][j].toString() +"\n";
                }
            }
            } catch (Exception ex){
                taskContent+="UpdateFailed :(";
            }

            taskContainer.setText(taskContent);
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }
    }
    
    public class TaskBlock extends JPanel {
        public TaskBlock() {
            setLayout(new GridLayout(0,3));
            
            JLabel nameContainer = new JLabel("task ");
            add(nameContainer);

            JLabel dateContainer = new JLabel("time due");
            add(dateContainer);

            JCheckBox tickBox = new JCheckBox("Done?");
            add(tickBox);
        }
    }
}

////NOT USED!
//class DayPane extends JPanel {
//    public DayPane() {
//        //TODO set defaults?
//    }
//    
//    public void addTask(int day, int month, int year) {
//        JLabel date = new JLabel(day + "-" + month + "-" + year);
//        date.setBackground(Color.white);
//        this.add(date, BorderLayout.WEST);
//        
//        //Calendar cal = Calendar.getInstance();
//        //java.sql.Date dateCheck = new java.sql.Date(year, month, day);
//        String dateString = "";
//        if (month < 10) {
//            if (day<10) {
//                dateString = year+"-0"+month+"-0"+day;
//            } else {
//                dateString = year+"-0"+month+"-"+day;
//            }
//        } else {
//            if (day<10) {
//                dateString = year+"-"+month+"-0"+day;
//            } else {
//                dateString = year+"-"+month+"-"+day;
//            }
//        }
//        String[][] reminders = sistech.DBInformation.getReminder(dateString);
//        
//        String messageString ="\n";
//        for (int i=0; i<reminders.length; i++) {
//           // System.out.println(reminders.get(i).toString());
//           // messageString= messageString + reminders.get(i).toString() +"\n";
//        }
//        
//        JTextArea message = new JTextArea(messageString);
//        
//        this.add(message, BorderLayout.CENTER);
//        this.add(date, BorderLayout.WEST);
//        this.setBorder(new TextBubbleBorder(Color.BLUE,2,16,0));
//    }
//}
   

