package gui.blockcreation;

import javax.swing.*;
import java.awt.*;

public class CreationPanel extends JPanel {
    private final JDialog parent;
    private static final JButton OK = new JButton("OK");
    private static final JButton CANCEL = new JButton("CANCEL");
    private static final JButton COLOR_PICK = new JButton("COLORS");
    private static final JTextField BLOCK_NAME = new JTextField("Insert block name here");
    private final DrawingPanel DRAWING_PANEL = new DrawingPanel(this);


    public CreationPanel(JDialog parent) {
        this.parent = parent;
        this.setLayout(null);
        this.initLayout();
    }

    private void initLayout() {
        int panelX = ((this.getWidth() / 2) + DRAWING_PANEL.getWidth());
        int panelY = ((this.getHeight() / 2) + DRAWING_PANEL.getHeight() / 2);
        DRAWING_PANEL.setLocation(panelX, panelY);
        this.add(DRAWING_PANEL);

        this.add(OK);
        OK.addActionListener(evt -> this.disposeAndSave());
        OK.setBounds(0, 0, 150, 30);

        this.add(CANCEL);
        CANCEL.addActionListener(evt -> this.parent.dispose());
        CANCEL.setBounds(0, 50, 150, 30);

        this.add(COLOR_PICK);
        COLOR_PICK.addActionListener(evt -> this.showColorPicker());
        COLOR_PICK.setBounds(0, 100, 150, 30);

        this.add(BLOCK_NAME);
        BLOCK_NAME.setBounds(0, 150, 150, 30);
    }

    /**
     * Creates an image of the drawn block and saves it into $usr$/blocks
     */
    private void disposeAndSave() {
        DRAWING_PANEL.saveImage();
        this.parent.dispose();
    }

    public String getBlockName() {
        return BLOCK_NAME.getText();
    }

    private void showColorPicker() {
        Color c = JColorChooser.showDialog(this, "Pick a color", Color.WHITE);
        DRAWING_PANEL.setColor(c);
    }


}
