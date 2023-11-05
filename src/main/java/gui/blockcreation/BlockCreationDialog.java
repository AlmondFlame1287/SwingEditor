package gui.blockcreation;

import javax.swing.*;

/**
 * Contains all the necessary objects to create a new block
 *  <ul>
 *      <li>Drawing space</li>
 *      <li>Block name</li>
 *      <li>Ok button (Saves the block and discards the dialog)</li>
 *      <li>Cancel button (discards the dialog)</li>
 *  </ul>
 *
 */
public class BlockCreationDialog extends JDialog {
    private static final CreationPanel MAIN_PANEL = new CreationPanel();

    public BlockCreationDialog() {
        this.setSize(1280, 720);
        this.setContentPane(MAIN_PANEL);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BlockCreationDialog::new);
    }

}
