
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KILLY
 */
public class ForcedListSelectionModel extends DefaultListSelectionModel{
    public ForcedListSelectionModel () {
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } // end of method

        @Override
        public void clearSelection() {
        } // end of method

        @Override
        public void removeSelectionInterval(int index0, int index1) {
        } // end of method
}
