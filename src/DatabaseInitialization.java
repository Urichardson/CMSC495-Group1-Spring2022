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
        
        System.out.println("Verifying Database Status:\n");
        
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
                System.out.println("Table LMP_Books verfied");
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
                System.out.println("Table LMP_Users verified");
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
                System.out.println("Table CheckedOutTable verified");
            }
            
            
            
            
            } catch (Exception e) {
        e.printStackTrace();
    }     
    
    
    }
    
    public static void populateTestData() {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement(); ) {
            
            System.out.println("\nPopulating Table Data:\n");
            
            ResultSet rs = stmt.executeQuery("SELECT * "
                    + "FROM LMP_Users;");            

            if(rs.next() == false) {
        
                // LMP_Users: UserID, UserName, UserPassword, FirstName, LastName, AdminStatus 
                String sql = "INSERT INTO LMP_Users VALUES (1,'JohnKucera','password','John','Kucera',1)";
                stmt.executeUpdate(sql);

                sql = "INSERT INTO LMP_Users VALUES (2,'UrsulaRichardson','password','Ursula','Richardson',1)";
                stmt.executeUpdate(sql);

                sql = "INSERT INTO LMP_Users VALUES (3, 'JasonMartin','password','Jason','Martin',1)";
                stmt.executeUpdate(sql);

                sql = "INSERT INTO LMP_Users VALUES (4, 'GuestAccount', 'password', 'Guest', 'Account',0)";
                stmt.executeUpdate(sql);
            
            System.out.println("LMP_User table populated");
            
            } else {
                System.out.println("LMP_Table already populated");
            }
            
            
            
            
            
        
            
            rs = stmt.executeQuery("SELECT * "
                    + "FROM LMP_Books;");            

            if(rs.next() == false) {
        
                // LMP_Books: ISBN, BookName, AmountInStock, AmountOwned, BookAuthor
                String sql = "INSERT INTO LMP_Books VALUES ('1260440214','Java A Beginner Guide Eighth Edition',3,3,'Herbert Schildt')";
                stmt.executeUpdate(sql);

                sql = "INSERT INTO LMP_Books VALUES ('0596009208','Head First Java',2,2,'Kathy Sierra & Bert Bates')";
                stmt.executeUpdate(sql);

                sql = "INSERT INTO LMP_Books VALUES ('9780596009762','SQL Cookbook',4,4,'Anthony Molinaro')";
                stmt.executeUpdate(sql);

                sql = "INSERT INTO LMP_Books VALUES ('0596526849','Head First SQL',0,1,'Lynn Beighley')";
                stmt.executeUpdate(sql);
            
            System.out.println("LMP_Books table populated");
            
            } else {
                System.out.println("LMP_Books already populated");
            }
            
            
            
            

            rs = stmt.executeQuery("SELECT * "
                    + "FROM CheckedOutTable;");            

            if(rs.next() == false) {
                
                // CheckedOutTable: CheckOutNumber, CheckOutDate, ISBN, UserID
                String sql = "INSERT INTO CheckedOutTable VALUES (1,'2022-2-20','0596526849',3)";
                stmt.executeUpdate(sql);


            System.out.println("CheckedOutTable table populated");
            
            } else {
                System.out.println("CheckedOutTable already populated");
            }


        
            } catch (Exception e) {
                e.printStackTrace();
            }


    
    
    
}}
