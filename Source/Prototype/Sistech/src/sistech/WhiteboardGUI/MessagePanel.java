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
class MessagePanel extends JPanel implements Runnable  {
    JPanel messageContainer;
    Boolean selectedRecepient = false;
    String recepientID = null;
    
    public MessagePanel() {
        setBackground(new Color(255,255,200));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new BorderLayout());
        
        JLabel title = new JLabel("Message List goes here:");
       
                
        add(title, BorderLayout.NORTH);
        messageContainer = new JPanel();
        messageContainer.setLayout(new GridLayout(5,0,5,5));
        add(messageContainer, BorderLayout.CENTER);

        Thread t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        while (true) {
            
            String[][] messages = sistech.DBInformation.getMessages();
            // repopulate message list
            //remove(messageContainer);
            messageContainer.removeAll();
            //messageContainer = new JPanel();
            //setLayout(new GridLayout(6,0));

            for (int i=0; i<messages.length; i++) {
                
                String text = messages[i][0];
                String time = messages[i][1];
                String date = messages[i][2];
                String sender = messages[i][3];
                String streamID = messages[i][4];
                if (text!=null) {
                    messageContainer.add(new MessageBlock(sender,time,date,text,streamID));
                }
            }
            
            add(messageContainer);
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
            
        }
    }
    
    public class MessageBlock extends JPanel {
        public MessageBlock(String sender, String time, String date, String text, String streamID) {
            setLayout(new GridLayout(0,3));
            
            JLabel nameContainer = new JLabel("Sender: user "+sender);
            add(nameContainer);
            
            String contents = time+" "+date+"\n"+text;
            JTextArea messageContainer = new JTextArea(contents);
            add(messageContainer);
            
            JButton respondButton = new JButton("Respond"+streamID);
            add(respondButton);
        }
    }
    
    public class RespondButton extends JButton implements ActionListener {
        String senderID;
        
        public RespondButton(String sender) {
            senderID = sender;
        }
        @Override
        public void actionPerformed(ActionEvent ev) {
            selectedRecepient = true;
            recepientID = senderID;
        }
    }
    
}
