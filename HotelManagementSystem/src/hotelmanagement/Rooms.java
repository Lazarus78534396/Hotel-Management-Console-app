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
public class Rooms {
    
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
    
    public static int roomNo;
    public static String roomType;
    public static float pricePerNight;
    public static int floorNo;
    public static String status;
    public static int custId;
    public static Scanner input = new Scanner(System.in);
    
    public static void UpdateSatus(){
        System.out.println("+------------------+");
        System.out.println("|UPDATE ROOM STATUS|");
        System.out.println("+------------------+");
        System.out.println("Enter Room Number:");
        roomNo = input.nextInt();
        //Should fatch the room details
        System.out.println("Enter Room Status:");
        status = input.next();
        
        String sql = "update room set STATUS = ? where ROOMNO = ?";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, roomNo);
            
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Room Status Updated");
    }
    public static void ViewRooms(){
        System.out.println("+----------+");
        System.out.println("|VIEW ROOMS|");
        System.out.println("+----------+");
        //fetch all rooms and its details
        
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
         
         String sql = "SELECT * FROM room";
         Statement stmnt = conn.createStatement();
         ResultSet rs = stmnt.executeQuery(sql);
         while (rs.next()){
             roomNo = rs.getInt("ROOMNO");
        roomType = rs.getString("ROOMTYPE");
        pricePerNight = rs.getInt("PRICENIGHT");
        floorNo = rs.getInt("HOTELFLOOR");
        status = rs.getString("STATUS");
        custId = rs.getInt("CUST_NUMBER");
                
        System.out.format("%s, %s, %s, %s, %s, %s\n",roomNo, roomType, pricePerNight,floorNo, status,custId);    
         }
     stmnt.close();
     }
     catch (Exception e){
         System.err.println(e);
     }
    }
}
