package sistech.WhiteboardGUI;

import java.awt.*;
import javax.swing.*;

/**
 * Style of elements for interface to give consistent design.
 *
 * @author Alex Mulkerrin
 */
public class Styling {
    static String font = "Kristen ITC";
    static int style = Font.BOLD;
    static int size = 20;
   
    public static class SLabel extends JLabel {
        public SLabel(String text) {
            super(text);
            setFont(new Font(font, style, size));
            setHorizontalAlignment(CENTER);
            
        }
    }

    public static class STextArea extends JTextArea {
        public STextArea(String text) {
            super(text);
            setFont(new Font(font, style, size));
            setMargin(new Insets(20,20,20,20));
            setEditable(false);
            setLineWrap(true);
            setWrapStyleWord(true);
        }
    }
    
    public static class SButton extends JButton {
        public SButton(String text) {
            super(text);
            setFont(new Font(font, style, size));
            
        }
    }
    
    public static class STickBox extends JButton {
        Boolean ticked = false;
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int height = this.getHeight();
            int width = this.getWidth();
            
            if (ticked) {
                g.setColor(Color.black);
                g.fillRect(width/5,height/5,width*3/5,height*3/5);
                g.setColor(Color.white);
                g.fillRect(width/4,height/4,width*2/4,height*2/4);
                
                g.setColor(Color.green);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(10));
                g2.drawLine(width*4/5,height/6, width/5,height*5/6);
                g2.drawLine(width/5,height*5/6, width/6,height*4/6);
                
            } else {
                g.setColor(Color.red);
                g.fillRect(width/5,height/5,width*3/5,height*3/5);
                g.setColor(Color.white);
                g.fillRect(width/4,height/4,width*2/4,height*2/4);
                
            }

        }
    }
    
}
