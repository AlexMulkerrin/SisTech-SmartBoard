package sistech.WhiteboardGUI;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Alex Mulkerrin
 */
public class InfoPanel extends JPanel{
    public InfoPanel() {
        setBackground(new Color(200,255,255));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setLayout(new GridLayout(2,2));
        add(new JLabel("Name"));
        add(new JLabel("Date"));
        add(new JLabel("Time"));
        add(new JLabel("Forecast"));
    }
    
}
