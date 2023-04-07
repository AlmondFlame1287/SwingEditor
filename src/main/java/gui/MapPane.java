package gui;

import blocks.Block;
import elements.Map;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MapPane extends JPanel {
    public JFrame frame;
    private final Map map = new Map();

    public MapPane(JFrame frame) {
        this.frame = frame;
        this.initPane();
    }

    private File getFileFromFileChooser() {
        JFileChooser jfc = new JFileChooser();
        int result = jfc.showOpenDialog(this);

        if(result == JFileChooser.APPROVE_OPTION) {
            return jfc.getSelectedFile();
        }
        return null;
    }

    private void initPane() {
        this.reload();
    }

    public void reload() {
        map.load(getFileFromFileChooser());
        drawMap(this.getGraphics());
    }

    private void drawMap(Graphics g) {
        if(!map.isMapLoaded()) return;

        int x = 0;
        int y = 300;

        for (int i = 0; i < map.getYLines(); i++) {
            for (int j = 0; j < map.getXLines(i); j++) {
                g.fillRect(x, y, Block.SIZE, Block.SIZE);
                x += Block.SIZE;
            }

            y += Block.SIZE;
        }
    }
}
