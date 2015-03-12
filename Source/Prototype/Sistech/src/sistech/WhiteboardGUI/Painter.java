/*  Basic canvas painter Demo
*   author Alex Mulkerrin
*   date 12/3/15 
*/
package sistech.WhiteboardGUI;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

public class Painter {

    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+ SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Painter Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    }
}

class MyPanel extends JPanel {
       
       private int squareX = 50;
       private int squareY = 50;
       private int squareW = 50;
       private int squareH = 50;
        
        public MyPanel() {
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    moveSquare(e.getX(),e.getY());
                }
            });
            
            addMouseMotionListener(new MouseAdapter() {
                public void mouseDragged(MouseEvent e) {
                    moveSquare(e.getX(),e.getY());
                }
            });          
        }

        private void moveSquare(int x, int y) {
                int OFFSET = 0;
                if ((squareX!=x) || (squareY!=y)) {
                    //repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
                    squareX=x;
                    squareY=y;
                    repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
                }
            }
        
        public Dimension getPreferredSize() {
            return new Dimension(600,900);
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // draw text
            g.drawString("This is my cutom panel", 10, 20);
            g.setColor(Color.RED);
            g.fillRect(squareX, squareY, squareW, squareH);
            g.setColor(Color.BLACK);
            g.fillRect(squareX, squareY, squareW, squareH);
        }
    }


