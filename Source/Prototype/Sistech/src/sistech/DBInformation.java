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
            
            rs.last();
            int size = rs.getRow();
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
    
    public static void getMessages()
    {
        
    }
}
