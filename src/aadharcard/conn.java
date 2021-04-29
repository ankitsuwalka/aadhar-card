/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadharcard;
import java.sql.*;
/**
 *
 * @author Ankit suwalka
 */
public class conn {
    Connection conn1;
    conn()
    {
     try
     {
    Class.forName("com.mysql.jdbc.Driver");
    conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/aadharcard","root","");
     }      
     catch(Exception e)
     {
     System.out.println(e);
     }
    }   
         
            
}
