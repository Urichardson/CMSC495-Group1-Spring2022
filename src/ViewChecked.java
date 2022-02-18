/*
* File: ViewChecked.java
* Author: Group 1 (John Kucera, Jason Martin, Ursula Richardson)
* Creation Date: February 17, 2022
* Purpose: 
*/

// import necessary Java classes
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

// Class: ViewChecked extends JPanel. Is the View Checked-Out Books menu.
public class ViewChecked extends JPanel {
    
    // Component Initialization
    private final JButton returnBtn = new JButton("Return Book");
    
    // Creating table model to hold data
    private final String[][] dataSkeleton = null;
    private final String[] checkedColumns = {"Title", "Author", "Check-Out Date", "<HTML>Check-Out<br>Period (Days)</HTML>"};
    private final DefaultTableModel checkedModel = new DefaultTableModel(dataSkeleton, checkedColumns);
    
    // Constructor (Extends JPanel)
    ViewChecked() {
        // Creating Header Panel
        final JLabel headerLbl = new JLabel("<HTML><U>View Checked-Out Books</U></HTML>");
        final JPanel headerPanel = new JPanel();
        headerPanel.add(headerLbl);

        // Creating Results Table. 
        final JTable checkedTbl = new JTable(checkedModel);
        final JScrollPane checkedScroll = new JScrollPane(checkedTbl);
        checkedScroll.setPreferredSize(new Dimension(500,checkedTbl.getRowHeight()*20));
        checkedTbl.getTableHeader().setPreferredSize(new Dimension(100, 32));
        checkedTbl.setDefaultEditor(Object.class, null);
        checkedTbl.setSelectionModel(new ForcedListSelectionModel());
        checkedTbl.getSelectionModel().addListSelectionListener(new ViewChecked.RowSelectionListener());
        
        // Example Book Entries for Results Table
        for (int i = 0; i < 25; i++) {
            checkedModel.addRow(new Object[] {"the title", "the author", "the date", "the days"});
        }
        
        // Creating Full Panel and adding all panels
        final JPanel fullPanel = new JPanel(new BorderLayout(0, 12));
        fullPanel.add(headerPanel, BorderLayout.PAGE_START);
        returnBtn.addActionListener(new ReturnBtnListener());
        returnBtn.setEnabled(false);
        fullPanel.add(returnBtn, BorderLayout.CENTER);
        fullPanel.add(checkedScroll, BorderLayout.PAGE_END);
        add(fullPanel);
    }
    
    // Class: Row Selection Listener.
    private class RowSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            returnBtn.setEnabled(true);
        }  // end of method
    } // end of listener class
    
    // Class: Return Book Button Listener.
    private class ReturnBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog returnDialog = new JDialog();
            JLabel returnLbl = new JLabel("     The selected book has been returned.");
            returnDialog.add(returnLbl);
            returnDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            returnDialog.setModal(true);
            returnDialog.setTitle("Returned Book");
            returnDialog.setResizable(false);
            returnDialog.setSize(300,100);
            returnDialog.setLocationRelativeTo(null);
            returnDialog.setVisible(true);
        } // end of method
    } // end of listener class
} // end of class
