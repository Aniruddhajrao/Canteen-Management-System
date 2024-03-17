/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.User;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author aniru
 */
public class UserDao {
    public static void save(User user){
        String query="insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
        Dboperations.setDataOrDelete(query, "Registered successfully! Wait for Admin Approval ");
    }
    public static User Login(String email,String password){
        User user=null;
        try{
            ResultSet rs=Dboperations.getData("select * from user where email='"+email+"'and password='"+password+"'");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
    public static User getSecurityQuestion(String email){
        User user=null;
                try{
                    ResultSet rs=Dboperations.getData("Select * from user where email='"+email+ "'");
                    while (rs.next()){
                        user=new User();
                        user.setSecurityQuestion(rs.getString("securityQuestion"));
                        user.setAnswer(rs.getString("answer"));
                    }
                        
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
                return user;
    }
    public static void update(String email,String newPassword){
        String query = "update user set password = '"+newPassword+"' where email='" +email+"'";
        Dboperations.setDataOrDelete(query,"Password changed Successfully");
    }
   public static ArrayList<User> getAllRecords(String email){
       ArrayList<User> arrayList= new ArrayList<>();
        try {
         ResultSet rs= Dboperations.getData("select * from user where email like '%"+email+"'");
         while(rs.next()){
             User user= new User();
             user.setId(rs.getInt("id"));
             user.setEmail(rs.getString("email"));
             user.setMobileNumber(rs.getString("mobileNumber"));
             user.setAddress(rs.getString("address"));
             user.setSecurityQuestion(rs.getString("securityQuestion"));
             user.setStatus(rs.getString("status"));
             arrayList.add(user);
            }
        }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
   }
   public static void changeStatus(String email,String status){
       String query="update user set status='"+status+"' where email= '"+email+"'";
       Dboperations.setDataOrDelete(query,"Status changed successfully");
       
   }
   public static void changePassword(String email,String oldPassword,String newPassword){
       try{
           ResultSet rs=Dboperations.getData("select * from user where email='"+email+"' and Password ='"+oldPassword+"'");
           if(rs.next()){
               update(email, newPassword);
           }
           else{
               JOptionPane.showMessageDialog(null,"old password is Wrong");
           }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
   }
}
    

