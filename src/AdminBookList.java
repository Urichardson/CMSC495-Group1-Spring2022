/*
* File: AdminBookList.java
* Author: Group 1 (John Kucera, Jason Martin, Ursula Richardson)
* Creation Date: February 18, 2022
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

// Class: AdminBookList extends JPanel. Is the List Books menu.
public class AdminBookList extends JPanel {
    
    // Component Initialization
    private final JButton editBtn = new JButton("Edit Book Info");
    private final JButton removeBtn = new JButton("Remove Book");
    
    // Creating table model to hold data
    private final String[][] dataSkeleton = null;
    private final String[] booksColumns = {"Title", "Author"};
    private final DefaultTableModel booksModel = new DefaultTableModel(dataSkeleton, booksColumns);
    
    // Constructor (Extends JPanel)
    AdminBookList() {
        // Creating Header Panel
        final JLabel headerLbl = new JLabel("<HTML><U>Book List</U></HTML>");
        final JPanel headerPanel = new JPanel();
        headerPanel.add(headerLbl);
        
        // Creating Books Table. 
        final JTable booksTbl = new JTable(booksModel);
        final JScrollPane booksScroll = new JScrollPane(booksTbl);
        booksScroll.setPreferredSize(new Dimension(500,booksTbl.getRowHeight()*20));
        booksTbl.getTableHeader().setPreferredSize(new Dimension(100, 32));
        booksTbl.setDefaultEditor(Object.class, null);
        booksTbl.setSelectionModel(new ForcedListSelectionModel());
        booksTbl.getSelectionModel().addListSelectionListener(new RowSelectionListener());
        
        // Example Book Entries for Books Table
        for (int i = 0; i < 25; i++) {
            booksModel.addRow(new Object[] {"the title", "the author"});
        }
        
        // Creating and Editing Button Panel
        final JPanel buttonsPanel = new JPanel();
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        buttonsPanel.setLayout(new GridBagLayout());
        
        gbc.gridx = 0; // Edit Button
        gbc.gridy = 0;
        editBtn.addActionListener(new EditBtnListener());
        editBtn.setEnabled(false);
        buttonsPanel.add(editBtn, gbc);
        
        gbc.gridx = 1; // Remove Button
        gbc.gridy = 0;
        removeBtn.addActionListener(new RemoveBtnListener());
        removeBtn.setEnabled(false);
        buttonsPanel.add(removeBtn, gbc);
        
        // Creating Full Panel and adding all panels
        final JPanel fullPanel = new JPanel(new BorderLayout(0, 12));
        fullPanel.add(headerPanel, BorderLayout.PAGE_START);
        fullPanel.add(buttonsPanel, BorderLayout.CENTER);
        fullPanel.add(booksScroll, BorderLayout.PAGE_END);
        add(fullPanel);
    } // end of constructor
    
    // Class: Row Selection Listener.
    private class RowSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            editBtn.setEnabled(true);
            removeBtn.setEnabled(true);
        }  // end of method
    } // end of listener class
    
    // Class: Edit Book Info Button Listener.
    private class EditBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EditBookInfo editbookinfo = new EditBookInfo();
        } // end of method
    } // end of listener class
    
    // Class: Remove Book Button Listener.
    private class RemoveBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog removeDialog = new JDialog();
            JLabel removeLbl = new JLabel("     The selected book has been removed.");
            removeDialog.add(removeLbl);
            removeDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            removeDialog.setModal(true);
            removeDialog.setTitle("Removed Book");
            removeDialog.setResizable(false);
            removeDialog.setSize(300,100);
            removeDialog.setLocationRelativeTo(null);
            removeDialog.setVisible(true);
        } // end of method
    } // end of listener class
} // end of class
