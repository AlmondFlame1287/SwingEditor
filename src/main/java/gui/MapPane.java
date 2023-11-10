package gui;

import blocks.Block;
import elements.GameMap;

import javax.swing.JPanel;
import javax.swing.JFileChooser;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;

import java.io.File;

public class MapPane extends JPanel implements MouseListener {
    private static final GameMap GAME_MAP = new GameMap();
    private Graphics graphics;

    public MapPane() {
        this.addMouseListener(this);
    }

    public static GameMap getMap() {
        return GAME_MAP;
    }

    public static File getFileFromFileChooser() {
        JFileChooser jfc = new JFileChooser();
        int result = jfc.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            return jfc.getSelectedFile();
        }
        return null;
    }

    public void reload() {
        GAME_MAP.load(getFileFromFileChooser());
        drawMap(this.getGraphics());
    }

    public void clear() {
        this.graphics.clearRect(0, 0, 800, 600);
        GAME_MAP.deleteMap();
    }

    private void drawMap(Graphics g) {
        if (!GAME_MAP.isMapLoaded()) return;

        for (Block block : GAME_MAP.getBlocks()) {
            System.out.println("[MAP_PANE]:[LOGGING] Block name: " + block.getName() + " Block x: " + block.getX() +
                    " Block y: " + block.getY());
            g.drawImage(block.getImage(), block.getX(), block.getY(), null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            this.drawBlock(e.getX(), e.getY(), EditorPane.getBlock());
        else
            this.drawBlock(e.getX(), e.getY(), null);
    }

    private void drawBlock(int x, int y, Block blockToDraw) {
        int drawingX = x / Block.SIZE * Block.SIZE;
        int drawingY = y / Block.SIZE * Block.SIZE;

        if (blockToDraw == null) {
            this.graphics.setColor(this.getBackground());
            this.graphics.fillRect(drawingX, drawingY, Block.SIZE, Block.SIZE);
            return;
        }

        if (blockToDraw.getImage() == null) {
            System.err.println("[MAP_PANE] Couldn't draw image");
            return;
        }

        blockToDraw.setCoords(drawingX, drawingY);
        GAME_MAP.addBlock(blockToDraw);

        this.graphics.drawImage(blockToDraw.getImage(), drawingX, drawingY, null);
    }


    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (this.graphics == null)
            this.graphics = this.getGraphics();
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

