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
public class Job {
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
    public static int JobNo;
    public static String title;
    public static String Payment;
    public static int employeeCode;
    public static int hours;
    public static String department;
    
    public static Scanner input = new Scanner(System.in);
    
    
    public static void AddJob(){
        System.out.println("+-------+");
        System.out.println("|ADD JOB|");
        System.out.println("+-------+");
        System.out.print("Enter Job Code:");
        JobNo = input.nextInt();
        System.out.print("Enter Title:");
        title = input.next();
        System.out.print("Enter Salary(with currency):");
        Payment = input.next();
        System.out.print("Enter Employee Code:");
        employeeCode = input.nextInt();
        System.out.print("Enter Hours Worked:");
        hours = input.nextInt();
        System.out.print("Enter Department:");
        department = input.next();
        String sql = "INSERT INTO job(JOBCODE,TITTLE,PAYMENT,EMPECODE,HOURS,DEPARTMENT) VALUES(?,?,?,?,?,?)";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, JobNo);
            pstmt.setString(2, title);
            pstmt.setString(3, Payment);
            pstmt.setInt(4, employeeCode);
            pstmt.setInt(5, hours);
            pstmt.setString(6, department);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("JOB SUCCESFULLY ADDED");
    }
    public static void UpdateJob(){
        System.out.println("+----------+");
        System.out.println("|UPDATE JOB|");
        System.out.println("+----------+");
        System.out.print("Enter Job Code:");
        JobNo = input.nextInt();
        System.out.print("Enter New Title:");
        title = input.next();
        System.out.print("Enter New Salary(with currency):");
        Payment = input.next();
        System.out.print("Enter New Employee Code:");
        employeeCode = input.nextInt();
        System.out.print("Enter New Hours Worked:");
        hours = input.nextInt();
        System.out.print("Enter New Department:");
        department = input.next();
        String sql = "update job set TITTLE = ?, PAYMENT = ?, EMPECODE = ?, HOURS = ?, DEPARTMENT = ? where JOBCODE = ?";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, Payment);
            pstmt.setInt(3, employeeCode);
            pstmt.setInt(4, hours);
            pstmt.setString(5, department);
            pstmt.setInt(6, JobNo);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("JOB SUCCESFULLY UPDATED");
        
        
    }
    public static void DeleteJob(){
        System.out.println("+----------+");
        System.out.println("|DELETE JOB|");
        System.out.println("+----------+");
        System.out.print("Enter Job Code:");
        JobNo = input.nextInt();
        String sql = "delete from job  where JOBCODE = ?";
        
        try (Connection conn = Bookings.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, JobNo);
            
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("JOB SUCCESSFULLY DELETED");
        
    }
    public static void ViewJobs(){
        System.out.println("+---------+");
        System.out.println("|VIEW JOBS|");
        System.out.println("+---------+");
        
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
         
         String sql = "SELECT * FROM job";
         Statement stmnt = conn.createStatement();
         ResultSet rs = stmnt.executeQuery(sql);
         while (rs.next()){
             JobNo = rs.getInt("JOBCODE");
        title = rs.getString("TITTLE");
        Payment = rs.getString("PAYMENT");
        employeeCode = rs.getInt("EMPECODE");
        hours = rs.getInt("HOURS");
        department = rs.getString("DEPARTMENT");
        
        
        
        System.out.format("%s, %s, %s, %s, %s, %s\n",JobNo, title, Payment,employeeCode, hours,department);    
         }
     stmnt.close();
     }
     catch (Exception e){
         System.err.println(e);
     }
        
    }
    
}
