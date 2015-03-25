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
    String name = "Ernesto";
    
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
    String date = dateFormat.format(cal.getTime());
    
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    String time = timeFormat.format(cal.getTime());
    
    String forecast = "Cloudy";
    
    JLabel nameContainer;
    JLabel dateContainer;
    JLabel timeContainer;
    JLabel forecastContainer;
    
    public InfoPanel() {
        setBackground(new Color(200,255,255));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setLayout(new GridLayout(3,2));
        nameContainer = new JLabel("Name: "+name);
        add(nameContainer);
        dateContainer = new JLabel("Date: "+date);
        add(dateContainer);
        timeContainer = new JLabel("Time: "+time);
        add(timeContainer);
        forecastContainer = new JLabel("Forecast: "+forecast);
        add(forecastContainer);
        
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            cal = Calendar.getInstance();
            date = dateFormat.format(cal.getTime());
            time = timeFormat.format(cal.getTime());
            timeContainer.setText("Time: "+time);          
            repaint();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }
    }
    
}
