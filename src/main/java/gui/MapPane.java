package gui;

import blocks.Block;
import elements.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class MapPane extends JPanel implements MouseListener {
    public JFrame frame;
    private final Map map = new Map();

    public MapPane(JFrame frame) {
        this.frame = frame;
        this.addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            this.drawBlock(e.getX(), e.getY(), Color.blue);
        else
            this.drawBlock(e.getX(), e.getY(), this.getBackground());
    }

    private void drawBlock(int x, int y, Color color) {
        Graphics g = this.getGraphics();
        int drawingX = (x / Block.SIZE) * Block.SIZE;
        int drawingY = (y / Block.SIZE) * Block.SIZE;

        g.setColor(color);
        g.fillRect(drawingX, drawingY, Block.SIZE, Block.SIZE);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
