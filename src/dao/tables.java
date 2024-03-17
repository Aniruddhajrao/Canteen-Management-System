/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author aniru
 */
public class tables {
    public static void main(String[] args){
        try{
            String userTable="create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),mobileNumber varchar(10),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE(email))";
            String adminDetails="insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('Admin','admin@gmail.com','1234567890','India','admin','What primary school did you attend?','ABC','true')";
            String categoryTable="create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
            String ProductTable="create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
            String billTable="create table bill(id int primary key,name varchar(200),mobileNumber varchar(200),email varchar(200),date varchar(50),total varchar(200),createdby varchar(200))";
           Dboperations.setDataOrDelete(adminDetails, "Admin details added successfully");
           Dboperations.setDataOrDelete(userTable, "User Table created successfully");  
           Dboperations.setDataOrDelete(categoryTable, "Category table created successfully");
           Dboperations.setDataOrDelete(ProductTable, "Product table created successfully");
           Dboperations.setDataOrDelete(billTable, "Bill table created successfully");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
}
