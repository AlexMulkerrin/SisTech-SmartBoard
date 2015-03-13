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

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

public class DBInformation 
{
    public static ArrayList getReminder(Date date) //Still under construction
    {
        ArrayList<ArrayList<String>> reminders = new ArrayList<ArrayList<String>>();
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
            ResultSet rs = MySQLConnection.stmtQuery(conn, "SELECT " + Columns + " FROM " + Db + " WHERE s_uid = " + S_uid 
                                                        + " AND reminder_task_completed = " + TaskComplete + " ORDER BY " 
                                                        + OrderBy + " LIMIT " + Limit1 + ", " + Limit2);
            
                rs.next();
                System.out.println(rs.getDate("reminder_date").toString());
                while( rs.next())
                {
//                        reminders.add(rs.getDate("reminder_date").toString(), rs.getString("reminder_text"));
                        reminders.add(new ArrayList<String>());
                }
                for(int i=0; i <reminders.size(); i++)
                {
                    System.out.print(reminders.get(i));
                }
           
     
            //System.out.println(reminder);
                
            
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        
        MySQLConnection.connDisconnect(conn);
        MySQLConnection.stmtDisconnect();
        
        
      
        return reminders;
    }
}
