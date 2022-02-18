/*
* File: BrowseBooks.java
* Author: Group 1 (John Kucera, Jason Martin, Ursula Richardson)
* Creation Date: February 17, 2022
* Purpose: 
*/

// import necessary Java classes
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

// Class: BrowseBooks extends JPanel. Is the Browse Books Menu.
public class BrowseBooks extends JPanel {
    
    // Component Initialization
    private final JTextField titleTxt = new JTextField();
    private final JTextField authorTxt = new JTextField();
    private final JButton showinfoBtn = new JButton("Show Book Info");
    private final JButton checkoutBtn = new JButton("Check Out Book");
    
    // Creating table model to hold data
    private final String[][] dataSkeleton = null;
    private final String[] resultsColumns = {"Title", "Author"};
    private final DefaultTableModel resultsModel = new DefaultTableModel(dataSkeleton, resultsColumns);
    
    // Constructor (Extends JPanel)
    BrowseBooks() {
        
        // Creating Header Panel
        final JLabel headerLbl = new JLabel("<HTML><U>Browse Books</U></HTML>");
        final JPanel headerPanel = new JPanel();
        headerPanel.add(headerLbl);
        
        // Creating Search/Results Panel
        final JPanel searchPanel = new JPanel();
        final JLabel titleLbl = new JLabel("Title: ");
        final JLabel authorLbl = new JLabel("Author: ");
        final JButton searchBtn = new JButton("Search");
        final JLabel resultsLbl = new JLabel("<HTML><U>Results</U></HTML>");
        
        // Creating Results Table. 
        final JTable resultsTbl = new JTable(resultsModel);
        final JScrollPane resultsScroll = new JScrollPane(resultsTbl);
        resultsScroll.setPreferredSize(new Dimension(resultsTbl.getPreferredSize().width,resultsTbl.getRowHeight()*17));
        resultsTbl.setSelectionModel(new ForcedListSelectionModel());
        resultsTbl.getSelectionModel().addListSelectionListener(new RowSelectionListener());
        
        // Editing Search Panel
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        searchPanel.setLayout(new GridBagLayout());
        
        gbc.gridx = 0; // Title Label
        gbc.gridy = 0;
        searchPanel.add(titleLbl, gbc);

        gbc.gridx = 1; // Title Text Field
        gbc.gridy = 0;
        titleTxt.setColumns(15);
        searchPanel.add(titleTxt, gbc);
        
        gbc.gridx = 2; // Author Label
        gbc.gridy = 0;
        searchPanel.add(authorLbl, gbc);
        
        gbc.gridx = 3; // Author Text Field
        gbc.gridy = 0;
        authorTxt.setColumns(15);
        searchPanel.add(authorTxt, gbc);
        
        searchBtn.addActionListener(new SearchBtnListener());
        gbc.gridx = 4; // Search Button
        gbc.gridy = 0;
        searchPanel.add(searchBtn, gbc);
        
        showinfoBtn.setEnabled(false);
        showinfoBtn.addActionListener(new ShowInfoBtnListener());
        gbc.gridx = 3; // Show Book Info Button
        gbc.gridy = 1;
        searchPanel.add(showinfoBtn, gbc);
        
        checkoutBtn.setEnabled(false);
        checkoutBtn.addActionListener(new CheckOutBtnListener());
        gbc.gridx = 4; // Check Out Book Button
        gbc.gridy = 1;
        searchPanel.add(checkoutBtn, gbc);
        
        gbc.gridx = 2; // Results Label
        gbc.gridy = 2;
        searchPanel.add(resultsLbl, gbc);
        
        // Creating Full Panel and adding all panels
        final JPanel fullPanel = new JPanel(new BorderLayout());
        fullPanel.add(headerPanel, BorderLayout.PAGE_START);
        fullPanel.add(searchPanel, BorderLayout.CENTER);
        fullPanel.add(resultsScroll, BorderLayout.PAGE_END);
        add(fullPanel);
    } // end of constructor
    
    // Class: Row Selection Listener.
    private class RowSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            showinfoBtn.setEnabled(true);
            checkoutBtn.setEnabled(true);
        }  // end of method
    } // end of listener class
    
    // Class: Forced List Selection Model, created to enable only
    // single row selections AND to disable row deselection.
    private class ForcedListSelectionModel extends DefaultListSelectionModel {
        public ForcedListSelectionModel () {
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } // end of method

        @Override
        public void clearSelection() {
        } // end of method

        @Override
        public void removeSelectionInterval(int index0, int index1) {
        } // end of method
    } // end of model class
    
    // Class: Search Button Listener.
    private class SearchBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Example Book Entries for Results Table
            for (int i = 0; i < 25; i++) {
                resultsModel.addRow(new Object[] {"the title", "the author"});
            }
        } // end of method
    } // end of listener class
    
    // Class: Show Book Info Button Listener.
    private class ShowInfoBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create Dialog and components
            JDialog showinfoDialog = showinfoDialog = new JDialog();
            JPanel showinfoPanel = new JPanel();
            JLabel titleLbl = new JLabel("Title: ");
            JLabel authorLbl = new JLabel("Author: ");
            JLabel isbnLbl = new JLabel("ISBN: ");
            JLabel languageLbl = new JLabel("Language: ");
            JLabel totalLbl = new JLabel("Quantity (Total): ");
            JLabel availLbl = new JLabel("Quantity (Available): ");
            JTextField titleTxt = new JTextField("title1");
            JTextField authorTxt = new JTextField("author1");
            JTextField isbnTxt = new JTextField("isbn1");
            JTextField languageTxt = new JTextField("language1");
            JTextField totalTxt = new JTextField("2");
            JTextField availTxt = new JTextField("1");
            
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
            showinfoDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            showinfoDialog.add(showinfoPanel);
            showinfoDialog.setModal(true);
            showinfoDialog.setTitle("Show Book Info");
            showinfoDialog.setResizable(false);
            showinfoDialog.setSize(600,200);
            showinfoDialog.setLocationRelativeTo(null);
            showinfoDialog.setVisible(true);
        } // end of method
    } // end of listener class
    
    // Class: Check Out Book Button Listener.
    private class CheckOutBtnListener implements ActionListener {
            
        @Override
        public void actionPerformed(ActionEvent e) {
            // Placeholder
//            if(selectedBook.getBookQuantity()>0) {
//                CheckOut checkout = new CheckOut();
//            }
//            else {
//                dialog notifying that book is not available
//            }

            CheckOut checkout = new CheckOut();
        } // end of method
    } // end of listener class
    
    
} // end of class
