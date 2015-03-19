/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistech.WhiteboardGUI;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Alex Mulkerrin
 */
class MessagePanel extends JPanel implements ActionListener, Runnable  {
    public String messageContent = "Message list goes here";
    JLabel messageContainer;
    JButton button;
    
    public MessagePanel() {
        setBackground(new Color(255,255,200));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        messageContainer = new JLabel(messageContent);
        add(messageContainer);
             
//        button = new JButton("UpdateMessages");
//        add(button);
//        go();
        Thread t = new Thread(this);
        t.start();
    }
    
    public void go() {
        button.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event) {
        messageContent="UpdateFailed :(";
        messageContainer.setText(messageContent);
                
    }
    
    @Override
    public void run() {
        while (true) {
            try {
            String[][] reminders = sistech.DBInformation.getMessages();
            String messageString ="\n";
            for (int i=0; i<reminders.length; i++) {
                for (int j=0; j<reminders.length; j++) {
                    System.out.println(reminders[i][j].toString());
                    messageContent= messageContent + reminders[i][j].toString() +"\n";
                }
            }
            } catch (Exception ex){
                messageContent+="UpdateFailed :(";
            }

            messageContainer.setText(messageContent);
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }
    }
}
