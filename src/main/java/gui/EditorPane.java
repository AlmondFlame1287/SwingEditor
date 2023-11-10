package gui;

import blocks.*;
import gui.blockcreation.BlockCreationDialog;
import utils.BlocksList;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.JDialog;

import java.awt.FlowLayout;



public class EditorPane extends JPanel {
    public JFrame frame;
    private static final JList<String> NAME_LIST = new JList<>(BlocksList.getBlockNames());


    public EditorPane(JFrame parent) {
        this.frame = parent;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.init();
    }

    private void initButtons() {
        final JDialog dialog = new JDialog(frame);
        final BlockCreationDialog blockCreationDialog = new BlockCreationDialog();
        final JButton done = new JButton("Done");
        final JButton changeBlock = new JButton("Change block");
        final JButton createBlock = new JButton("Create block");

        dialog.setSize(300, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new FlowLayout());
        dialog.add(NAME_LIST);
        dialog.add(done);

        done.addActionListener(evt -> dialog.setVisible(false));
        changeBlock.addActionListener(evt -> dialog.setVisible(!dialog.isVisible()));
        createBlock.addActionListener(evt -> blockCreationDialog.setVisible(!blockCreationDialog.isVisible()));

        this.add(changeBlock);
        this.add(createBlock);
    }


    public static Block getBlock() {
        try {
            // This is the problem.
            // It returns the same exact block object. To fix: return a new Block of the same type.
            return new Block(BlocksList.getBlockName(NAME_LIST.getSelectedIndex())); // Temp fix maybe?
        } catch (Exception e) {
            System.err.println("[EDITOR_PANE]: Something went wrong: " + e.getMessage());
            return null;
        }
    }

    private void init() {
        this.initButtons();
    }
}
