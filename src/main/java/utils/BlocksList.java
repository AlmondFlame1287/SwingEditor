package utils;

import blocks.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static utils.Constants.BLOCKS_DIRECTORY;
import static utils.Constants.BLOCKS_PATH;

public final class BlocksList {
    private static String[] blockNames;

    /**
     * Creates new file if the program was run for the first time.
     */
    public static void createNewFile() {
        File blockList = new File(BLOCKS_PATH);

        try {
            File dir = new File(BLOCKS_DIRECTORY);
            boolean dirRes = dir.mkdir();
            boolean fileRes = blockList.createNewFile();
            if(!dirRes && !fileRes) {
                throw new IOException("File was not created successfully");
            }
        } catch(IOException io) {
            System.err.println("[BLOCKLIST] There was a problem: " + io.getMessage());
            System.exit(-1);
        } catch(NullPointerException npe) {
            System.err.println("[BLOCKLIST] There was a problem: " + npe.getMessage());
        }

        initFile(blockList);
    }

    private static void initFile(File blockList) {
        try(FileWriter fw = new FileWriter(blockList);
            BufferedWriter bw = new BufferedWriter(fw)) {
            Block[] blocksToWrite = {new Block("Air"), new Block("Grass"), new Block("Dirt"), new Block("Spawnpoint")};

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
        File blockList = new File(BLOCKS_PATH);

        if(!blockList.exists())
            createNewFile();

        try(FileReader fr = new FileReader(blockList);
            BufferedReader br = new BufferedReader(fr)) {

            ArrayList<Block> readBlocks = new ArrayList<>();
            String str;

            while((str = br.readLine()) != null) {
                String[] blockProperties = str.split(",");
                System.out.println(Arrays.toString(blockProperties));


                Block newBlock = new Block(blockProperties[0], blockProperties[1]);
                readBlocks.add(newBlock);
            }

            blockNames = new String[readBlocks.size()];

            for (int i = 0; i < blockNames.length; i++) {
                blockNames[i] = readBlocks.get(i).getName();
            }

            readBlocks.clear();
        } catch(IOException io) {
            System.err.println(io.getMessage());
            System.exit(-1);
        }

    }

    public static String getBlockName(int index) {
        return blockNames[index];
    }

    public static String[] getBlockNames() {
        return blockNames;
    }
}
