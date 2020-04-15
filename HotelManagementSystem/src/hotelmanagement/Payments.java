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


public class Payments {
    
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
    
    public static int paymentNo;
    public static float amount;
    public static int roomNo;
    public static int custId;
    public static int tillNo;
    public static int staffCode;
    
    public static Scanner input = new Scanner(System.in);
    
    public static void AddPayment(){
        
        
        
        System.out.println("+-----------+");
        System.out.println("|ADD PAYMENT|");
        System.out.println("+-----------+");
        System.out.print("Enter Payment Number:");
        paymentNo = input.nextInt();
        System.out.print("Enter Amount:");
        amount = input.nextFloat();
        System.out.print("Enter Room Number:");
        roomNo = input.nextInt();
        System.out.print("Enter Customer ID:");
        custId = input.nextInt();
        System.out.print("Enter Till Number:");
        tillNo = input.nextInt();
        System.out.print("Enter Staff Code:");
        staffCode = input.nextInt();
        System.out.println("PAYMENT SCCESSFULLY ADDED");
        
        String sql = "INSERT INTO payment(PAYNO,AMOUNT,ROOMNUMBER,CUSTID,TILLNUMBER,STAFFCODE) VALUES(?,?,?,?,?,?)";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, paymentNo);
            pstmt.setFloat(2, amount);
            pstmt.setInt(3, roomNo);
            pstmt.setInt(4, custId);
            pstmt.setInt(5, tillNo);
            pstmt.setInt(6, staffCode);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    public static void DeletePayment(){
        System.out.println("+--------------+");
        System.out.println("|DELETE PAYMENT|");
        System.out.println("+--------------+");
        System.out.println("Enter Payment Number:");
        paymentNo = input.nextInt();
        String sql = "delete from payment  where PAYNO = ?";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, paymentNo);
            
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("PAYMENT DELETED SUCCESSFULLY");
        
    }
    
    public static void ViewPayments(){
        System.out.println("+------------+");
        System.out.println("|VIEW PAYMENT|");
        System.out.println("+------------+");
        
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
         
         String sql = "SELECT * FROM payment";
         Statement stmnt = conn.createStatement();
         ResultSet rs = stmnt.executeQuery(sql);
         while (rs.next()){
             paymentNo = rs.getInt("PAYNO");
        amount = rs.getInt("AMOUNT");
        roomNo = rs.getInt("ROOMNUMBER");
        custId = rs.getInt("CUSTID");
        tillNo = rs.getInt("TILLNUMBER");
        staffCode = rs.getInt("STAFFCODE");
        
        
        
        System.out.format("%s, %s, %s, %s, %s, %s\n",paymentNo,amount,roomNo,custId,tillNo,staffCode);    
         }
     stmnt.close();
     }
     catch (Exception e){
         System.err.println(e);
     }
        
    }
    
}
