package main;

import gui.EditorPane;
import gui.MapPane;
import javax.swing.*;

public class Main extends JFrame  {
    private final JSplitPane mainPanel = new JSplitPane();
    protected final EditorPane editorPane = new EditorPane(this);
    protected final MapPane mapPane = new MapPane(this);

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
        this.setSize(800, 600);
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
