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
    
    JTextArea nameContainer;
    JTextArea dateContainer;
    JTextArea timeContainer;
    JTextArea forecastContainer;
    
    public InfoPanel() {
        setBackground(new Color(200,255,255));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setLayout(new GridLayout(2,2,15,15));
        nameContainer = new JTextArea("Name: "+name);
        nameContainer.setEditable(false);
        add(nameContainer);
        dateContainer = new JTextArea("Date: "+date);
        dateContainer.setEditable(false);
        add(dateContainer);
        timeContainer = new JTextArea("Time: "+time);
        timeContainer.setEditable(false);
        add(timeContainer);
        forecastContainer = new JTextArea("Forecast: "+forecast);
        forecastContainer.setEditable(false);
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
