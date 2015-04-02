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
        
        JLabel title = new Styling.SLabel("Message List goes here:");
       
                
        add(title, BorderLayout.NORTH);
        messageContainer = new JPanel();
        messageContainer.setLayout(new GridLayout(3,2,5,5));
        add(messageContainer, BorderLayout.CENTER);

        Thread t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        while (true) {
            
            String[][] messages = sistech.DBInformation.getMessages();
            // repopulate message list
            messageContainer.removeAll();
            
            //JPanel headers = new JPanel();
            //headers.setLayout(new GridLayout(0,2));
            messageContainer.add(new Styling.SLabel("You sent"));
            messageContainer.add(new Styling.SLabel("they replied"));

            //messageContainer.add(headers);

            for (int i=0; i<messages.length; i++) {
                
                String text = messages[i][0];
                String time = messages[i][1];
                String date = messages[i][2];
                String sender = messages[i][3];
                String streamID = messages[i][4];
                String messageType = messages[i][5];
                if (text!=null) {
                    messageContainer.add(new MessageBlock(sender,time,date,text,streamID,messageType));
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
        public MessageBlock(String sender, String time, String date, String text, String streamID, String messageType) {
            setLayout(new GridLayout(0,1));
            
            if (messageType.equals("I")) {
                System.out.println(text);
                ImageIcon icon = new ImageIcon(getClass().getResource("/"+text));
            
                JLabel label = new JLabel(icon);
                add(label);
            } else {
            
            
            
            
            String[] timeParts = time.split(":");
            String timeNew = timeParts[0]+":"+timeParts[1]+"am today:";
            
            //String[] dateParts = date.split("-");
            //String dateNew = dateParts[2]+"rd of "+dateParts[1];
            
            String contents = "John Smith said at "+timeNew+"\n"+text;
            JTextArea timeContainer = new Styling.STextArea(contents);
            add(timeContainer);
            }
            //JButton respondButton = new Styling.SButton("Respond"+streamID);
            //add(respondButton);
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
