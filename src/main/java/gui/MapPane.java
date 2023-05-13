package gui;

import blocks.Block;
import elements.GameMap;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JFileChooser;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.Color;

import java.io.File;
import java.util.Map;

public class MapPane extends JPanel implements MouseListener {
    public JFrame frame;
    private static final GameMap GAME_MAP = new GameMap();
    private Graphics graphics;

    public MapPane(JFrame frame) {
        this.frame = frame;
        this.addMouseListener(this);
    }

    public static GameMap getMap() {
        return GAME_MAP;
    }

    public static File getFileFromFileChooser() {
        JFileChooser jfc = new JFileChooser();
        int result = jfc.showOpenDialog(null);

        if(result == JFileChooser.APPROVE_OPTION) {
            return jfc.getSelectedFile();
        }
        return null;
    }

    public void reload() {
        GAME_MAP.load(getFileFromFileChooser());
        drawMap(this.getGraphics());
    }

    public void clear() {
        this.getGraphics().clearRect(0, 0, 800, 600);
    }

    private void drawMap(Graphics g) {
        if(!GAME_MAP.isMapLoaded()) return;

        Map<Integer[], Block> mappedCoords = GAME_MAP.getMappedCoords();
        for (Integer[] ints : mappedCoords.keySet()) {
            Block blockToDraw = mappedCoords.get(ints);
            g.setColor(blockToDraw.getColor());
            g.fillRect(ints[0], ints[1], Block.SIZE, Block.SIZE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.graphics = this.getGraphics();

        if(e.getButton() == MouseEvent.BUTTON1)
            this.drawBlock(e.getX(), e.getY(), EditorPane.getBlock().getColor());
        else
            this.drawBlock(e.getX(), e.getY(), this.getBackground());
    }

    private void drawBlock(int x, int y, Color color) {
        int drawingX = x / Block.SIZE * Block.SIZE;
        int drawingY = y / Block.SIZE * Block.SIZE;

        System.out.println("DREW BLOCK AT X:" + drawingX + " Y: " + drawingY);
        GAME_MAP.addBlock(drawingX, drawingY, EditorPane.getBlock());

        this.graphics.setColor(color);
        this.graphics.fillRect(drawingX, drawingY, Block.SIZE, Block.SIZE);
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
