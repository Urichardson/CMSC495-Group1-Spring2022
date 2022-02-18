/*
* File: GUI.java
* Author: Group 1 (John Kucera, Jason Martin, Ursula Richardson)
* Creation Date: February 17, 2022
* Purpose: 
*/

// import necessary Java classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

// Class: GUI extends JFrame. Is the main GUI.
public class GUI extends JFrame {
    
    // Component Initialization
    public final JPanel mainPanel = new JPanel();
    
    // Constructor (Extends JFrame)
    public GUI() {
        // Create Menu Bar with Main Menu Items
        final JMenuBar menuBar = new JMenuBar();
        final JMenu mainMenu = new JMenu("Main Menu");
        final JMenuItem browseBooksItem = new JMenuItem("Browse Books");
        final JMenuItem viewCheckedItem = new JMenuItem("View Checked-Out Books");
        final JMenuItem changePwItem = new JMenuItem("Change Password");
        final JMenuItem logoutItem = new JMenuItem("Log Out");
        
        // Create Admin Settings Menu Items
        final JMenu adminMenu = new JMenu("Admin Settings");
        final JMenuItem listBooksItem = new JMenuItem("List Books");
        final JMenuItem addBookItem = new JMenuItem("Add Book");
        final JMenuItem listUsersItem = new JMenuItem("List Users");
        final JMenuItem addUserItem = new JMenuItem("Add User");
        
        // Adding listeners
        browseBooksItem.addActionListener(new BrowseBooksItemListener());
        viewCheckedItem.addActionListener(new ViewCheckedItemListener());
        changePwItem.addActionListener(new ChangePwItemListener());
        logoutItem.addActionListener(new LogoutItemListener());
        listBooksItem.addActionListener(new ListBooksItemListener());
        addBookItem.addActionListener(new AddBookItemListener());
        listUsersItem.addActionListener(new ListUsersItemListener());
        addUserItem.addActionListener(new AddUserItemListener());
        
        // Add Main Menu to Menu Bar
        mainMenu.add(browseBooksItem);
        mainMenu.add(viewCheckedItem);
        mainMenu.add(changePwItem);
        mainMenu.add(logoutItem);
        menuBar.add(mainMenu);
        
        // Add Admin Settings to Menu Bar
        adminMenu.add(listBooksItem);
        adminMenu.add(addBookItem);
        adminMenu.add(listUsersItem);
        adminMenu.add(addUserItem);
        menuBar.add(adminMenu);
        // adminMenu.setEnabled(false);
        
        // Add Components to GUI
        setJMenuBar(menuBar);
        mainPanel.add(new JLabel("<HTML><br><br><br><br><br><br><br><br><br><br>"
                + "Welcome to the Library Management Program Tool! Please select"
                + " an item from the menu bar.</HTML>"));
        add(mainPanel);
        
        // Edit JFrame characteristics
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Library Management Program");
        setResizable(false);
        setSize(800,500);
        setLocationRelativeTo(null);
        setVisible(true);
    } // end of constructor

    // Class: Browse Books Menu Item Listener
    private class BrowseBooksItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearGUI();
            mainPanel.add(new BrowseBooks());
            repaint();
        } // end of method
    } // end of listener class
    
    // Class: Browse Books Menu Item Listener
    private class ViewCheckedItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearGUI();
            mainPanel.add(new ViewChecked());
            repaint();
        } // end of method
    } // end of listener class
    
    // Class: Change Password Menu Item Listener
    private class ChangePwItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearGUI();
            mainPanel.add(new ChangePassword());
            repaint();
        } // end of method
    } // end of listener class
    
    // Class: Log Out Menu Item Listener
    private class LogoutItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearGUI();
            Login login = new Login();
        } // end of method
    } /// end of listener class
    
    // Class: List Books Menu Item Listener
    private class ListBooksItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearGUI();
            mainPanel.add(new AdminBookList());
            repaint();
        } // end of method
    } // end of listener class
    
    // Class: Add Book Menu Item Listener
    private class AddBookItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearGUI();
            mainPanel.add(new AdminAddBook());
            repaint();
        } // end of method
    } // end of listener class
    
    // Class: List Users Menu Item Listener
    private class ListUsersItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearGUI();
            mainPanel.add(new AdminUserList());
            repaint();
        } // end of method
    } // end of listener class
    
    // Class: Add User Menu Item Listener
    private class AddUserItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearGUI();
            mainPanel.add(new AdminAddUser());
            repaint();
        } // end of method
    } // end of listener class
    
    // Method: clearGUI. Removes all GUI components except menu bar.
    private void clearGUI() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
    } // end of method
    
    // Method: main. Call constructor to create GUI.
    public static void main(String[] args) {
        GUI gui = new GUI();
        Login login = new Login();
    } // end of main method
} // end of class
