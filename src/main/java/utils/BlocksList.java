package utils;

import blocks.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public final class BlocksList {
    private static final String BLOCKLIST_FOLDER = System.getProperty("user.home") + "/blocks/";
    private static final String BLOCKLIST_PATH = BLOCKLIST_FOLDER + "blocks.txt";
    private static final File BLOCKLIST_FILE = new File(BLOCKLIST_PATH);
    private static Block[] blocks;
    private static String[] blockNames;

    /**
     * Creates new file if the program was run for the first time.
     */
    public static void createNewFile() {
        try {
            File dir = new File(BLOCKLIST_FOLDER);
            boolean dirRes = dir.mkdir();
            boolean fileRes = BLOCKLIST_FILE.createNewFile();
            if(!dirRes && !fileRes) {
                throw new IOException("File was not created successfully");
            }
        } catch(IOException io) {
            System.err.println(io.getMessage());
            System.exit(-1);
        }

        initFile();
    }

    private static void initFile() {
        try(FileWriter fw = new FileWriter(BLOCKLIST_FILE);
            BufferedWriter bw = new BufferedWriter(fw)) {
            Block[] blocksToWrite = {new Air(), new GrassBlock(), new DirtBlock(), new SpawnPointBlock()};

            for (Block block : blocksToWrite) {
                bw.write(block + "\n");
            }
        } catch(IOException io) {
            System.err.println(io.getMessage());
            System.exit(-1);
        }
    }

    /**
     * Updates the file with all the new blocks created / added
     */
    public static void updateFile(Block newBlock) {
        // TODO: Create a block creation class to update files
    }

    /**
     * Reads the <code>BLOCKLIST_FILE</code>
     */
    public static void readFile() {
        if(!BLOCKLIST_FILE.exists())
            createNewFile();


        try(FileReader fr = new FileReader(BLOCKLIST_FILE);
            BufferedReader br = new BufferedReader(fr)) {

            ArrayList<Block> readBlocks = new ArrayList<>();
            String str;

            while((str = br.readLine()) != null) {
                String[] blockProperties = str.split(",");
                System.out.println(Arrays.toString(blockProperties));

                int r, g, b;
                r = Integer.parseInt(blockProperties[1]);
                g = Integer.parseInt(blockProperties[2]);
                b = Integer.parseInt(blockProperties[3]);

                Block newBlock = new Block(blockProperties[0], r, g, b);
                readBlocks.add(newBlock);
            }

            blocks = new Block[readBlocks.size()]; // I don't know if this is going to work
            blockNames = new String[readBlocks.size()];

            for (int i = 0; i < blockNames.length; i++) {
                blockNames[i] = readBlocks.get(i).getName();
                blocks[i] = readBlocks.get(i);
            }

            readBlocks.clear();
        } catch(IOException io) {
            System.err.println(io.getMessage());
            System.exit(-1);
        }

    }

    /**
     * Initializes the list for <code>EditorPane.NAME_LIST</code>
     */
//    public static void initList() {
//        blockSet.add(new GrassBlock());
//        blockSet.add(new Air()); // Do I really need this?
//        blockSet.add(new DirtBlock());
//        blockSet.add(new SpawnPointBlock());
//
//        blocks = new Block[blockSet.size()];
//        blockNames = new String[blocks.length];
//    }

    public static Block[] getBlocks() {
//        if(blocks[0] != null) return blocks;
//
//        int i = 0;
//        for(Block b : blockSet) {
//            blocks[i] = b;
//            i++;
//        }
        return blocks;
    }

    public static String[] getBlockNames() {
//        if(blockNames[0] != null) return blockNames;
//
//        for (int i = 0; i < blockNames.length; i++) {
//            blockNames[i] = blocks[i].getName();
//        }
        return blockNames;
    }
}
