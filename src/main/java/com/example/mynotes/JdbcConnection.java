package com.example.mynotes;
import java.util.*;
import java.sql.*;

public class JdbcConnection {
public static  void main(String[] args)
{
try
{
   // Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/note", "root", "tan@3006");
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
