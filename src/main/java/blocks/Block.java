package blocks;

import java.awt.Color;
import java.io.Serializable;

public abstract class Block implements Serializable {
    public static final int SIZE = 32;
    private final int[] coords = new int[2];
    protected String name;
    protected Color color;
    public Block(String name, Color color) {
        this.name = name;
        this.color = color;
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
}
