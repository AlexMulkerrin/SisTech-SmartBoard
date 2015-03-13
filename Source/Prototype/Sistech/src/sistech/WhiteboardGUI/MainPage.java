/*  Basic canvas painter Demo
*   author Alex Mulkerrin
*   date 12/3/15 
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        this.setBorder(new TextBubbleBorder(Color.BLACK,12,16,0));
             
        this.add(new TopPanel(), BorderLayout.NORTH);
        this.add(new MiddlePanel(), BorderLayout.CENTER);
    }
}
// Screen topline with important info: patient name and current date
class TopPanel extends JPanel {
    public TopPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(Box.createHorizontalGlue());
        this.add(new JLabel("Name"));
        this.add(Box.createHorizontalGlue());
        this.add(new JLabel("Date"));
    }
}

class MiddlePanel extends JPanel {
    public MiddlePanel() {
        this.setLayout(new GridLayout(1,2));
        // alas I cannot turn this into a constructor D:
        JScrollPane pane = new JScrollPane(new TaskPanel());
        pane.setBackground(Color.white);
        pane.setViewportBorder(null);
        this.add(pane);
        this.add(new MessagePanel());
    }
}

class MessagePanel extends JPanel {
    
    public MessagePanel() {
        this.setBackground(Color.white);
        this.add(new DrawingPanel());
    }
}

class TaskPanel extends JPanel {
    public TaskPanel() {
        this.setBorder(new TextBubbleBorder(Color.RED,4,16,0));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(31,0));
        DayPane[] day = new DayPane[31];
        for (int i=0; i<31; i++) {
            day[i] = new DayPane();
        }
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        
        int monthLength=31;
        if (month ==2) {
            monthLength=28;            
        } else if (month == 9 || month == 4 || month == 6 || month == 11) {
            monthLength=30;            
        }
        
        for (int i=0; i<monthLength; i++) {
            day[i].addTask(i+1,month,year); //days start at 1 not 0   
            this.add(day[i]);
        }
    }
}

class DayPane extends JPanel {
    public DayPane() {
        //TODO set defaults?
    }
    
    public void addTask(int day, int month, int year) {
        JLabel date = new JLabel(day + "-" + month + "-" + year);
        date.setBackground(Color.white);
        this.add(date, BorderLayout.WEST);
        
        //Calendar cal = Calendar.getInstance();
        //java.sql.Date dateCheck = new java.sql.Date(year, month, day);
        String dateString = "";
        if (month < 10) {
            if (day<10) {
                dateString = year+"-0"+month+"-0"+day;
            } else {
                dateString = year+"-0"+month+"-"+day;
            }
        } else {
            if (day<10) {
                dateString = year+"-"+month+"-0"+day;
            } else {
                dateString = year+"-"+month+"-"+day;
            }
        }
        //ArrayList reminders = sistech.DBInformation.getReminder(dateString);
        
        String messageString ="/n";
//        for (int i=0; i<reminders.size(); i++) {
//            System.out.println(reminders.get(i).toString());
//            messageString= messageString + reminders.get(i).toString() +"/n";
//        }
//        
//        JLabel message = new JLabel(messageString);
//        
//        this.add(message, BorderLayout.CENTER);
        this.add(date, BorderLayout.WEST);
        this.setBorder(new TextBubbleBorder(Color.BLUE,2,16,0));
    }
}




// old code with input hooks, incorporate into screen panel?
class DrawingPanel extends JPanel {
       
    RedSquare redSquare = new RedSquare();
       
        
    public DrawingPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

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
        g.drawString("Write Here", 10, 20);
        redSquare.paintSquare(g);
    }
}

class RedSquare {
    private int xPos = 50;
    private int yPos = 50;
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