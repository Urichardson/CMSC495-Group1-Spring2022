/*
* File: GUI.java
* Author: Group 1 (John Kucera, Jason Martin, Ursula Richardson)
* Creation Date: February 17, 2022
* Purpose: 
*/

// import necessary Java classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUI extends JFrame {
    
    // Component Initialization
    private JPanel mainPanel = new JPanel();
    
    // Constructor (extends JFrame)
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
        //browse books listener
        //view checked books listener
        changePwItem.addActionListener(new ChangePwItemListener());
        logoutItem.addActionListener(new LogoutItemListener());
        
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
        add(mainPanel);
        
        // Edit JFrame characteristics
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Library Management Program");
        setResizable(false);
        setSize(800,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    // Method: Clear GUI of all components besides menu bar.
    private void clearGUI() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    // Log Out Menu Item Listener
    private class LogoutItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearGUI();
            Login login = new Login();
        }
    }
    
    private class ChangePwItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clearGUI();
            mainPanel.add(new ChangePassword());
            repaint();
        }
        
    }
    
    // Method: main. Call constructor to create GUI.
    public static void main(String[] args) {
        GUI gui = new GUI();
        Login login = new Login();
    }
}