package sistech.WhiteboardGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Alex Mulkerrin
 */
class TaskPanel extends JPanel  implements ActionListener{
    public String taskContent = "Message list goes here";
    JLabel taskContainer;
    JButton button;
    
    public TaskPanel() {
        //this.setBorder(new TextBubbleBorder(Color.RED,4,16,0));
        setBackground(new Color(200,200,255));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

//        this.setLayout(new GridLayout(31,0));
//        DayPane[] day = new DayPane[31];
//        for (int i=0; i<31; i++) {
//            day[i] = new DayPane();
//        }
//        Calendar cal = Calendar.getInstance();
//        int month = cal.get(Calendar.MONTH) + 1;
//        int year = cal.get(Calendar.YEAR);
//        
//        int monthLength=31;
//        if (month ==2) {
//            monthLength=28;            
//        } else if (month == 9 || month == 4 || month == 6 || month == 11) {
//            monthLength=30;            
//        }
//        
//        for (int i=0; i<monthLength; i++) {
//            //day[i].addTask(i+1,month,year); //days start at 1 not 0   
//            this.add(day[i]);
//        }
        taskContainer = new JLabel(taskContent);
        add(taskContainer);
             
        button = new JButton("UpdateTasks");
        add(button);
        go();
    }
    
    public void go() {
        button.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event) {
        taskContent="UpdateFailed :(";
        taskContainer.setText(taskContent);
                
    }
}

class DayPane extends JPanel {
    public DayPane() {
        //TODO set defaults?
    }
    
    public void addTask(int day, int month, int year) {
        JLabel date = new JLabel(day + "-" + month + "-" + year);
        date.setBackground(Color.white);
        this.add(date, BorderLayout.WEST);
        
        //Calendar cal = Calendar.getInstance();
        //java.sql.Date dateCheck = new java.sql.Date(year, month, day);
        String dateString = "";
        if (month < 10) {
            if (day<10) {
                dateString = year+"-0"+month+"-0"+day;
            } else {
                dateString = year+"-0"+month+"-"+day;
            }
        } else {
            if (day<10) {
                dateString = year+"-"+month+"-0"+day;
            } else {
                dateString = year+"-"+month+"-"+day;
            }
        }
        String[][] reminders = sistech.DBInformation.getReminder(dateString);
        
        String messageString ="/n";
        for (int i=0; i<reminders.length; i++) {
           // System.out.println(reminders.get(i).toString());
           // messageString= messageString + reminders.get(i).toString() +"/n";
        }
        
        JLabel message = new JLabel(messageString);
        
        this.add(message, BorderLayout.CENTER);
        this.add(date, BorderLayout.WEST);
        this.setBorder(new TextBubbleBorder(Color.BLUE,2,16,0));
    }
}
