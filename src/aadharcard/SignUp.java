/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadharcard;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.lang.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ankit suwalka
 */
public class SignUp extends JFrame{
    int UniqueID;
    int a ;
    int min = 100001,max = 999999;
    JPanel p1,p2,p3;
    JLabel jl1 , jl2, jl3,jl4,jl5;
    JButton b1 , b2, b3,b4;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JDateChooser chooser = new  JDateChooser() ;
    SignUp()
    { 
     super("Sign Up");
    setLayout(new BorderLayout(10,10));
    jl1  = new JLabel ("Full Name");
    jl2  = new JLabel ("Address");
    jl3  = new JLabel ("DOB");
    jl4  = new JLabel ("MobileNo");
    jl5  = new JLabel ("Password");
    
    
    tf1  = new JTextField(30);
    tf2  = new JTextField (40);
    tf3  = new JTextField (30);
    tf4  = new JTextField (15);
    tf5  = new JTextField (20);
    
    
    b1= new JButton("Submit") ;
    b1.addActionListener(new ActionListener(){
    
        
     public void actionPerformed(ActionEvent ae) {
      
       
       
       
      
      try
      {
      conn c1 = new conn();
      Statement stmt = c1.conn1.createStatement();
      String LicenseKey = JOptionPane.showInputDialog(null,"Enter license Key  ");
      String hashKey = JOptionPane.showInputDialog(null,"hash key ");
      ResultSet rs1 = stmt.executeQuery("select * from licensekey where LicenseKey = '"+new Encryption(LicenseKey,hashKey,1).generatedPassword+"'");
      if(rs1.next())
      {
      
      UniqueID  = (int)(Math.random()*(max-min+1)+min);
      String q1 = String.valueOf(UniqueID);
      ResultSet rs = stmt.executeQuery("select * from user where username = '"+q1+"'");
      if(rs.next())
      {
            JOptionPane.showMessageDialog(null, "Clicked Again to Submit Again to Generate Unique iD");
            
      }
       else
       {
           SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
             String strDate= formatter.format(chooser.getDate());  
             UUID uuid =UUID.randomUUID();
             Encryption password1 = new Encryption(tf5.getText(),uuid); 
             
            String output = "User Created SucessFully \n username :" +q1 +"\n Password"+tf5.getText();
            JOptionPane.showMessageDialog(null, output);
            
            
            //insert Record in user table (Full Name,Address,DOB,MobileNo,username,password)
            System.out.println(strDate);
            String query ="insert into user values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt2=c1.conn1.prepareStatement(query);  
            pstmt2.setString(1,tf1.getText());//1 specifies the first parameter in the query  
            pstmt2.setString(2,tf2.getText());  
            pstmt2.setString(3,strDate);//1 specifies the first parameter in the query  
            pstmt2.setString(4,tf4.getText());  
            pstmt2.setString(5,q1);
            
            //for PassWord
            
            pstmt2.setString(6,password1.generatedPassword);
            Timestamp instant = Timestamp.from(Instant.now());
            pstmt2.setString(7,String.valueOf(instant));
            pstmt2.setString(8,String.valueOf(uuid));
            int i1 = pstmt2.executeUpdate();
            System.out.println(i1+" records inserted in user table");
            new login().setVisible(true);
            setVisible(false);
        }
      }
      else
      {
          JOptionPane.showMessageDialog(null, "Enter A Valid Key");
      
      }
      
      }
      catch(Exception e)
      {
      System.out.println(e);
      }   
    }
    
    }
    
    );
    
    b2= new JButton("Back") ;
    b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
    new login().setVisible(true);
    setVisible(false);
    
    
    }
    
    
    });
    
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    
    p2.setLayout(new GridLayout(6,2,5,10));
    p2.add(jl1);
    p2.add(tf1);
    p2.add(jl2);
    p2.add(tf2);
    p2.add(jl3);
    p2.add(chooser);   
    p2.add(jl4);
    p2.add(tf4);
    p2.add(jl5);
    p2.add(tf5);
    p2.add(b1);
    p2.add(b2);
    
    
    
    p1.setPreferredSize(new Dimension(300,20));
    p1.setLayout(new GridLayout(1,1));
    JButton headLine = new JButton("New User");
    headLine.setBackground(Color.GREEN);
    headLine.setEnabled(false);
    p1.add(headLine);
    
    
    p3.setLayout(new GridLayout(1,1));
    JButton BottomLine = new JButton("Fill Details Carefully");
    BottomLine.setBackground(Color.BLUE);
    BottomLine.setEnabled(false);
    p3.add(BottomLine);
    
    
    p3.setPreferredSize(new Dimension(300,20));
    
    add(p1,BorderLayout.NORTH);
    add(p2,BorderLayout.CENTER);
    add(p3,BorderLayout.SOUTH);
    
    setSize(300,300);
    setResizable(false);
    setLocation(340,270);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    }
    public static void main(String []args)
    {
   new SignUp();
    }
}
