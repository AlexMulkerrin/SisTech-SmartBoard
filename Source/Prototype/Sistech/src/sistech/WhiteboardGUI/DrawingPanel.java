package sistech.WhiteboardGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Sub-panel containing drawing Canvas where user writing is recorded and 
 * buttons for erasure and submission of written message.
 *
 * @author Alex Mulkerrin
 */
public class DrawingPanel extends JPanel {
    
    JButton clearButton;
    JButton sendButton;
    CanvasPanel drawingCanvas;
       
    ArrayList<Point> points = new ArrayList<>();
         
    public DrawingPanel() {
        
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new BorderLayout());
        
        JPanel panelTopBar = new JPanel();
        panelTopBar.setBackground(new Color(255,200,200));
        JLabel tip = new Styling.SLabel("Write here:");
        panelTopBar.add(tip);

        JPanel panelSideBar = new JPanel();
        panelSideBar.setLayout(new GridLayout(2,0,0,100));
        
        clearButton = new Styling.SButton("Clear");
        clearButton.addActionListener(new clearButtonListener());
        panelSideBar.add(clearButton);
        
        sendButton = new Styling.SButton("Send");
        sendButton.addActionListener(new sendButtonListener());
        panelSideBar.add(sendButton);
        add(panelSideBar, BorderLayout.EAST);
        
        add(panelTopBar, BorderLayout.NORTH);
        
        
        drawingCanvas = new CanvasPanel();
        add(drawingCanvas, BorderLayout.CENTER);            
    }
    
    public class clearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {            
            points.clear();
            drawingCanvas.repaint();
        }
    }
    
    public class sendButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            //disable button till Database access is complete
            String message="Sending message...";
            sendButton.setText(message);
            sendButton.setEnabled(false);
            
            Thread t = new Thread(new MessageSender());
            t.start();   
        }
    }
    
    public class MessageSender implements Runnable {
        @Override
        public void run() {
            String message="message failed";
            try {
                sistech.MessageImage.saveMessage(drawingCanvas, 1);
                message = "message sent";
            } catch (Exception ex) {
                message="message failed";
            }
            
            // not sure about having this always happening, if it fails, keep image?
            points.clear();
            drawingCanvas.repaint();
        
            sendButton.setText(message);
            sendButton.setEnabled(true);
            try {
                Thread.sleep(5000);
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
            
            sendButton.setText("Send");
        }
    }
    
    public class CanvasPanel extends JPanel {
        public CanvasPanel() {
            setBackground(new Color(255,255,255));
            
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Point p = null;
                    points.add(p);
                }
            });
        
            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    points.add(e.getPoint());
                    repaint();
                }
            });
        }
        
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600,300);
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Point p1 = null;
            Point p2;
            g.setColor(Color.red);
            for (Point p : points) {
                p2 = p1;
                p1 = p;
                if (p1 != null && p2 != null) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setStroke(new BasicStroke(10));
                    g2.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }
        }    
    }
    
}
