/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Customer {
    
    public static Connection connect(){
       Connection conn = null;
        
            
            String url = "jdbc:mysql://localhost:3306/limkoinn_902006401_902006390_902007050";
            String userName = "root";
            String password = "";
            try{
                conn = DriverManager.getConnection(url,userName,password);
                
            }
            catch (SQLException e){
            System.err.println(e);    
            }
        
        
        return conn;
    }
    
    public static int custID;
    public static String Name;
    public static String surName;
    public static String Address;
    public static String nextOfKeen;
    public static int roomNo;
    public static int bookingCode;
    
    public static Scanner input = new Scanner(System.in);
    
    public static void AddCustomer(){
        System.out.println("+------------+");
        System.out.println("|ADD CUSTOMER|");
        System.out.println("+------------+");
        System.out.print("Enter Customer Number:");
        custID = input.nextInt();
        System.out.print("Enter Customer Name:");
        Name = input.next();
        System.out.print("Enter Customer Surname:");
        surName = input.next();
        System.out.print("Enter Address:");
        Address = input.next();
        System.out.print("Enter Next Of Keen:");
        nextOfKeen = input.next();
        System.out.print("Enter Room Number:");
        roomNo = input.nextInt();
        System.out.print("Enter Booking Code:");
        bookingCode = input.nextInt();
        String sql = "INSERT INTO customers(CUST_ID,CUSTNAME,CUSTSURNAME,CUST_ADDRESS,NEXT_KIN,ROOMNUMB,BOOKINGCODE) VALUES(?,?,?,?,?,?,?)";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, custID);
            pstmt.setString(2, Name);
            pstmt.setString(3, surName);
            pstmt.setString(4, Address);
            pstmt.setString(5, nextOfKeen);
            pstmt.setInt(6, roomNo);
            pstmt.setInt(7, bookingCode);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("CUSTOMER SCCESSFULLY ADDED");
    }
    public static void DeleteCustomer(){
        System.out.println("+---------------+");
        System.out.println("|DELETE CUSTOMER|");
        System.out.println("+---------------+");
        System.out.print("Enter Customer Number:");
        custID = input.nextInt();
        String sql = "delete from customers  where CUST_ID = ?";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, custID);
            
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("CUSTOMER SUCCESSFULLY DELETED");
    }
    public static void ViewCustomers(){
        System.out.println("+--------------+");
        System.out.println("|VIEW CUSTOMERS|");
        System.out.println("+--------------+");
        
        try{
         Connection conn = null;
         
         String url = "jdbc:mysql://localhost:3306/limkoinn_902006401_902006390_902007050";
            String userName = "root";
            String password = "";
            try{
                conn = DriverManager.getConnection(url,userName,password);
                
            }
            catch (SQLException e){
            System.err.println(e);    
            }
         
         String sql = "SELECT * FROM customers";
         Statement stmnt = conn.createStatement();
         ResultSet rs = stmnt.executeQuery(sql);
         while (rs.next()){
             custID = rs.getInt("CUST_ID");
        Name = rs.getString("CUSTNAME");
        surName = rs.getString("CUSTSURNAME");
        Address = rs.getString("CUST_ADDRESS");
        nextOfKeen = rs.getString("NEXT_KIN");
        roomNo = rs.getInt("ROOMNUMB");
        bookingCode = rs.getInt("BOOKINGCODE");
        
        
        System.out.format("%s, %s, %s, %s, %s, %s\n",custID, Name, surName,Address, nextOfKeen,roomNo, bookingCode);    
         }
     stmnt.close();
     }
     catch (Exception e){
         System.err.println(e);
     }
        
    }
    
    public static void UpdateCustomer(){
        System.out.println("+---------------+");
        System.out.println("|UPDATE CUSTOMER|");
        System.out.println("+---------------+");
        System.out.print("Enter Customer Number:");
        custID = input.nextInt();
        //should find the customer 
        
        System.out.print("Enter New Customer Name:");
        Name = input.next();
        System.out.print("Enter New Customer Surname:");
        surName = input.next();
        System.out.print("Enter New Address:");
        Address = input.next();
        System.out.print("Enter New Next Of Keen:");
        nextOfKeen = input.next();
        System.out.print("Enter New Room Number:");
        roomNo = input.nextInt();
        System.out.print("Enter New Booking Code:");
        bookingCode = input.nextInt();
        String sql = "update customers set CUSTNAME = ?, CUSTSURNAME = ?, CUST_ADDRESS = ?, NEXT_KIN = ?, ROOMNUMB = ?, BOOKINGCODE = ? where CUST_ID = ?";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Name);
            pstmt.setString(2, surName);
            pstmt.setString(3, Address);
            pstmt.setString(4, nextOfKeen);
            pstmt.setInt(5, roomNo);
            pstmt.setInt(6, bookingCode);
            pstmt.setInt(7, custID);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("CUSTOMER SCCESSFULLY UPDATED");
        
    }
    
    
}
