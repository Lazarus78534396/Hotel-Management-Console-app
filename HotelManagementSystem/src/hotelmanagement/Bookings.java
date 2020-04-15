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
public class Bookings {
    
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
    public static int bookingID;
    public static String checkInDate;
    public static String checkOutDate;
    public static long custId;
    public static int roomNo;
    public static String custName;
    public static Scanner  input = new Scanner(System.in);
    
    public static void AddBooking() throws SQLException{
        System.out.println("+-----------+");
        System.out.println("|ADD BOOKING|");
        System.out.println("+-----------+");
        System.out.println("Enter Booking ID:");
        bookingID = input.nextInt();
        System.out.print("Enter Check In Date(dd/MM/yyyy):");
        checkInDate = input.next();
        System.out.print("Enter Check Out Date(dd/MM/yyyy):");
        checkOutDate = input.next();
        System.out.print("Enter Customer Name:");
        custName = input.next();
        System.out.print("Enter Customer ID:");
        custId = input.nextLong();
        System.out.print("Enter Room Number:");
        roomNo = input.nextInt();
        
        String sql = "INSERT INTO booking(BOOKCODE,CUSTONAME,ROOMNUM,CHECK_IN_DATE,CHECK_OUT_DATE,CUSTNUMBER) VALUES(?,?,?,?,?,?)";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookingID);
            pstmt.setString(2, custName);
            pstmt.setInt(3, roomNo);
            pstmt.setString(4, checkInDate);
            pstmt.setString(5, checkOutDate);
            pstmt.setLong(6, custId);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    public static void ViewBookings(){
        System.out.println("+-------------+");
        System.out.println("|VIEW BOOKINGS|");
        System.out.println("+-------------+\n\n");
        
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
         
         String sql = "SELECT * FROM booking";
         Statement stmnt = conn.createStatement();
         ResultSet rs = stmnt.executeQuery(sql);
         while (rs.next()){
        bookingID = rs.getInt("BOOKCODE");
        custName = rs.getString("CUSTONAME");
        roomNo = rs.getInt("ROOMNUM");
        checkInDate = rs.getString("CHECK_IN_DATE");
        checkOutDate = rs.getString("CHECK_OUT_DATE");
        custId = rs.getInt("CUSTNUMBER");
        
        
        
        
        System.out.format("%s, %s, %s, %s, %s, %s\n",bookingID, custName, roomNo,checkInDate, checkOutDate,custId);    
         }
     stmnt.close();
     }
     catch (Exception e){
         System.err.println(e);
     }
        
    }
    
    public static void DeleteBooking(){
        System.out.println("+--------------+");
        System.out.println("|DELETE BOOKING|");
        System.out.println("+--------------+");
        System.out.print("Enter Booking ID:");
        bookingID = input.nextInt();
        String sql = "delete from booking  where BOOKCODE = ?";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookingID);
            
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("BOOKING DELETED SUCCESSFULLY");
        
    }
    public static void UpdateBooking(){
        System.out.println("+--------------+");
        System.out.println("|UPDATE BOOKING|");
        System.out.println("+--------------+");
        System.out.print("Enter Booking ID:");
        bookingID = input.nextInt();
          System.out.print("Enter New Check IN Date:");
        checkInDate = input.next();
        System.out.print("Enter New Check Out Date:");
        checkOutDate = input.next();
        System.out.print("Enter New Customer ID:");
        custId = input.nextInt();
        System.out.print("Enter New Room Number:");
        roomNo = input.nextInt();
        System.out.print("Enter New Customer Name:");
        custName = input.next();
        System.out.println("Record Updated");
        String sql = "update booking set CUSTONAME = ?, ROOMNUM = ?, CHECK_IN_DATE = ?, CHECK_OUT_DATE = ?, CUSTNUMBER = ? where BOOKCODE = ?";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, custName);
            pstmt.setInt(2, roomNo);
            pstmt.setString(3, checkInDate);
            pstmt.setString(4, checkOutDate);
            pstmt.setInt(5, (int) custId);
            pstmt.setInt(6, bookingID);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    
}