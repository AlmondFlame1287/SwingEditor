package blocks;

import java.awt.Color;
import java.io.Serializable;

public abstract class Block implements Serializable {
    public static final int SIZE = 32;
    protected static int blockCount = 0;
    protected int blockID;
    protected String name;
    protected Color color;

    public Block(String name, Color color) {
        this.name = name;
        this.color = color;
        this.blockID = blockCount;
        blockCount++;
    }

    public Color getColor() {
        return this.color;
    }
    public String getName() { return this.name; }
}
