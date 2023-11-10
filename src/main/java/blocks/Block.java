package blocks;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import static utils.Constants.IMAGES_PATH;

public class Block implements Serializable {
    public static final int SIZE = 32;
    private final int[] coords = new int[2];
    protected String name;
    protected File imgFile;

    public Block(String name, String path) {
        this.name = name;
        imgFile = new File(path);
    }

    public Block(String name) {
        this.name = name;
        imgFile = new File(IMAGES_PATH + this.name + ".png");
    }

    public Image getImage() {
        try {
            if(!imgFile.exists())
                throw new FileNotFoundException("File doesn't exist");
            return ImageIO.read(imgFile).getScaledInstance(SIZE, SIZE, Image.SCALE_FAST);
        } catch (IOException ioe) {
            System.err.println("[BLOCK] There was a problem getting the image: " + ioe.getMessage());
        }
        return null;
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
