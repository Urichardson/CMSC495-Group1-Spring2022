/*
* File: Login.java
* Author: Group 1 (John Kucera, Jason Martin, Ursula Richardson)
* Creation Date: February 17, 2022
* Purpose: 
*/

// import necessary Java classes
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// Class: Login extends JDialog. Is the Login Menu Dialog.
public class Login extends JDialog {
    
    // Component Initialization
    private final JTextField usernameTxt = new JTextField();
    private final JPasswordField passwordTxt = new JPasswordField();
    private final JLabel denialLbl = new JLabel(" ");
    
    // Login Constructor
    Login() {
        // Creating Header Panel
        final JLabel headerLbl = new JLabel("<HTML><U>User Log In</U></HTML>");
        final JPanel headerPanel = new JPanel();
        headerPanel.add(headerLbl);
        
        // Creating Credentials Panel and Components
        final JPanel credentialsPanel = new JPanel();
        final JLabel usernameLbl = new JLabel("Username: ");
        final JLabel passwordLbl = new JLabel("Password: ");
        final JButton loginBtn = new JButton("Log In");
        loginBtn.addActionListener(new LoginBtnListener());
        
        // Edting Credentials Panel
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        credentialsPanel.setLayout(new GridBagLayout());
        
        gbc.gridx = 0; // Username Label
        gbc.gridy = 0;
        credentialsPanel.add(usernameLbl, gbc);
        
        gbc.gridx = 0; // Password Label
        gbc.gridy = 1;
        credentialsPanel.add(passwordLbl, gbc);
        
        gbc.gridx = 1; // Username Text Field
        gbc.gridy = 0;
        usernameTxt.setColumns(15);
        credentialsPanel.add(usernameTxt, gbc);
        
        gbc.gridx = 1; // Password Text Field
        gbc.gridy = 1;
        passwordTxt.setColumns(15);
        credentialsPanel.add(passwordTxt, gbc);
        
        gbc.gridx = 1; // Button
        gbc.gridy = 2;
        credentialsPanel.add(loginBtn, gbc);
        
        gbc.gridwidth = 2; // Denial Label
        gbc.gridx = 0; 
        gbc.gridy = 3;
        credentialsPanel.add(denialLbl, gbc);
        
        // Creating Full Panel and adding all panels
        final JPanel fullPanel = new JPanel(new BorderLayout());
        fullPanel.add(headerPanel, BorderLayout.PAGE_START);
        fullPanel.add(credentialsPanel, BorderLayout.CENTER);
        add(fullPanel);
        
        // JDialog Listener: Terminate program on close.
        addWindowListener(new WindowAdapter() { 
            @Override
            public void windowClosing(WindowEvent e) { 
                System.exit(0);
            }
        });
        
        // Edit JDialog Characteristics
        setModal(true);
        setTitle("Library Management Program - Login");
        setResizable(false);
        setSize(300,250);
        setLocationRelativeTo(null);
        setVisible(true);
    } // end of constructor
    
    // Class: Login Button Listener.
    private class LoginBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            // The if statement here is a skeleton and likely incorrect.
            // I assume we'll have to get a boolean from the database to see
            // if the input username/password got any matches.
            
            if ("un".equals(usernameTxt.getText().trim())
                && "pw".equals(passwordTxt.getText())) {
                dispose();
            }
            else {
                denialLbl.setText("<HTML>Username or Password are incorrect."
                        + "<br>Please try again.</HTML>");
                usernameTxt.setText("");
                passwordTxt.setText("");
            }
        } // end of method
    } // end of listener class
} // end of class
