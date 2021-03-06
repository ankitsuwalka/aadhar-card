/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadharcard;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import static java.lang.System.getProperty;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Ankit suwalka
 */
public class UpdateAadhar extends javax.swing.JFrame {

    /**
     * Creates new form CreateNewAadhar
     */
    String  aadharno1;
    long max1=999999,min=100002;
    String path;
    String username;
    String oldpath;
    public UpdateAadhar() {
        
        initComponents();
    }
     public UpdateAadhar(String username,String aadharno) {
        this.username=username;
        String temp="";
        for(int i=0;i<12;i++)
            {
                temp+=aadharno.charAt(i);
            }
        aadharno1=temp;
        aadharno=temp;
        
        initComponents();
        try
        {
        conn c = new conn();
        Statement stmt = c.conn1.createStatement();
        ResultSet rs = stmt.executeQuery("select * from aadhar_info where Aadhar_number = '"+aadharno+"'");
        
        if(rs.next())
        {
        jTextField1.setText(rs.getString(2)); 
        jTextField2.setText(rs.getString(3)); 
        jTextField3.setText(rs.getString(4)); 
        jTextField4.setText(rs.getString(7));
        
        oldpath = rs.getString(8);
        
        jTextField5.setText(rs.getString(5));
        // image for
         BufferedImage img = null;
                try {
             img = ImageIO.read(new File(rs.getString(8)));
                    } 
                catch (Exception ae) {
                    ae.printStackTrace();
                }
                
                Image dimg = img.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(),
                Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                jLabel8.setIcon(imageIcon);
                
                path = rs.getString(8);
                
        //for gender    
        
        String gender = rs.getString(6);
        if(gender.equals("Male"))
        {
        jRadioButton1.setSelected(true);
        }
        else if (gender.equals("Female"))
        {
       
        jRadioButton2.setSelected(true);
        }  
        else
        {
        
        jRadioButton3.setSelected(true);
        }
              
                
        }
        else
        {
        
        }
       
        
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,e);
        }
        
        
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 100));
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("FullName");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 60, 150, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("FatherName");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 100, 170, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("MotherName");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 140, 150, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("DOB");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 190, 110, 20);

        jRadioButton2.setText("Female");
        buttonGroup1.add(jRadioButton2);
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(330, 240, 70, 23);

        jRadioButton3.setText("Other");
        buttonGroup1.add(jRadioButton3);
        jPanel1.add(jRadioButton3);
        jRadioButton3.setBounds(410, 240, 70, 23);

        jRadioButton1.setText("Male");
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(250, 240, 70, 23);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(250, 60, 190, 30);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(250, 100, 190, 30);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(250, 140, 190, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Gender");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 240, 110, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Address");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 300, 120, 40);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(250, 290, 190, 100);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(460, 60, 130, 110);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Attach");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(490, 180, 100, 30);

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 10, 100, 30);

        jButton3.setBackground(new java.awt.Color(0, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Submit Information");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(250, 410, 150, 30);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setText("Camera");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(490, 213, 100, 30);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(250, 190, 110, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("*yyyy-MM-dd");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(370, 190, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userWindow.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int r = chooser.showSaveDialog(null);
        if(r == JFileChooser.APPROVE_OPTION)
        {
        path=chooser.getSelectedFile().getAbsolutePath();
         BufferedImage img = null;
                try {
             img = ImageIO.read(new File(path));
                    } 
                catch (Exception ae) {
                    ae.printStackTrace();
                }
                
                Image dimg = img.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(),
                Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                jLabel8.setIcon(imageIcon);
       
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int a =JOptionPane.showConfirmDialog(null, "Are you Sure");
        if(a == JOptionPane.YES_OPTION)
        {
        try
        {
        conn conn= new conn();
        Statement stmt = conn.conn1.createStatement();
        ResultSet rs = stmt.executeQuery("select * from aadhar_info where Aadhar_number = '"+aadharno1+"'");
        if(rs.next())
        {
            String updatequery = "update aadhar_info set FullName=?,FatherName=?,MotherName=?,DOB =?,Gender=?,Address =? ,imagepath=? where Aadhar_number = '" +aadharno1+"'" ;
            PreparedStatement pstmt = conn.conn1.prepareStatement(updatequery);
            String to=path;
            if(oldpath.equals(path) == false)
            {
            File delete_previous_img = new File(oldpath);
            delete_previous_img.delete();
            File source = new File(path);          
            String extension = FilenameUtils.getExtension(path);
            String temp="";
            
            
            to = System.getProperty("user.dir")+"/src/images/AadharUser/"+temp+"."+extension;
            File dest = new File(to);
            
            FileUtils.copyFile(source, dest);
            }
           
            pstmt.setString(1,jTextField1.getText());  
            pstmt.setString(2,jTextField2.getText());//1 specifies the first parameter in the query  
            pstmt.setString(3,jTextField3.getText());  
            
            
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
//            String strDate= formatter.format(jDateChooser1.getDate());  
//            
            
            pstmt.setString(4,jTextField5.getText());//1 specifies the first parameter in the query
            
            
            if(jRadioButton1.isSelected())
                pstmt.setString(5,"Male");
            else if (jRadioButton2.isSelected())
                pstmt.setString(5,"Female");
            else
            {
                pstmt.setString(5,"Other");
            
            }
           
            pstmt.setString(6,jTextField4.getText());//1 specifies the first parameter in the query  
            pstmt.setString(7,to);  
            
            
            int i=pstmt.executeUpdate();  
            
            
            new UserWindow(username).setVisible(true);
            setVisible(false);
         
        }
       else
       {
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
//            String strDate= formatter.format(jDateChooser1.getDate());  
//            
            
        }
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,String.valueOf(e));
        }
        
        
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         try
        {
            // Just one line and you are done ! 
            // We have given a command to start cmd
            // /K : Carries out command specified by string
            try
        { 
         // We are running "dir" and "ping" command on cmd
         Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"start microsoft.windows.camera: && exit");
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
  
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new UserWindow(username).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateAadhar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateAadhar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateAadhar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateAadhar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateAadhar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
