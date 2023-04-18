package main;

import gui.EditorPane;
import gui.MapPane;

import javax.swing.*;

public class Main extends JFrame  {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 800;
    private final JSplitPane mainPanel = new JSplitPane();
    private final EditorPane editorPane = new EditorPane(this);
    private final MapPane mapPane = new MapPane(this);

    public Main() {
        this.setupJMenuBar();
        this.setupMainPanel();
        this.init();
    }

    private void setupJMenuBar() {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");

        save.addActionListener(evt -> {
            JFileChooser jfc = new JFileChooser();
            int result = jfc.showSaveDialog(this);

            if(result == JFileChooser.APPROVE_OPTION) {
                MapPane.getMap().save(jfc.getSelectedFile());
            }
        });

        load.addActionListener(evt -> mapPane.reload());

        menu.add(save);
        menu.add(load);

        bar.add(menu);
        this.setJMenuBar(bar);
    }

    private void setupMainPanel() {
        mainPanel.setDividerLocation(600);
        mainPanel.setLeftComponent(mapPane);
        mainPanel.setRightComponent(editorPane);
        mainPanel.setEnabled(false);
    }

    private void init() {
        this.setTitle("Ciccio Editor");
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
