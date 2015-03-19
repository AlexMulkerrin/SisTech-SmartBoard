/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistech;

import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MessageImage 
{
    
    public static void saveMessage(Component panel)
    {
        
        BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        panel.paint(image.createGraphics());
        try
        {
           
            ImageIO.write(image, "jpg", new File("images/testing.jpg"));
            System.out.println("panel saved");
            sistech.DBInformation.addMessage("images/testing.jpg", 1);
        }
        catch(Exception e)
        {
            System.out.println("Panel not saved" + e.getMessage());
        }
    }
}
