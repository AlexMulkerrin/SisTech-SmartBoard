package sistech.WhiteboardGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Main window Frame of the GUI which holds all the other components. Frame is 
 * set to be a full-screen application and creates instances of the sub-panels:
 * TaskPanel, InfoPanel, MessagePanel and DrawingPanel which handle their own
 * functionality.
 *
 * @author Alex Mulkerrin
 */
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
        MainFrame mainFrame = new MainFrame();      
    }
}
// fullscreen Graphical User Interface window 
class MainFrame extends JFrame implements WindowFocusListener {
    public MainFrame() {
        setUndecorated(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        setSize((int) tk.getScreenSize().getWidth(), (int) tk.getScreenSize().getHeight());
        setLayout( new BorderLayout());
        
        add(new ScreenPanel());
        setVisible(true); 
        addWindowFocusListener(this);
    }
    // alt-tab closes program
    @Override
    public void windowLostFocus(WindowEvent e) {
        System.exit(0);
    }
    // stub event handler
    @Override
    public void windowGainedFocus(WindowEvent e) {
        
    }
    
}
// Parent panel across entire screen
class ScreenPanel extends JPanel {
    public ScreenPanel() {
        this.setLayout(new GridLayout(0,2));
        this.setBackground(new Color(255,200,255));
             
        this.add(new TaskPanel());
        this.add(new RightPanel());
    }
}
// Screen right side panels
class RightPanel extends JPanel {
    public RightPanel() {
        setBackground(new Color(255,200,200));
        setLayout(new GridLayout(3,0));
        
        add(new InfoPanel());
        add(new MessagePanel());
        add(new DrawingPanel());
    }
}
