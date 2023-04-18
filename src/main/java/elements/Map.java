package elements;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import blocks.Air;
import blocks.Block;
import utils.SerializationUtil;

import static main.Main.WIDTH;
import static main.Main.HEIGHT;

public class Map implements Serializable {
    private ArrayList<ArrayList<Block>> blocks = new ArrayList<>();
    private boolean isMapLoaded = false;

    public Map() {
        this.initMap();
    }

    private void initMap() {
        for (int i = 0; i < HEIGHT / Block.SIZE; i++) {
            blocks.add(new ArrayList<>());
            for (int j = 0; j < WIDTH / Block.SIZE; j++) {
                blocks.get(i).add(new Air());
            }
        }
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
        blocks.get(yLine).remove(xLine);
        blocks.get(yLine).add(xLine, (Block) block);
    }

    public void deleteMap() {
        if(blocks.isEmpty()) return;

        for (ArrayList<Block> list : blocks) {
            blocks.remove(list);
        }
    }

    public void load(File mapFile) {
        if(mapFile == null) return;

        blocks = (ArrayList<ArrayList<Block>>) SerializationUtil.deserialize(mapFile);
        this.isMapLoaded = true;
    }
}
