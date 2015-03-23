/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistech;


import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageImage 
{
    /*
     * Method to save the image of the new handwritten message 
     * Parameteres that need to be passed to this method when called are: 
     * Component the handwritten message panel
     * int the user id
     * and call the addmessage method 
     * passing on the parameters ImagePath and MessageStream
     * return type void 
     */
    public static void saveMessage(Component panel, int id)
    {
        
        BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        panel.paint(graphics2D);
        DateFormat df = new SimpleDateFormat("yyyMMddHHmmss");
        Date date = new Date();
        String name = id + df.format(date);
        
        try
        {
           
            ImageIO.write(image, "jpg", new File("images/" + name + ".jpg"));
            System.out.println("panel saved");
            sistech.DBInformation.addMessage("images/" + name + ".jpg", 1);
        }
        catch(Exception e)
        {
            System.out.println("Panel not saved" + e.getMessage());
        }
    }
}
