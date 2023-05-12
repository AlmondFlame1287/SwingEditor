package gui;

import blocks.Block;
import elements.GameMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
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

    private void drawMap(Graphics g) {
        if(!GAME_MAP.isMapLoaded()) return;

        Map<Block, Integer[][]> mappedCoords = GAME_MAP.getMappedCoords();
        List<Block> iteratable = new ArrayList<Block>(mappedCoords.keySet());
        for (Block b : iteratable) {
            System.out.println("Block " + b.getName());
            Integer[][] coords = mappedCoords.get(b);
            for (int i = 0; i < coords.length; i++) {
                for (int j = 0; j < coords[0].length; j++) {
                    g.setColor(b.getColor());
                    g.fillRect(coords[i][j], coords[i][j], Block.SIZE, Block.SIZE);
                    System.out.println(coords[i][j]);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.graphics = this.getGraphics();

        if(e.getButton() == MouseEvent.BUTTON1)
            this.drawBlock(e.getX(), e.getY(), EditorPane.getColorFromBlock());
        else
            this.drawBlock(e.getX(), e.getY(), this.getBackground());
    }

    private void drawBlock(int x, int y, Color color) {
        int drawingX = x / Block.SIZE * Block.SIZE;
        int drawingY = y / Block.SIZE * Block.SIZE;

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
