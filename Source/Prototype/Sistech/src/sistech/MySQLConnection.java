package sistech;

//Import required packages
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection 
{
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://mysql.abdn.ac.uk:3306/t02hah14_sistech";

   //  Database credentials
   static final String USER = "t02hah14_sistech";
   static final String PASS = "sistech";
   
   static ResultSet rs;
   static Statement st = null;
   static Connection conn = null;
   
   public static Connection connConnect()
    {
    try{
        //Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //Open a connection
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
      
     
      
        
    }catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    return conn;
    }//end main
   
   public static ResultSet stmtGetQuery(Connection conn, String query)
   {
       try
       {
            st = conn.createStatement();
            rs = st.executeQuery(query);
       }
       catch(SQLException ex)
       {
           ex.printStackTrace();
       }
       
       return rs;
   }
   
   public static void stmtAmmendQuery(Connection conn, String query)
   {
       try
       {
            st = conn.createStatement();
            st.executeUpdate(query);
       }
       catch(SQLException ex)
       {
           ex.printStackTrace();
       }
   }
   
   public static void Disconnect()
   {
        try 
       {
           if (st != null);
           {
               st.close();
           }
       }
        catch(SQLException ex)
       {
           ex.printStackTrace();
       }
        try
        {
           if (conn != null) 
           {
               conn.close();
           }
       }
        catch(SQLException ex)
       {
           ex.printStackTrace();
       }    
   }
}//end MySQLConnection
