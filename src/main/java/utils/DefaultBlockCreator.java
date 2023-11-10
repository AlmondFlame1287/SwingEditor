package utils;

import blocks.Block;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static utils.Constants.IMAGES_PATH;
import static utils.Constants.IMG_TYPE;

public class DefaultBlockCreator implements Runnable {
    @Override
    public void run() {
        createImage("Air", Color.WHITE);
        createImage("Grass", Color.GREEN);
        createImage("Dirt", Color.decode("#964B00"));
        createImage("Spawnpoint", Color.RED);
    }

    private void createImage(String blockName, Color c) {
        final int IMG_SIZE = Block.SIZE * 10;

        BufferedImage img = new BufferedImage(IMG_SIZE, IMG_SIZE, IMG_TYPE);
        Graphics2D g2d = img.createGraphics();

        g2d.setColor(c);
        g2d.fillRect(0, 0, IMG_SIZE, IMG_SIZE);
        g2d.dispose();
        
        this.saveImage(blockName, img);
    }

    private void saveImage(String blockName, BufferedImage img) {
        File imgDir = new File(IMAGES_PATH);
        File imgFile = new File(IMAGES_PATH + blockName + ".png");

        if(imgFile.exists()) return;

        try {
            if(!imgDir.exists())
                imgDir.mkdir();

            imgFile.createNewFile();
            ImageIO.write(img, "png", imgFile);
        } catch(IOException ioe) {
            System.err.println("[DEFAULT_BLOCK_CREATOR] There was a problem: " + ioe.getMessage());
        }
    }
}
