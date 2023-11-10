package utils;

import java.awt.image.BufferedImage;

public final class Constants {
    public static final String BLOCKS_DIRECTORY = System.getProperty("user.home") + "/blocks/";
    public static final String BLOCKS_PATH = BLOCKS_DIRECTORY + "blocks.txt";
    public static final String IMAGES_PATH = BLOCKS_DIRECTORY + "images/";
    public static final int IMG_TYPE = BufferedImage.TYPE_INT_RGB;
}
