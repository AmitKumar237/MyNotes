package com.example.mynotes;
import java.util.*;
import java.sql.*;

public class JdbcConnection
{
    public static Connection con;
    public Connection getConection()
    {
        return con;
    }

public void createConnection()
{
try
{
    Class.forName("com.mysql.cj.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/note", "admin", "amit2307");
    if(con.isClosed())
    {
        System.out.println("Connection is closed");
    }
    else
    {
        System.out.println("Connecton Created...");
    }

}
catch (Exception e)
{
   e.printStackTrace();
}
}
}
