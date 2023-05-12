package elements;

import java.io.File;
import java.io.Serializable;
import java.util.*;

import blocks.Block;

import static utils.SerializationUtil.serialize;
import static utils.SerializationUtil.deserialize;


public class GameMap implements Serializable {

//    public static final int xLines = WIDTH / Block.SIZE;
//    public static final int yLines = HEIGHT / Block.SIZE;
    private boolean isMapLoaded = false;

    private Map<Block, Integer[][]> blockToCoords;

    public GameMap() {
        blockToCoords = new HashMap<>();
    }

//    public static void main(String[] args) {
//        addBlock(230, 230, new Air());
//        Set<Integer[][]> inte = coordsToBlock.keySet();
//
//        for (Integer[][] ints: inte) {
//            System.out.println("Block name = " + coordsToBlock.get(ints).getName());
//        }
//    }

    public boolean isMapLoaded() {
        return this.isMapLoaded;
    }

    public void addBlock(int coordX, int coordY, Block block) {
        this.blockToCoords.put(block, new Integer[][]{
                {coordX, coordY}
        });
    }

    public Map<Block, Integer[][]> getMappedCoords() {
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

        this.blockToCoords = (Map<Block, Integer[][]>) deserialize(mapFile);

        this.isMapLoaded = true;
    }

}
