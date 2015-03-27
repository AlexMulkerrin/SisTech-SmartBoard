package sistech.WhiteboardGUI;

import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.*;
/**
 * Sub-panel of the GUI which displays time, date, supported individual's name
 * and potentially a weather forecast.A separate thread handles setting the time
 * and date to the correct values.
 *
 * @author Alex Mulkerrin
 */
public class InfoPanel extends JPanel implements Runnable {
    String name = "Joan Smith";
    
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
    String date = dateFormat.format(cal.getTime());
    
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    String time = timeFormat.format(cal.getTime());
    
    String forecast = "Cloudy";
    
    TextBox nameContainer;
    TextBox dateContainer;
    TextBox timeContainer;
    TextBox forecastContainer;
    
    public InfoPanel() {
        setBackground(new Color(200,255,255));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setLayout(new GridLayout(2,2,15,15));
        
        nameContainer = new TextBox("Hello "+name);
        add(nameContainer);
        dateContainer =new TextBox("Today is "+date);
        add(dateContainer);
        timeContainer = new TextBox("and the time is "+time);
        add(timeContainer);

        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            cal = Calendar.getInstance();
            date = dateFormat.format(cal.getTime());
            time = timeFormat.format(cal.getTime());
            timeContainer.setText("and the time is "+time);          
            repaint();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }
    }
    
    public class TextBox extends JTextArea {
        TextBox(String text) {
            setText(text);
            setEditable(false);
            setFont(new Font("Kristen ITC", Font.BOLD, 20));
            this.setMargin(new Insets(20,20,20,20));
        }
    }
    
}
