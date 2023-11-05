package blocks;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class Block implements Serializable {
    public static final int SIZE = 32;
    public static final String IMAGE_DIR = System.getProperty("user.home") + "/blocks/";
    private final int[] coords = new int[2];
    protected String name;
    protected Color color;
    protected Image blockTexture;

    public Block(String name) {
        this.name = name;
        this.loadImage();
    }

    private void loadImage() {
        try {
            File imgFile = new File(IMAGE_DIR + this.name + ".png");
            if(!imgFile.exists())
                throw new FileNotFoundException("File doesn't exist");
            this.blockTexture = ImageIO.read(imgFile);
        } catch(FileNotFoundException fnf) {
            System.err.println("[BLOCK] " + fnf.getMessage());
        } catch(IOException ioe) {
            System.err.println("[BLOCK] There was a problem reading the image: " + ioe.getMessage());
        }
    }

    public Block(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    @Deprecated
    public Block(String name, int r, int g, int b) {
        this.name = name;
        this.color = new Color(r, g, b);
    }


    public Color getColor() {
        return this.color;
    }

    public String getName() { return this.name; }
    public int getX() {
        return this.coords[0];
    }

    public int getY() {
        return this.coords[1];
    }

    public void setCoords(int x, int y) {
        this.coords[0] = x;
        this.coords[1] = y;
    }

    public String toString() {
        return this.name + "," + this.color.getRed() + "," + this.color.getGreen() + "," + this.color.getBlue();
    }
}
