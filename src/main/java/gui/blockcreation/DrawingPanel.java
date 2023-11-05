package gui.blockcreation;

import blocks.Block;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Drawing panel for the BlockCreation structure
 */
public class DrawingPanel extends JPanel implements MouseListener {
    private Color paintColor;
    private Graphics graphics;
    private BufferedImage img;
    private Graphics2D imgGraphics;
    private final CreationPanel parent;

    public DrawingPanel(CreationPanel parent) {
        this.parent = parent;
        this.paintColor = Color.WHITE;
        this.init();
    }

    private void init() {
        this.setSize(Block.SIZE * 10, Block.SIZE * 10);
        this.img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.imgGraphics = this.img.createGraphics();
        this.addMouseListener(this);
        this.setBorder(BorderFactory.createTitledBorder("Drawing area"));
    }

    public void setColor(Color c) {
        this.paintColor = c;
    }

    private void draw(int x, int y) {
        int drawingX = x / Block.SIZE * Block.SIZE;
        int drawingY = y / Block.SIZE * Block.SIZE;

        System.out.println("PAINTED AT X:" + drawingX + " Y: " + drawingY);

        this.graphics.setColor(this.paintColor);
        imgGraphics.setColor(this.paintColor);
        this.graphics.fillRect(drawingX, drawingY, Block.SIZE, Block.SIZE);
        imgGraphics.fillRect(drawingX, drawingY, Block.SIZE, Block.SIZE);
    }

    public void saveImage() {
        File dir = new File(System.getProperty("user.home")+ "/blocks/");
        File f = new File(System.getProperty("user.home")+ "/blocks/" + parent.getBlockName() + ".png");

        try {
            if(!dir.exists())
                dir.mkdir();
            if(!f.exists())
                f.createNewFile();
           ImageIO.write(img, "png", f);
        } catch (IOException ioe) {
            System.err.println("[DRAWING PANEL] Error with file: " + ioe.getMessage());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        draw(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(this.graphics == null)
            this.graphics = getGraphics();
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
