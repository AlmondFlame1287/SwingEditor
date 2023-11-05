package gui.blockcreation;

import javax.swing.*;
import java.awt.*;

public class CreationPanel extends JPanel {
    private static final JButton OK = new JButton("OK");
    private static final JButton CANCEL = new JButton("CANCEL");
    private static final JButton COLOR_PICK = new JButton("COLORS");
    private static final JTextField BLOCK_NAME = new JTextField("Insert block name here");
    private static final DrawingPanel DRAWING_PANEL = new DrawingPanel();


    public CreationPanel() {
        this.setLayout(null);
        this.initLayout();
    }

    private void initLayout() {
        this.add(DRAWING_PANEL);
    }
}
