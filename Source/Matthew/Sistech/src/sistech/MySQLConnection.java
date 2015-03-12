package sistech;

//STEP 1. Import required packages
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection 
{
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   //static final String DB_URL = "jdbc:mysql://localhost/menagerie"; //Test database url on home computer
   static final String DB_URL = "jdbc:mysql://mysql.abdn.ac.uk:3306/t02hah14_sistech";

   //  Database credentials
   static final String USER = "t02hah14_sistech";
   //static final String USER = "root"; //Test user name on home computer
   static final String PASS = "sistech";
   //static final String PASS = "password";  //Test password on home computer
   
   static ResultSet rs;
   static Statement st;
   
   public static Connection connConnect()
    {
    Connection conn = null;
    Statement stmt = null;
    try{
        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
      
     
      
        
    }catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
    }catch(Exception e)
    {
        //Handle errors for Class.forName
        e.printStackTrace();
    }
    return conn;
    }//end main
   
   public static ResultSet stmtQuery(Connection conn, String query)
   {
       rs = null;
       st = null;
       
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
   
   public static void connDisconnect(Connection conn)
   {
       try 
       {
            conn.close();
       } catch (SQLException ex) 
       {
            //Handle errors for JDBC
            ex.printStackTrace();
       }
   }
   
   public static void stmtDisconnect()
   {
       try
       {
           if (rs != null)
           {
               rs.close();
           }
           if (st != null);
           {
               st.close();
           }
       }
       catch(SQLException ex)
       {
           ex.printStackTrace();
       }
               
   }
}//end MySQLConnection
