/*
* File: AddBook.java
* Author: Group 1 (John Kucera, Jason Martin, Ursula Richardson)
* Creation Date: February 18, 2022
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

// Class: AddBook extends JPanel. Is the Add Book menu.
public class AddBook extends JPanel {
    
    // Component Initialization
    JTextField titleTxt = new JTextField("title1");
    JTextField authorTxt = new JTextField("author1");
    JTextField isbnTxt = new JTextField("isbn1");
    JTextField languageTxt = new JTextField("language1");
    JTextField totalTxt = new JTextField("2");
    JTextField availTxt = new JTextField("1");
    
    // Constructor (extends JPanel)
    public AddBook() {
        JPanel infoPanel = new JPanel();
        JLabel titleLbl = new JLabel("Title: ");
        JLabel authorLbl = new JLabel("Author: ");
        JLabel isbnLbl = new JLabel("ISBN: ");
        JLabel languageLbl = new JLabel("Language: ");
        JLabel totalLbl = new JLabel("Quantity (Total): ");
        JLabel availLbl = new JLabel("Quantity (Available): ");
        JButton confBtn = new JButton("Add Book");
        
        // Add components to dialog
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        infoPanel.setLayout(new GridBagLayout());

        gbc.gridx = 0; // Title Label
        gbc.gridy = 0;
        infoPanel.add(titleLbl, gbc);

        gbc.gridx = 1; // Title Text Field
        gbc.gridy = 0;
        titleTxt.setColumns(20);
        infoPanel.add(titleTxt, gbc);

        gbc.gridx = 0; // Author Label
        gbc.gridy = 1;
        infoPanel.add(authorLbl, gbc);

        gbc.gridx = 1; // Author Text Field
        gbc.gridy = 1;
        authorTxt.setColumns(20);
        infoPanel.add(authorTxt, gbc);

        gbc.gridx = 0; // ISBN Label
        gbc.gridy = 2;
        infoPanel.add(isbnLbl, gbc);

        gbc.gridx = 1; // ISBN Text Field
        gbc.gridy = 2;
        isbnTxt.setColumns(20);
        infoPanel.add(isbnTxt, gbc);

        gbc.gridx = 0; // Language Label
        gbc.gridy = 3;
        infoPanel.add(languageLbl, gbc);

        gbc.gridx = 1; // Language Text Field
        gbc.gridy = 3;
        languageTxt.setColumns(20);
        infoPanel.add(languageTxt, gbc);

        gbc.gridx = 2; // Quantity Total Label
        gbc.gridy = 0;
        infoPanel.add(totalLbl, gbc);

        gbc.gridx = 3; // Quantity Total Text Field
        gbc.gridy = 0;
        totalTxt.setColumns(5);
        infoPanel.add(totalTxt, gbc);

        gbc.gridx = 2; // Quantity Available Label
        gbc.gridy = 1;
        infoPanel.add(availLbl, gbc);

        gbc.gridx = 3; // Quantity Available Text Field
        gbc.gridy = 1;
        availTxt.setColumns(5);
        infoPanel.add(availTxt, gbc);

        gbc.gridx = 3; // Confirm Button
        gbc.gridy = 2;
        confBtn.addActionListener(new ConfirmBtnListener());
        infoPanel.add(confBtn, gbc);
        add(infoPanel);
    } // end of constructor
    
    // Class: Confirm Button Listener.
    private class ConfirmBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog addedDialog = new JDialog();
            JLabel addedLbl = new JLabel("     Book has been added.");
            addedDialog.add(addedLbl);
            addedDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            addedDialog.setModal(true);
            addedDialog.setTitle("Added Book");
            addedDialog.setResizable(false);
            addedDialog.setSize(300,100);
            addedDialog.setLocationRelativeTo(null);
            addedDialog.setVisible(true);
            titleTxt.setText("");
            authorTxt.setText("");
            isbnTxt.setText("");
            languageTxt.setText("");
            totalTxt.setText("");
            availTxt.setText("");
        } // end of method
    } // end of listener class
} // end of class
