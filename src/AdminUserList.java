/*
* File: AdminUserList.java
* Author: Group 1 (John Kucera, Jason Martin, Ursula Richardson)
* Creation Date: February 18, 2022
* Purpose: 
*/

// import necessary Java classes
import java.awt.BorderLayout;
import java.awt.Dimension;
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

// Class: AdminUserList extends JPanel. Is the List Users menu.
public class AdminUserList extends JPanel {
    // Component Initialization
    private final JButton removeBtn = new JButton("Remove User");
    
    // Creating table model to hold data
    private final String[][] dataSkeleton = null;
    private final String[] usersColumns = {"Username", "Name"};
    private final DefaultTableModel usersModel = new DefaultTableModel(dataSkeleton, usersColumns);
    
    // Constructor (Extends JPanel)
    AdminUserList() {
        // Creating Header Panel
        final JLabel headerLbl = new JLabel("<HTML><U>User List</U></HTML>");
        final JPanel headerPanel = new JPanel();
        headerPanel.add(headerLbl);
        
        // Creating Books Table. 
        final JTable usersTbl = new JTable(usersModel);
        final JScrollPane usersScroll = new JScrollPane(usersTbl);
        usersScroll.setPreferredSize(new Dimension(500,usersTbl.getRowHeight()*20));
        usersTbl.getTableHeader().setPreferredSize(new Dimension(100, 32));
        usersTbl.setDefaultEditor(Object.class, null);
        usersTbl.setSelectionModel(new ForcedListSelectionModel());
        usersTbl.getSelectionModel().addListSelectionListener(new RowSelectionListener());
        
        // Example User Entries for Users Table
        for (int i = 0; i < 25; i++) {
            usersModel.addRow(new Object[] {"the username", "the person name"});
        }

        // Editing Button
        removeBtn.addActionListener(new RemoveBtnListener());
        removeBtn.setEnabled(false);
        
        // Creating Full Panel and adding all panels
        final JPanel fullPanel = new JPanel(new BorderLayout(0, 12));
        fullPanel.add(headerPanel, BorderLayout.PAGE_START);
        fullPanel.add(removeBtn, BorderLayout.CENTER);
        fullPanel.add(usersScroll, BorderLayout.PAGE_END);
        add(fullPanel);
    } // end of constructor
    
    // Class: Row Selection Listener.
    private class RowSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            removeBtn.setEnabled(true);
        }  // end of method
    } // end of listener class
    
    // Class: Remove User Button Listener.
    private class RemoveBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog removeDialog = new JDialog();
            JLabel removeLbl = new JLabel("     The selected user has been removed.");
            removeDialog.add(removeLbl);
            removeDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            removeDialog.setModal(true);
            removeDialog.setTitle("Removed User");
            removeDialog.setResizable(false);
            removeDialog.setSize(300,100);
            removeDialog.setLocationRelativeTo(null);
            removeDialog.setVisible(true);
        } // end of method
    } // end of listener class
}
