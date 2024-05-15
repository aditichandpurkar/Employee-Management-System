
package emolyeemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername,tfpassword;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");//text will be seen on the frame
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
        //box in front of label
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
         tfpassword= new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        
        
        
        
        


        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        //taking out the values after clicking button
        try{
            String username = tfusername.getText();//get the value from textfield
            
            String password = tfpassword.getText();
            
            Conn c = new Conn();//to use statement make an obj of the class
            
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            //connectivity 
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();//object of the home class
            }else{
                JOptionPane.showMessageDialog(null, "Invaild username or password");
                setVisible(false);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
        
    
    

public static void main(String[] args){
    new Login();
}
}



