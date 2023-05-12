package elements;

import java.io.File;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

import blocks.Block;

import static utils.SerializationUtil.serialize;
import static utils.SerializationUtil.deserialize;


public class GameMap implements Serializable {

    private boolean isMapLoaded = false;

    private Map<Integer[], Block> blockToCoords;

    public GameMap() {
        blockToCoords = new HashMap<>();
    }


    public boolean isMapLoaded() {
        return this.isMapLoaded;
    }

    public void addBlock(int coordX, int coordY, Block block) {
        this.blockToCoords.put(new Integer[] {coordX, coordY}, block);
    }

    public Map<Integer[], Block> getMappedCoords() {
        return this.blockToCoords;
    }

    public void save(File mapFile) {
        serialize(this.blockToCoords, mapFile);
    }

    public void deleteMap() {
        this.blockToCoords.clear();
    }
    public void load(File mapFile) {
        if(mapFile == null) return;

        this.blockToCoords = (Map<Integer[], Block>) deserialize(mapFile);

        this.isMapLoaded = true;
    }

}
