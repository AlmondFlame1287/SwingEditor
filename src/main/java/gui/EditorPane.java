package gui;

import blocks.Air;
import blocks.Block;
import blocks.DirtBlock;
import blocks.GrassBlock;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.JDialog;

import java.awt.FlowLayout;

import java.util.HashMap;
import java.util.Map;


public class EditorPane extends JPanel {
    public JFrame frame;
    private static final JButton changeBlock = new JButton("Change block");
    private static final JButton setSpawnPoint = new JButton("Set spawn-point");
    private static final String[] blocks = {
        "Air", "Grass", "Dirt"
    };
    private static final Map<Integer, Block> indexToBlockMap = new HashMap<>();
    private static final JList<String> nameList = new JList<>(blocks);

    private static int indexChoosen;


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
        dialog.add(nameList);
        dialog.add(done);

        done.addActionListener(evt -> {
            dialog.setVisible(false);
            indexChoosen = nameList.getSelectedIndex();
        });

        changeBlock.addActionListener(evt -> dialog.setVisible(!dialog.isVisible()));
    }


    public static Block getBlock() {
        return indexToBlockMap.get(indexChoosen);
    }

    private void init() {
        this.initMap();
        this.initButtons();
        this.add(changeBlock);
        this.add(setSpawnPoint);
    }

    private void initMap() {
        indexToBlockMap.put(0, new Air());
        indexToBlockMap.put(1, new GrassBlock());
        indexToBlockMap.put(2, new DirtBlock());
    }
}
