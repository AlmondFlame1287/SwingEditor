package gui.blockcreation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawingPanel extends JPanel implements MouseListener {
    private Color paintColor;
    private Graphics graphics;

    public DrawingPanel() {
        this.paintColor = Color.WHITE;
        this.graphics = this.getGraphics();
        this.init();
    }

    private void init() {
        this.setSize(300, 300);
    }

    public void setColor(Color c) {
        this.paintColor = c;
    }

    private void draw(int x, int y) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        draw(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
