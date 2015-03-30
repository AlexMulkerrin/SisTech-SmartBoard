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
        }
    }
    
    public static class SButton extends JButton {
        public SButton(String text) {
            super(text);
            setFont(new Font(font, style, size));
            
        }
    }
    
}
