package elements;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import blocks.Block;
import utils.SerializationUtil;

public class Map implements Serializable {
    private ArrayList<ArrayList<Block>> blocks;
    private boolean isMapLoaded = false;

    public Map() {

    }

    public boolean isMapLoaded() {
        return this.isMapLoaded;
    }

    public int getYLines() {
        return blocks.size();
    }

    public int getXLines(int yLine) {
        return blocks.get(yLine).size();
    }

    public void save(File mapFile) {
        SerializationUtil.serialize(blocks, mapFile);
    }

    public <T> void addBlock(int xLine, int yLine, T block) {
        blocks.get(yLine).add(xLine, (Block) block);
    }

    public void load(File mapFile) {
        if(mapFile == null) return;

        blocks = (ArrayList<ArrayList<Block>>) SerializationUtil.deserialize(mapFile);
        this.isMapLoaded = true;
    }
}
