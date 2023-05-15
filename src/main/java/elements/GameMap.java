package elements;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import blocks.Block;

import static utils.SerializationUtil.serialize;
import static utils.SerializationUtil.deserialize;


public class GameMap implements Serializable {

    private boolean isMapLoaded = false;
    private List<Block> blocks;


    public GameMap() {
        this.blocks = new ArrayList<>();
    }


    public boolean isMapLoaded() {
        return this.isMapLoaded;
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    public void save(File mapFile) {
        serialize(this.blocks, mapFile);
    }

    public void deleteMap() {
        this.blocks.clear();
    }
    public void load(File mapFile) {
        if(mapFile == null) return;

        this.blocks = (ArrayList<Block>) deserialize(mapFile);

        this.isMapLoaded = true;
    }

}
