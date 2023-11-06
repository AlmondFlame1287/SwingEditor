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
    protected File imgFile;
    protected Image blockTexture;

    public Block(String name, String path) {
        this.name = name;
        imgFile = new File(path);
        this.loadImage();
    }

    public Block(String name) {
        this.name = name;
        imgFile = new File(IMAGE_DIR + this.name + ".png");
        this.loadImage();
    }

    private void loadImage() {
        try {
            if(!imgFile.exists())
                throw new FileNotFoundException("File doesn't exist");
            this.blockTexture = ImageIO.read(imgFile).getScaledInstance(SIZE, SIZE, Image.SCALE_FAST);
        } catch(FileNotFoundException fnf) {
            System.err.println("[BLOCK] " + fnf.getMessage());
        } catch(IOException ioe) {
            System.err.println("[BLOCK] There was a problem reading the image: " + ioe.getMessage());
        }
    }

    public Image getImage() {
        return this.blockTexture;
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
        return this.name + "," + ((this.imgFile.toString() == null) ? "no_image" : this.imgFile.toString());
    }
}
