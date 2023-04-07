package gui;

import blocks.Block;
import blocks.GrassBlock;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class EditorPane extends JPanel {
    public JFrame frame;
    private static final JButton changeBlock = new JButton("Change block");
    private static final JButton setSpawnPoint = new JButton("Set spawn-point");
    private Map<String, Color> nameToColorMap = new HashMap<String, Color>();


    public EditorPane(JFrame parent) {
        this.frame = parent;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.init();
    }

    private void initButtons() {
        final JDialog dialog = new JDialog(frame);
        final JButton done = new JButton("Done");

        dialog.setSize(300, 300);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new FlowLayout());
        dialog.add(done);

        done.addActionListener(evt -> {
            dialog.setVisible(false);
        });

        changeBlock.addActionListener(evt -> dialog.setVisible(!dialog.isVisible()));

    }

    private void init() {
        this.initButtons();
        this.add(changeBlock);
        this.add(setSpawnPoint);
    }
}
