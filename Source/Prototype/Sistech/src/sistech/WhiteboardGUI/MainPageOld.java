/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistech.WhiteboardGUI;

/**
 *
 * @author prino_000
 */

import javax.swing.*;
import javax.swing.BoxLayout;
import java.awt.*;
import java.util.*;
import javax.swing.border.*;
public class MainPageOld extends JFrame
{
    public static void mainOLD(String[] args)
    {
        
        JFrame mf = new JFrame();
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mf.setUndecorated(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        mf.setSize((int) tk.getScreenSize().getWidth(), (int) tk.getScreenSize().getHeight());
        mf.setLayout(new BorderLayout());
        JPanel screenPanel = new JPanel();
        screenPanel.setLayout(new BorderLayout());
        screenPanel.setBackground(Color.white);
        AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,12,16,0);
        screenPanel.setBorder(brdr);
        
        JPanel topPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        
        topPanel(topPanel);
        middlePanel(middlePanel);
        
        screenPanel.setBackground(Color.white);
        screenPanel.add(topPanel, BorderLayout.NORTH);
        screenPanel.add(middlePanel, BorderLayout.CENTER);
        mf.add(screenPanel);
        mf.setVisible(true);
        
    }
    
    public static JPanel topPanel(JPanel topPanel)
    {
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        JLabel name = new JLabel("Name");
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(name);
        topPanel.add(Box.createHorizontalGlue());
        JLabel Date = new JLabel("Date");
        topPanel.add(Date);
        //topPanel.add(Box.createHorizontalGlue());
        
        return topPanel;
    }
    
    public static JPanel middlePanel(JPanel middlePanel)
    {
        middlePanel.setLayout(new GridLayout(1,2));
        JPanel taskPanel = new JPanel();
        JPanel messagePanel = new JPanel();
        taskPanel(taskPanel);
        messagePanel(messagePanel);
        JScrollPane pane = new JScrollPane(taskPanel);
        pane.setBackground(Color.white);
        pane.setViewportBorder(null);
        
        AbstractBorder brdr = new TextBubbleBorder(Color.RED,4,16,0);
        taskPanel.setBorder(brdr);
        taskPanel.setBackground(Color.white);
        middlePanel.add(pane);
        middlePanel.add(messagePanel);
        return middlePanel;
    }
    
    public static JPanel taskPanel(JPanel taskPanel)
    {
        taskPanel.setLayout(new GridLayout(31,0));
        taskPanel.setBackground(Color.white);
        JPanel[] day = new JPanel[31];
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        if(month == 2)
        {
            for(int i = 0; i < 28; i++)
            {
                day[i] = task(day[i], i, month, year);
                taskPanel.add(day[i]);
            }
        }
        else if(month == 9 || month == 4 || month == 6 || month == 11)
        {
            for(int i = 0; i < 30; i++)
            {
                day[i] = task(day[i], i, month, year);
                taskPanel.add(day[i]);
            }
        }
        else
        {
            for(int i = 0; i < 31; i++)
            {
                day[i] = task(day[i], i, month, year);
                taskPanel.add(day[i]);
            }
        }
        return taskPanel;
    }
    
    public static JPanel messagePanel(JPanel messagePanel)
    {
        messagePanel.setBackground(Color.white);
        return messagePanel;
    }
    
    public static JPanel task(JPanel task, int i, int month, int year)
    {
        
        task = new JPanel();
        AbstractBorder brdr = new TextBubbleBorder(Color.BLUE,2,16,0);
        JLabel date = new JLabel(i+1 + "-" + month + "-" + year);
        date.setBackground(Color.white);
//        Calandar cal = Calendar.getInstance();
  //      java.sql.Date dateCheck = new java.sql.Date(parsed.);
    //    JLabel message = new JLabel(sistech.DBInformation.getReminder(dateCheck));
      //  message.setBackground(Color.white);
        task.add(date, BorderLayout.WEST);
        //task.add(message, BorderLayout.CENTER);
        task.setBorder(brdr);
                
        return task;
    }
}
