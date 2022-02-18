/*
* File: ShowBookInfo.java
* Author: Group 1 (John Kucera, Jason Martin, Ursula Richardson)
* Creation Date: February 18, 2022
* Purpose: 
*/

// import necessary Java classes
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Class: ShowBookInfo extends JDialog. Is the Show Book Info dialog.
public class ShowBookInfo extends JDialog {
    
    // Initializing Components
    private final JTextField titleTxt = new JTextField("title1");
    private final JTextField authorTxt = new JTextField("author1");
    private final JTextField isbnTxt = new JTextField("isbn1");
    private final JTextField languageTxt = new JTextField("language1");
    private final JTextField totalTxt = new JTextField("2");
    private final JTextField availTxt = new JTextField("1");
    
    // Constructor (extends JDialog)
    public ShowBookInfo() {
        
        // Creating Info Panel
        JPanel showinfoPanel = new JPanel();
        JLabel titleLbl = new JLabel("Title: ");
        JLabel authorLbl = new JLabel("Author: ");
        JLabel isbnLbl = new JLabel("ISBN: ");
        JLabel languageLbl = new JLabel("Language: ");
        JLabel totalLbl = new JLabel("Quantity (Total): ");
        JLabel availLbl = new JLabel("Quantity (Available): ");

        // Add components to dialog
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        showinfoPanel.setLayout(new GridBagLayout());

        gbc.gridx = 0; // Title Label
        gbc.gridy = 0;
        showinfoPanel.add(titleLbl, gbc);

        gbc.gridx = 1; // Title Text Field
        gbc.gridy = 0;
        titleTxt.setColumns(20);
        titleTxt.setEditable(false);
        showinfoPanel.add(titleTxt, gbc);

        gbc.gridx = 0; // Author Label
        gbc.gridy = 1;
        showinfoPanel.add(authorLbl, gbc);

        gbc.gridx = 1; // Author Text Field
        gbc.gridy = 1;
        authorTxt.setColumns(20);
        authorTxt.setEditable(false);
        showinfoPanel.add(authorTxt, gbc);

        gbc.gridx = 0; // ISBN Label
        gbc.gridy = 2;
        showinfoPanel.add(isbnLbl, gbc);

        gbc.gridx = 1; // ISBN Text Field
        gbc.gridy = 2;
        isbnTxt.setColumns(20);
        isbnTxt.setEditable(false);
        showinfoPanel.add(isbnTxt, gbc);

        gbc.gridx = 0; // Language Label
        gbc.gridy = 3;
        showinfoPanel.add(languageLbl, gbc);

        gbc.gridx = 1; // Language Text Field
        gbc.gridy = 3;
        languageTxt.setColumns(20);
        languageTxt.setEditable(false);
        showinfoPanel.add(languageTxt, gbc);

        gbc.gridx = 2; // Quantity Total Label
        gbc.gridy = 0;
        showinfoPanel.add(totalLbl, gbc);

        gbc.gridx = 3; // Quantity Total Text Field
        gbc.gridy = 0;
        totalTxt.setColumns(5);
        totalTxt.setEditable(false);
        showinfoPanel.add(totalTxt, gbc);

        gbc.gridx = 2; // Quantity Available Label
        gbc.gridy = 1;
        showinfoPanel.add(availLbl, gbc);

        gbc.gridx = 3; // Quantity Available Text Field
        gbc.gridy = 1;
        availTxt.setColumns(5);
        availTxt.setEditable(false);
        showinfoPanel.add(availTxt, gbc);

        // Edit Dialog Characteristics
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        add(showinfoPanel);
        setModal(true);
        setTitle("Show Book Info");
        setResizable(false);
        setSize(600,200);
        setLocationRelativeTo(null);
        setVisible(true);
    } // end of constructor
} // end of class
