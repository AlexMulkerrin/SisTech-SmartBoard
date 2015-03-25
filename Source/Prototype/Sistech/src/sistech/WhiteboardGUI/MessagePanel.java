package sistech.WhiteboardGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Sub-panel displaying support network messages stored on database. Checking
 * the database for updates is done in a separate thread. Each message is 
 * displayed with a button to choose to respond to them. TODO SET RECIPIENT WHEN
 * REPLY BUTTON CLICKED.
 *
 * @author Alex Mulkerrin
 */
class MessagePanel extends JPanel implements ActionListener, Runnable  {
    public String messageContent = "Message list goes here\n\n";
    JTextArea messageContainer;
    JButton button;
    
    public MessagePanel() {
        setBackground(new Color(255,255,200));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new GridLayout(5,0));
        
        messageContainer = new JTextArea(messageContent);
        add(messageContainer);
        
        add(new MessageBlock());
        add(new MessageBlock());
        add(new MessageBlock());
         // need to add reply functionality here
//        button = new JButton("UpdateMessages");
//        add(button);
//        go();
        Thread t = new Thread(this);
        t.start();
    }
    
    public void go() {
        button.addActionListener(this);
    }
    
    @Override
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
                    System.out.println(reminders[i][j]);
                    messageContent= messageContent + reminders[i][j] +"\n";
                }
            }
            } catch (Exception ex){
                //messageContent+="UpdateFailed :(";
            }

            messageContainer.setText(messageContent);
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }
    }
    
    public class MessageBlock extends JPanel {
        public MessageBlock() {
            setLayout(new GridLayout(0,3));
            
            JLabel nameContainer = new JLabel("Name and icon ");
            add(nameContainer);
            
            JTextArea messageContainer = new JTextArea("message text");
            add(messageContainer);
            
            JButton respondButton = new JButton("Respond");
            add(respondButton);
        }
    }
    
}
