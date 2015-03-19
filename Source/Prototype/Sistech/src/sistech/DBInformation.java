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

public class DBInformation 
{
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
        }
        
        MySQLConnection.connDisconnect(conn);
        MySQLConnection.stmtDisconnect();
        return reminders;
    }
    
    public static void removeReminder(String key)
    {
        Connection conn = MySQLConnection.connConnect();
        
        try
        {
            MySQLConnection.stmtAmmendQuery(conn, "DELETE FROM reminders WHERE rem_table_key = " + key);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
                
    }
    
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
    
    public static void addMessage(String image_path, int message_stream)
    {
        int S_uid = 1;
        int uid = 1;
        String type = "I";
        
        Connection conn = MySQLConnection.connConnect();
        
        try
        {
            MySQLConnection.stmtAmmendQuery(conn, "INSERT INTO messages( message_stream, message_type, S_uid, uid, image_message_path) VALUES ( " 
                    + message_stream + ", " + type + ", " + S_uid + ", " + uid + ", " + image_path + ")");
                                                    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
