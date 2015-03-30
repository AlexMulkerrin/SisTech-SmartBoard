package sistech.WhiteboardGUI;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
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
    
    Styling.SLabel nameContainer;
    Styling.SLabel dateContainer;
    Styling.SLabel timeContainer;
    Styling.SLabel forecastContainer;
    
    public InfoPanel() {
        setBackground(new Color(200,255,255));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setLayout(new GridLayout(0,3,15,15));
        
        nameContainer = new Styling.SLabel("Hello "+name);
        add(nameContainer);
        dateContainer =new Styling.SLabel("Today is "+date);
        add(dateContainer);
        timeContainer = new Styling.SLabel("and the time is "+time);
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
    
}
