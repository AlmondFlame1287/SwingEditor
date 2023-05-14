package utils;

import blocks.*;

import java.util.Set;
import java.util.HashSet;

public final class BlocksList {
    private static final Set<Block> blockSet = new HashSet<>();
    private static Block[] blocks;
    private static String[] blockNames;

    public static void initList() {
        blockSet.add(new GrassBlock());
        blockSet.add(new Air());
        blockSet.add(new DirtBlock());
        blockSet.add(new SpawnPointBlock());

        blocks = new Block[blockSet.size()];
        blockNames = new String[blocks.length];
    }

    public static Block[] getBlocks() {
        if(blocks[0] != null) return blocks;

        int i = 0;
        for(Block b : blockSet) {
            blocks[i] = b;
            i++;
        }
        return blocks;
    }

    public static String[] getBlockNames() {
        if(blockNames[0] != null) return blockNames;

        for (int i = 0; i < blockNames.length; i++) {
            blockNames[i] = blocks[i].getName();
        }
        return blockNames;
    }
}
