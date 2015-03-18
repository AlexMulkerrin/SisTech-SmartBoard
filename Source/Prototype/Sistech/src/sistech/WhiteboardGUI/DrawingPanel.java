package sistech.WhiteboardGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Alex Mulkerrin
 */
public class DrawingPanel extends JPanel implements ActionListener {
    
    JButton clearButton;
    JButton sendButton;
       
    RedSquare redSquare = new RedSquare();
       
        
    public DrawingPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        clearButton = new JButton("Clear");
        add(clearButton);
        go();
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });          
    }

    public void go() {
        clearButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        String message="UpdateFailed :(";
        clearButton.setText(message);
                
    }
    
    
    private void moveSquare(int x, int y) {
        //current square state, stored as final variables
        // to avoid repeat invocations of the same methods
        final int CURR_X = redSquare.getX();
        final int CURR_Y = redSquare.getY();
        final int CURR_W = redSquare.getWidth();
        final int CURR_H = redSquare.getHeight();
        final int OFFSET = 0;

        if ((CURR_X!=x) || (CURR_Y!=y)) {
            // the square is moving, repaint background
            // over the old square location
            //repaint(CURR_X, CURR_Y, CURR_W+OFFSET, CURR_H+OFFSET);
            // update coordinates
            redSquare.setX(x);
            redSquare.setY(y);
            repaint(redSquare.getX(), redSquare.getY(), 
                    redSquare.getWidth()+OFFSET, 
                    redSquare.getHeight()+OFFSET);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,900);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw text
        //g.drawString("Write Here", 10, 20);
        redSquare.paintSquare(g);
    }
}

class RedSquare {
    private int xPos = -50;
    private int yPos = -50;
    private int width = 20;
    private int height = 20;
    
    public void setX(int xPos) {
        this.xPos = xPos;
    }
    public int getX() {
        return xPos;
    }
    
    public void setY(int yPos) {
        this.yPos = yPos;
    }
    public int getY() {
        return yPos;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void paintSquare(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(xPos,yPos,width,height);
//        g.setColor(Color.BLACK);
//        g.drawRect(xPos,yPos,width,height); 
    }
}
