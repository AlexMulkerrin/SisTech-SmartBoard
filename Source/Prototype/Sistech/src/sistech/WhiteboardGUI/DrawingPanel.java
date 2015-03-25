package sistech.WhiteboardGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
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
        
        JLabel tip = new JLabel("Write here ");

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new clearButtonListener());
        add(clearButton);
        
        sendButton = new JButton("Send");
        sendButton.addActionListener(new sendButtonListener());
        add(sendButton);
        
        drawingCanvas = new CanvasPanel();
        add(drawingCanvas);
                
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
            String message="Sending message...";
            sendButton.setText(message);
            
            // needs to be in different thread!
            sistech.MessageImage.saveMessage(drawingCanvas, 1);
            
            points.clear();
            drawingCanvas.repaint();

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
            Point p2 = null;
            g.setColor(Color.red);
            for (Point p : points) {
                p2 = p1;
                p1 = p;
                if (p1 != null && p2 != null) {
                    g.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }
        }
        
        
    }
}