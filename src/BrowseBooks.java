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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
        resultsTbl.setDefaultEditor(Object.class, null);
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
            ShowBookInfo showbookinfo = new ShowBookInfo(); 
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
