/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aethe
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseInitialization {
    static final String DB_URL = "jdbc:mysql://localhost:3306/LMS_DB";
    static final String USER = "root";
    static final String PASS = "password";
    
    
    public static void initialize_database(){
        
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement(); ) {
            String sql;
            
            // Creates a SELECT statement to check if the LMP_Books table is created
            ResultSet rs = stmt.executeQuery("SELECT * "
                    + "FROM information_schema.tables "
                    + "WHERE table_name='LMP_Books';");

            // Creates the LMP_Books Table if it has not been created 
            if(rs.next() == false) {
                sql = "CREATE TABLE LMP_Books (ISBN VARCHAR(17) UNIQUE,"
                + "BookName VARCHAR(255),"
                + "AmountInStock int,"
                + "AmountOwned int,"
                + "BookAuthor varchar(255)"
                + ");";
                stmt.executeUpdate(sql);
                System.out.println("Table LMP_Books Created");
            } else {
                System.out.println("LMP_Books already created");
            }

            
            
            // Creates the LMP_Users Table if it has not been created 
            rs = stmt.executeQuery("SELECT * "
                    + "FROM information_schema.tables "
                    + "WHERE table_name='LMP_Users';");            

            if(rs.next() == false) {
                sql = "CREATE TABLE LMP_Users (UserID int NOT NULL UNIQUE,"
                    + "UserName varchar(255),"
                    + "UserPassword varchar(255),"
                    + "FirstName varchar(255),"
                    + "LastName varchar(255),"
                    + "AdminStatus bool"
                    + ");";
                stmt.executeUpdate(sql);   
                System.out.println("Table LMP_Users Created");
            } else {
                System.out.println("LMP_Users already created");
            }
            
            
            

            // Creates the CheckedOut Table if it has not been created 
            rs = stmt.executeQuery("SELECT * "
                    + "FROM information_schema.tables "
                    + "WHERE table_name='CheckedOutTable';");            

            if(rs.next() == false) {
                sql = "CREATE TABLE CheckedOutTable (CheckOutNumber int NOT NULL UNIQUE,"
                    + "CheckOutDate DATE,"
                    + "PRIMARY KEY (CheckOutNumber),"
                    + "ISBN varchar(17),"
                    + "UserId int,"
                    + "FOREIGN KEY(ISBN) REFERENCES LMP_Books(ISBN),"
                    + "FOREIGN KEY(UserID) REFERENCES LMP_Users(UserID)"
                    + ");";

                stmt.executeUpdate(sql);              
                System.out.println("CheckedOutTable Created");
            } else {
                System.out.println("CheckedOutTable already created");
            }
            
            
            
            


            
            
            
            System.out.println("Database Initialized");
            
            } catch (Exception e) {
        e.printStackTrace();
    }     
    
    
    }


}
