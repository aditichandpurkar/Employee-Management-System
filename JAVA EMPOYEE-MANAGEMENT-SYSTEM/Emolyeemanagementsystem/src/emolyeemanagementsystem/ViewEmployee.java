
package emolyeemanagementsystem;
import javax.swing.*;
 import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class ViewEmployee extends JFrame implements ActionListener{
    JTable table;//To insert data 
    Choice cemployeeid;//dropdown
    JButton search,update,print,back;
ViewEmployee(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel searchlbl = new JLabel("Search by Employee id");
    searchlbl.setBounds(20,20,150,20);
    add(searchlbl);
    
    cemployeeid = new Choice();
    cemployeeid.setBounds(180, 20, 150, 20);
    add(cemployeeid);
try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from employee");
        
        
        while(rs.next()){
            cemployeeid.add(rs.getString("empId"));//picking up the column
        }
        
    }catch (Exception e){
        e.printStackTrace();
    }
    
    
    
    
    table = new JTable();
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from employee");
        table.setModel(DbUtils.resultSetToTableModel(rs));    
        
    }catch (Exception e){
        e.printStackTrace();
        
    }
    //to overcome the overflow of the data we use to add scrollbar 
    JScrollPane jsp = new JScrollPane(table); //obj that we want to appear on the table
    jsp. setBounds(0,100,900,600);
    add(jsp);
    
    search = new JButton("Search");
    search.setBounds(20,70,80,20);
    search.addActionListener(this);
    add(search);
    
    print = new JButton("Print");
    print.setBounds(120,70,80,20);
    print.addActionListener(this);
    add(print);
    
    update = new JButton("Update");
    update.setBounds(220,70,80,20);
    update.addActionListener(this);
    add(update);
    
    back = new JButton("Back");
    back.setBounds(320,70,80,20);
    back.addActionListener(this);
    add(back);
    
    
    
    setSize(900, 700);
    setLocation(300, 100);
    setVisible(true);
    
    
    
}
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==search){
        String query = "select * from employee where empID = '"+cemployeeid.getSelectedItem()+"'";
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }else if (ae.getSource()== print){
        try{
            table.print();//print on table
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }else if (ae.getSource()== update){
        setVisible(false);
        new UpdateEmployee(cemployeeid.getSelectedItem());
        
    }else {
        setVisible(false);
        new Home();
    }
}
public static void main(String[] args){
new ViewEmployee();
}
}
