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


public class Employee {
    
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
    
 public static int    EmpID;
 public static String EmpName;
 public static String EmpSurname;
 public static String EmpAddress;
 public static int    EmpContact;
 public static String JobTitle;
 public static Scanner  input = new Scanner(System.in);
 
 public static void AddEmployee(){
     System.out.println("+------------+");
     System.out.println("|ADD EMPLOYEE|");
     System.out.println("+------------+");
     System.out.print("Enter Employee ID:");
     EmpID = input.nextInt();
     System.out.print("Enter Employee Name:");
     EmpName = input.next();
     System.out.print("Enter Employee Surname:");
     EmpSurname = input.next();
     System.out.print("Enter Employee Address:");
     EmpAddress = input.next();
     System.out.print("Enter Employee Contact Number:");
     EmpContact = input.nextInt();
     System.out.print("Enter Employee Job Title:");
     JobTitle = input.next();
     
     String sql = "INSERT INTO employee(EMPCODE,EMPNAME,EMPSURNAME,ADDRESS,CONTACT,JOBTITTLE) VALUES(?,?,?,?,?,?)";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, EmpID);
            pstmt.setString(2, EmpName);
            pstmt.setString(3, EmpSurname);
            pstmt.setString(4, EmpAddress);
            pstmt.setInt(5, EmpContact);
            pstmt.setString(6, JobTitle);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
     
      System.out.println("RECORD ADDED SUCCESSFULLY");
     //should then save the details to the database
     
 }
 public static void ViewEmployee(){
     System.out.println("+--------------+");
     System.out.println("|VIEW EMPLOYEES|");
     System.out.println("+--------------+");
     
     //Should find the details by the ID and desplay all of them
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
         
         String sql = "SELECT * FROM employee";
         Statement stmnt = conn.createStatement();
         ResultSet rs = stmnt.executeQuery(sql);
         while (rs.next()){
             EmpID = rs.getInt("EMPCODE");
        EmpName = rs.getString("EMPNAME");
        EmpSurname = rs.getString("EMPSURNAME");
        EmpAddress = rs.getString("ADDRESS");
        EmpContact = rs.getInt("CONTACT");
        JobTitle = rs.getString("JOBTITTLE");
        
        
        System.out.format("%s, %s, %s, %s, %s, %s\n",EmpID, EmpName, EmpSurname, EmpAddress, EmpContact, JobTitle);    
         }
     stmnt.close();
     }
     catch (Exception e){
         System.err.println(e);
     }
     }
 
 public static void DeleteEmployee(){
     System.out.println("+---------------+");
     System.out.println("|DELETE EMPLOYEE|");
     System.out.println("+---------------+");
     System.out.print("Enter Employee ID:");
     EmpID = input.nextInt();
     
     String sql = "delete from employee  where EMPCODE = ?";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, EmpID);
            
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
      System.out.println("RECORD DELETED SUCCESSFULLY");
     //Should then find the employee in the database and then delete his/her details
     
 }
 public static void UpdateEmployee(){
     System.out.println("+---------------+");
     System.out.println("|UPDATE EMPLOYEE|");
     System.out.println("+---------------+");
     System.out.print("Enter Employee ID:");
     EmpID = input.nextInt();
     
     System.out.print("Enter New Employee Name:");
     EmpName = input.next();
     System.out.print("Enter New Employee Surname:");
     EmpSurname = input.next();
     System.out.print("Enter New Employee Address:");
     EmpAddress = input.next();
     System.out.print("Enter New Employee Contact Number:");
     EmpContact = input.nextInt();
     System.out.print("Enter New Employee Job Title:");
     JobTitle = input.next();
     String sql = "update employee set EMPNAME = ?, EMPSURNAME = ?, ADDRESS = ?, CONTACT = ?, JOBTITTLE = ? where EMPCODE = ?";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, EmpName);
            pstmt.setString(2, EmpSurname);
            pstmt.setString(3, EmpAddress);
            pstmt.setInt(4, EmpContact);
            pstmt.setString(5, JobTitle);
            pstmt.setInt(6, EmpID);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     System.out.println("RECORD UPDATED SUCCESSFULLY");
 }
}
