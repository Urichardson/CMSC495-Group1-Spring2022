/*
* File: CheckOut.java
* Author: Group 1 (John Kucera, Jason Martin, Ursula Richardson)
* Creation Date: February 17, 2022
* Purpose: 
*/

// import necessary Java classes
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Class: CheckOut extends JDialog. Is the Check Out Prompt.
public class CheckOut extends JDialog {
    
    // Initialize Variables and components
    public int days = 0;
    private final JTextField daysTxt = new JTextField();
    final JLabel denialLbl = new JLabel("");
    
    // Constructor (Extends JDialog)
    CheckOut() {
        // Create Dialog and components
        final JPanel checkoutPanel = new JPanel();
        final JLabel daysLbl = new JLabel("<HTML>Enter how many days you will<br>have the book checked out:</HTML>");
        final JButton confirmBtn = new JButton("Confirm");
        
        // Editing Panel
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        checkoutPanel.setLayout(new GridBagLayout());
        
        gbc.gridx = 0; // Check Out Days Label
        gbc.gridy = 0;
        checkoutPanel.add(daysLbl, gbc);
        
        gbc.gridx = 1; // Check Out Days Text Field
        gbc.gridy = 0;
        daysTxt.setColumns(5);
        checkoutPanel.add(daysTxt, gbc);
        
        gbc.gridx = 1; // Button
        gbc.gridy = 1;
        confirmBtn.addActionListener(new ConfirmBtnListener());
        checkoutPanel.add(confirmBtn, gbc);
        
        gbc.gridx = 1; // Denial Label
        gbc.gridy = 2;
        checkoutPanel.add(denialLbl, gbc);
        
        // Edit Dialog characteristics
        add(checkoutPanel);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setTitle("Check Out Book");
        setResizable(false);
        setSize(400,200);
        setLocationRelativeTo(null);
        setVisible(true);
    } // end of constructor
    
    // Class: Login Button Listener.
    private class ConfirmBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Store input days, ensure that it is positive integer
                days = Integer.parseInt(daysTxt.getText().trim());
                if (days > 0) {
                    dispose();
                }
                else {
                    denialLbl.setText("<HTML>Invalid input. Please<br>enter a positive<br>integer.</HTML>");
                }
            }
            catch (NumberFormatException ex) {
                denialLbl.setText("<HTML>Invalid input. Please<br>enter a positive<br>integer.</HTML>");
            }
        } // end of method
    } // end of listener class
}
