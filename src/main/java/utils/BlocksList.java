package utils;

import blocks.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public final class BlocksList {
    public static final String BLOCKLIST_FOLDER = System.getProperty("user.home") + "/blocks/";
    private static final String BLOCKLIST_PATH = BLOCKLIST_FOLDER + "blocks.txt";
    private static final File BLOCKLIST_FILE = new File(BLOCKLIST_PATH);
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
            System.err.println("[BLOCKLIST] There was a problem: " + io.getMessage());
            System.exit(-1);
        } catch(NullPointerException npe) {
            System.err.println("[BLOCKLIST] There was a problem: " + npe.getMessage());
        }

        initFile();
    }

    private static void initFile() {
        try(FileWriter fw = new FileWriter(BLOCKLIST_FILE);
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
        if(!BLOCKLIST_FILE.exists())
            createNewFile();


        try(FileReader fr = new FileReader(BLOCKLIST_FILE);
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
