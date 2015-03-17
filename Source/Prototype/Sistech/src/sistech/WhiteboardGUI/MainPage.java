/*  Basic canvas painter Demo
*   author Alex Mulkerrin
*   date 17/3/15 
*/
package sistech.WhiteboardGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;


public class MainPage {
    // main routine running on whiteboard hardware
    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    // initialisation of top level interface container
    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT(event dispatch thread)? "+ SwingUtilities.isEventDispatchThread());
        // what is it with java and repeating the same variable name over and over??
        MainFrame mainFrame = new MainFrame();
        //mainFrame.add(new MyPanel());
        //mainFrame.pack();       
    }
}
// fullscreen Graphical User Interface 
class MainFrame extends JFrame {
    public MainFrame() {
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.setSize((int) tk.getScreenSize().getWidth(), (int) tk.getScreenSize().getHeight());
        this.setLayout( new BorderLayout());
        this.add(new ScreenPanel());
        this.setVisible(true);
    }
}
// Parent panel across entire screen
class ScreenPanel extends JPanel {
    public ScreenPanel() {
        this.setLayout(new GridLayout(0,2));
        this.setBackground(new Color(255,200,255));
        //this.setBorder(new TextBubbleBorder(Color.BLACK,12,16,0));
             
        this.add(new TaskPanel());
        this.add(new RightPanel());
    }
}
// Screen topline with important info: patient name and current date
class RightPanel extends JPanel {
    public RightPanel() {
        setBackground(new Color(255,200,200));
        setLayout(new GridLayout(3,0));
        add(new InfoPanel());
        add(new MessagePanel());
        add(new DrawingPanel());
    }
}
