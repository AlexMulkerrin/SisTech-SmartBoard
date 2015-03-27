package sistech;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prino_000
 */

import java.sql.*;
import java.util.Calendar;

public class DBInformation 
{
    /*
     * Method to get the reminders from the sql database for a specific date which is passed as a parameter when the method is called.
     * The method will return an 2D String array called reminders with the following format
     * for each instance(reminder) i;
     * reminders[i][0] containes the reminder text
     * reminders[i][1] contains the reminder associated time
     * reminders[i][2] containes the reminder unique table key 
     */
    public static String[][] getReminder(String date) 
    { 
        String[][] reminders = null;
        
        String Columns = "rem_table_key, uid, reminder_date, reminder_time_by, reminder_text, reminder_task_completed";
        String Db = "reminders";
        int S_uid = 1;
        int TaskComplete = 0;
        String OrderBy = "reminder_date ASC, reminder_time_by ASC";
        int Limit1 = 0;
        int Limit2 = 30;
        
        Connection conn = MySQLConnection.connConnect();
        
        try 
        {
            ResultSet rs = MySQLConnection.stmtGetQuery(conn, "SELECT " + Columns + " FROM " + Db + " WHERE s_uid = " + S_uid 
                                                        + " AND reminder_task_completed = " + TaskComplete + " ORDER BY " 
                                                        + OrderBy + " LIMIT " + Limit1 + ", " + Limit2);
            int size = 0;
            while(rs.next())
            {
                
                if( date.equals(rs.getString("reminder_date")))
                {
                size++;
                }
                
            }
            reminders = new String[size][3];
            rs.first();
            int i=0;
            while( rs.next())
            {
                if( date.equals(rs.getString("reminder_date")))
                {   
                    reminders[i][0] = rs.getString("reminder_text");
                    reminders[i][1] = rs.getString("reminder_time_by");
                    reminders[i][2] = rs.getString("rem_table_key");
                    i++;
                }
            }
            
        } catch (SQLException ex) 
        {
            ex.printStackTrace(System.out);
        }
        
        MySQLConnection.connDisconnect(conn);
        MySQLConnection.stmtDisconnect();
        return reminders;
    }
    
    /*
     * Method to remove a specific reminder from the sql database which is passed a 
     * specific reminder unique table key as a parameter when the method is called.
     * return type is void
     */
    public static void editReminder(String key, boolean check)
    {
        Connection conn = MySQLConnection.connConnect();
        
        try
        {
            if(check == true)
            {
            MySQLConnection.stmtAmmendQuery(conn, "UPDATE reminders SET reminder_task_completed = 1 WHERE rem_table_key = " + key);
            }
            else
            {
                MySQLConnection.stmtAmmendQuery(conn, "UPDATE reminders SET reminder_task_completed = 0 WHERE rem_table_key = " + key);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
                
    }
    
    /*
     * Method to get the messages from the sql database 
     * The method will return a 2D String array called messages with the following format
     * for each instance(message) i;
     * messages[i][0] contains the message text
     * messages[i][1] contains the message time
     * messages[i][2] contains the message date
     * messages[i][3] contins the unique id of the message sender
     * messages[i][4] contains the unique message stream id
     */
    public static String[][] getMessages()
    {
        
        String[][] messages = null;
        String Columns = "message_stream, message_type, s_uid, uid, message_number, image_message_path"
                            + ", typed_message_text, message_time, message_date";   //The columns that of data that individual instances are to be extracted from
        String Db = "messages"; //The database that the query is applied to
        int S_uid = 1;  //The support users personal identification number
        int uid = 1;    //T
        String messageStream = "message_stream"; // The conversation unique identification number
        String order = "message_number";    //The order number of each message
        
        Connection conn = MySQLConnection.connConnect();
        
        try 
        {
            //The sql query to be sent 
            ResultSet rs = MySQLConnection.stmtGetQuery(conn, "SELECT " + Columns + " FROM " + Db + " WHERE s_uid = " + S_uid 
                                                        + " AND uid = " + uid + " AND message_Stream = " + messageStream 
                                                        + " ORDER BY " + order);
            // Determine the number of messages so that the array size can be specified ready for returning 
            rs.last();
            int size = rs.getRow();
            messages = new String[size][5];
            //Loop through the result set of messages while on each iteration placing the message text, time, date and user id into the appropriate array locations
            rs.first();
            int i=0;
            while( rs.next())
            {
                    messages[i][0] = rs.getString("typed_message_text");
                    messages[i][1] = rs.getString("message_time");
                    messages[i][2] = rs.getString("message_date");
                    messages[i][3] = rs.getString("uid");
                    messages[i][4] = rs.getString("message_stream");
                    i++;
            }
            
        } catch (SQLException ex) 
        {
        }
        //Call sql connection and pass on the query statement 
        MySQLConnection.connDisconnect(conn);
        MySQLConnection.stmtDisconnect();
        return messages;
    }
    /*
     * Method to add a new handwritten message to the sql database
     * when called the parameters imagePath of type string and mStream of type int must be passed. 
     * return type void
     */
    public static void addMessage(String imagePath, int mStream)
    {
        int Suid = 1;
        int uid = 1;
        Character mType = 'I';
        String mTime = "010101"; // To be changed to current message sent time 
        Calendar calendar = Calendar.getInstance();
        java.sql.Date mDate = new java.sql.Date(calendar.getTime().getTime());
        
        Connection conn = MySQLConnection.connConnect();
        
        try
        {
            MySQLConnection.stmtAmmendQuery(conn, "INSERT INTO messages(message_stream,s_uid,uid,message_type,image_message_path,message_time,message_date)"   
                    + " VALUES ('"+mStream+"','"+Suid+"','"+uid+"','"+mType+"','"+imagePath+"','"+mTime+"','"+mDate+"')");
                   //  + "VALUE (" + "\"" + mStream + "\"" + S_uid + "\"" + uid + "\"" + mType + "\"" + imagePath + "\"" + ");");                               
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

