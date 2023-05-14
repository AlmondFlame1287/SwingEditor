package utils;

import blocks.Block;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class BlocksList {
    private static final Set<Block> blockSet = new HashSet<>();

    public static void addBlock(Block block) {
        blockSet.add(block);
    }

    public static String[] getBlockNames() {
        List<String> blockNames = new ArrayList<>();
        for(Block b : blockSet) {
            blockNames.add(b.getName());
        }
        return (String[]) blockNames.toArray();
    }
}
