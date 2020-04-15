
package hotelmanagement;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HotelManagement {
public static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) throws SQLException {
      
        
        
        Logo();
        System.out.println("\nWelcome To Limko Inn Hotel\n");
        //main code
        mainManu();
    }
      
    
    public static void mainManu(){
        //main menu method
        
        System.out.println("\n");
        System.out.println("MAIN MENU");
        System.out.println("1 - Bookings");
        System.out.println("2 - Rooms");
        System.out.println("3 - Employees");
        System.out.println("4 - Payments");
        System.out.println("5 - Customers");
        System.out.println("6 - Jobs");
        System.out.println("7 - Exit \n");
        System.out.print("Enter Choice:");
        Scanner scanner = new Scanner(System. in);
        int option = scanner.nextInt();
        //performing logic on users input
        switch (option){
            case 1:
                Bookings();
                break;
            case 2:
        {
            try {
                Rooms();
            } catch (SQLException ex) {
                Logger.getLogger(HotelManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case 3:
                Employees();
                break;
            case 4:
                Payments();
                break;
            case 5:
                Customers();
                break;
            case 6:
                Jobs();
                break;
            case 7:
                Exit();
                break;
            default:
                System.out.println("ERROR INVALID ENTRY!!");
                mainManu();
        }
    }
    
    public static void Exit(){
        //Exit method that will break out of the system
        System.out.println("GOOD BYE!!!");
        System.exit(0);
    }
    public static void Logo(){
           System.out.println("LLL             III   MMMMMM         MMMMMM   KKK        KKK      OOOOOOOOO            III   NNNNNN        NNN   NNNNNN        NNN");
           System.out.println("LLL             III   MMM MMM       MMM MMM   KKK      KKK       OOOOOOOOOOO           III   NNN NNN       NNN   NNN NNN       NNN");
           System.out.println("LLL             III   MMM  MMM     MMM  MMM   KKK    KKK        OOO       OOO          III   NNN  NNN      NNN   NNN  NNN      NNN");
           System.out.println("LLL             III   MMM   MMM   MMM   MMM   KKK  KKK          OOO       OOO          III   NNN   NNN     NNN   NNN   NNN     NNN");
           System.out.println("LLL             III   MMM    MMM MMM    MMM   KKKKKK            OOO       OOO          III   NNN    NNN    NNN   NNN    NNN    NNN");
           System.out.println("LLL             III   MMM      MMM      MMM   KKK  KKK          OOO       OOO          III   NNN     NNN   NNN   NNN     NNN   NNN");
           System.out.println("LLL             III   MMM               MMM   KKK    KKK        OOO       OOO          III   NNN      NNN  NNN   NNN      NNN  NNN");
           System.out.println("LLLLLLLLLLLLL   III   MMM               MMM   KKK      KKK       OOOOOOOOOOO           III   NNN       NNN NNN   NNN       NNN NNN");
           System.out.println("LLLLLLLLLLLLL   III   MMM               MMM   KKK        KKK      OOOOOOOOO            III   NNN        NNNNNN   NNN        NNNNNN");
        }
    
    public static void Bookings(){
        //Bookings Method
        System.out.println("+--------+");
        System.out.println("|BOOKINGS|");
        System.out.println("+--------+");
        System.out.println("1 - Add Booking");
        System.out.println("2 - View Bookings");
        System.out.println("3 - Delete Booking");
        System.out.println("4 - Update Booking");
        System.out.println("5 - Exit\n");
        System.out.print("Enter Choice:");
        
        int bookChoice = s.nextInt();
        
        switch (bookChoice){
            case 1:
        {
            try {
                Bookings.AddBooking();
            } catch (SQLException ex) {
                Logger.getLogger(HotelManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                Bookings();
                break;
            case 2:
                Bookings.ViewBookings();
                Bookings();
                break;
            case 3:
                Bookings.DeleteBooking();
                Bookings();
                break;
            case 4:
                Bookings.UpdateBooking();
                Bookings();
                break;
            case 5:
                
                mainManu();
                break;
            default:
                System.out.println("ERROR INVALID ENTRY!!");
                Bookings();
        }
        
    }
    public static void Rooms() throws SQLException{
        System.out.println("+-----+");
        System.out.println("|ROOMS|");
        System.out.println("+-----+");
        System.out.println("1 - View Rooms");
        System.out.println("2 - Update Room Status");
        System.out.println("3 - Exit\n");
        System.out.print("Enter Choice:");
        
        int RChoice = s.nextInt();
        
        switch(RChoice){
            case 1:
                Rooms.ViewRooms();
                Rooms();
                break;
            case 2:
                Rooms.UpdateSatus();
                Rooms();
                break;
            case 3:
                mainManu();
               break; 
            default:
                System.out.println("Invalid Entry");
                Rooms();
        }
    }
    public static void Employees(){
        //Employees method
        System.out.println("+---------+");
        System.out.println("|EMPLOYEES|");
        System.out.println("+---------+");
        System.out.println("1 - Add Employee");
        System.out.println("2 - View Employees");
        System.out.println("3 - Delete Employee");
        System.out.println("4 - Update Employee");
        System.out.println("5 - Exit\n");
        System.out.print("Enter Choice:");
        int EChoice = s.nextInt();
        
        switch (EChoice){
            case 1:
                Employee.AddEmployee();
                Employees();
                break;
            case 2:
                Employee.ViewEmployee();
                Employees();
                break;
            case 3:
                Employee.DeleteEmployee();
                Employees();
                break;
            case 4:
                Employee.UpdateEmployee();
                Employees();
                break;
            case 5:
                mainManu();
                break;
            default:
                System.out.println("ERROR INVALID ENTRY!!");
        }
        
    }
    public static void Payments(){
        System.out.println("+--------+");
        System.out.println("|PAYMENTS|");
        System.out.println("+--------+");
        System.out.println("1 - Add Payment");
        System.out.println("2 - View Payments");
        System.out.println("3 - Delete Payment");
        System.out.println("4 - Exit\n");
        System.out.print("Enter Choice:");
        int PChoice = s.nextInt();
        
        switch(PChoice){
            case 1:
                Payments.AddPayment();
                Payments();
                break;
            case 2:
                Payments.ViewPayments();
                Payments();
                break;
            case 3:
                Payments.DeletePayment();
                Payments();
                break;
            case 4:
                mainManu();
                break;
            default:
                System.out.println("Invalid Entry");
                Payments();
        }
    }
    public static void Customers(){
        System.out.println("+---------+");
        System.out.println("|CUSTOMERS|");
        System.out.println("+---------+");
        System.out.println("1 - Add Customer");
        System.out.println("2 - View Customers");
        System.out.println("3 - Update Customer");
        System.out.println("4 - Delete Customers");
        System.out.println("5 - Exit\n");
        System.out.print("Enter Choice:");
        int CChoice = s.nextInt();
        
        switch(CChoice){
            case 1:
                Customer.AddCustomer();
                Customers();
                break;
            case 2:
                Customer.ViewCustomers();
                Customers();
                break;
            case 3:
                Customer.UpdateCustomer();
                Customers();
                break;
            case 4:
                Customer.DeleteCustomer();
                Customers();
                break;
            case 5:
                mainManu();
                break;
            default:System.out.println("Invalid Entry");
                Customers();
        }
    }
    public static void Jobs(){
        //Bookings Method
        System.out.println("+----+");
        System.out.println("|JOBS|");
        System.out.println("+----+");
        System.out.println("1 - Add Job");
        System.out.println("2 - View Jobs");
        System.out.println("3 - Delete Job");
        System.out.println("4 - Update Job");
        System.out.println("5 - Exit\n");
        System.out.print("Enter Choice:");
        
        int JChoice = s.nextInt();
        
        switch (JChoice){
            case 1:
                Job.AddJob();
                Jobs();
                break;
            case 2:
                Job.ViewJobs();
                Jobs();
                break;
            case 3:
                Job.DeleteJob();
                Jobs();
                break;
            case 4:
                Job.UpdateJob();
                Jobs();
                break;
            case 5:
                
                mainManu();
                break;
            default:
                System.out.println("ERROR INVALID ENTRY!!");
                Jobs();
        }
    }
    

    
}
