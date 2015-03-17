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
class MessagePanel extends JPanel implements ActionListener {
    public String messageContent = "Message list goes here";
    JLabel messageContainer;
    JButton button;
    
    public MessagePanel() {
        setBackground(new Color(255,255,200));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        messageContainer = new JLabel(messageContent);
        add(messageContainer);
             
        button = new JButton("UpdateMessages");
        add(button);
        go();
    }
    
    public void go() {
        button.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event) {
        messageContent="UpdateFailed :(";
        messageContainer.setText(messageContent);
                
    }
}
