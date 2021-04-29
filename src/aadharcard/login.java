/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadharcard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;
import java.time.Instant;

/**
 *
 * @author Ankit suwalka
 */
public class login extends JFrame implements ActionListener{
     JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField jp2;
    JPanel P1,P2,P3;
    JButton b1,b2,b3;
    ImageIcon image;
    String username;
    login()
    {
    
    l1 = new JLabel("UserName");
    l2 = new JLabel("Password");
    
    setLayout(new BorderLayout(10,10));
    P1 = new JPanel();
    
    P1.setLayout(new GridLayout(3,3,10,10));
    
    tf1 = new JTextField(20); 
    jp2 =  new JPasswordField(20);
    P1.add(l1);
    P1.add(tf1);
    
    P1.add(l2);
    P1.add(jp2);
    
   
    
    b1 = new JButton("Sign In");
    b2 = new JButton("Sign Up");
    P1.add(b1);
    P1.add(b2);
    P2 = new JPanel();
    JPanel P3 = new JPanel();
    P2.setPreferredSize(new Dimension(320,20));
    P3.setPreferredSize(new Dimension(320,20));
    
    add(P2,BorderLayout.SOUTH);
    add(P1,BorderLayout.CENTER);
    add(P3,BorderLayout.NORTH);
    JButton Back = new JButton("Back");
    Back.addActionListener(new ActionListener()
    {
    
    public void actionPerformed(ActionEvent e)
    {
    new index().setVisible(true);
    setVisible(false);
    }
    }
    
    );
    
    P3.setLayout(new GridLayout(1,1));
    P3.add(Back);
    P3.setBackground(Color.red);
    
    b1.addActionListener(new ActionListener(){
    
     public void actionPerformed(ActionEvent ae) {
      try
      {
      conn c1 = new conn();
      Statement stmt = c1.conn1.createStatement();
      ResultSet rs1 = stmt.executeQuery("select * from user where username = '"+tf1.getText()+"'");
      String q1 = tf1.getText();
      String password =jp2.getText();
      
      if(rs1.next())
      {
          String lstlogin = " lastlogin "+ rs1.getString("lastlogin");
      Encryption obj = new Encryption(password,rs1.getString(8),2);
      
      if(rs1.getString("password").equals(obj.generatedPassword))
      {
            JOptionPane.showMessageDialog(null, "Login");
            PreparedStatement pstmt = c1.conn1.prepareStatement("update user set Lastlogin=? where username=?");
            
            Timestamp instant = Timestamp.from(Instant.now());
            pstmt.setString(1,String.valueOf(instant));
            
            
            pstmt.setString(2,q1);
            pstmt.executeUpdate();
            new UserWindow(tf1.getText()+lstlogin).setVisible(true);
            setVisible(false) ;
            
      }
       else
       {
            JOptionPane.showMessageDialog(null, "Enter Valid Password");
            
        }
      
      }
      else
      {
      JOptionPane.showMessageDialog(null,"Enter Valid UserName");
      
      }
      }
      catch(Exception e)
      {
       JOptionPane.showMessageDialog(null, e.toString());
      
      }   
    }
    
    }
    
    );
    
    b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent a)
    {
     
    new SignUp().setVisible(true);
    setVisible(false);
    }
   
    }
    );
    
   
    
    setSize(320,200);
    setResizable(false);
    setLocation(340,270);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
   
}
