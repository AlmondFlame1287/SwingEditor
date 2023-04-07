package blocks;

import java.awt.*;

public abstract class Block {
    public static final int SIZE = 32;
    protected static int blockCount = 0;
    protected int blockID;
    protected Color color;
    protected String name;

    public Block() {
        this.blockID = blockCount;
        blockCount++;
    }

    public Color getColor() {
        return this.color;
    }
}
