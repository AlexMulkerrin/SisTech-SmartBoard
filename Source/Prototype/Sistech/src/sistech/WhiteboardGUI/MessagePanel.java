/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistech.WhiteboardGUI;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Alex Mulkerrin
 */
class MessagePanel extends JPanel {
    
    public MessagePanel() {
        setBackground(new Color(255,255,200));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //this.add(new DrawingPanel());
    }
}
