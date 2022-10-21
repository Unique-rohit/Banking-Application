
package bank.managment.system1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        setLayout(null); 
        this.pinnumber=pinnumber;
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jfif"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(355, 550, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
         Conn c = new Conn();
         int balance =0;
         try{
            ResultSet rs= c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
             System.out.println(e);
        }
        
         JLabel text= new JLabel("Your Current Account Balance is Rs" + balance);
         text.setForeground(Color.black);
         text.setBounds(279,430,600,25);
         image.add(text);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
