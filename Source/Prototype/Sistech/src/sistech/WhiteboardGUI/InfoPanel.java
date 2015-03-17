package sistech.WhiteboardGUI;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Alex Mulkerrin
 */
public class InfoPanel extends JPanel implements ActionListener {
    String name = "Ernesto";
    
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
    String date = sdf.format(cal.getTime());
    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
    String time = sdf2.format(cal.getTime());
    String forecast = "Cloudy";
    JLabel nameContainer;
    JLabel dateContainer;
    JLabel timeContainer;
    JLabel forecastContainer;
    JButton updateButton;
    
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
        
        updateButton = new JButton("UpdateInformation");
        add(updateButton);
        goEvent();
    }
    
    public void goEvent() {
        updateButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
    cal = Calendar.getInstance();
    date = sdf.format(cal.getTime());
    time = sdf2.format(cal.getTime());
    timeContainer.setText("Time: "+time);
                
    }
    
}
