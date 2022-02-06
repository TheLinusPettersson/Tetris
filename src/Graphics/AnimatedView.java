package Graphics;


import Engine.Tile;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AnimatedView extends JPanel {
    List<Tile> tiles = new ArrayList<>();

    public void setMovingShape(List<Tile> ts){
        this.tiles = ts;
    }
    public AnimatedView(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.darkGray);
        this.setVisible(true);
        this.repaint();
    }
    public void paint(Graphics g) {
        this.setBackground(Color.darkGray);
        if (tiles != null)
            tiles.forEach(tile -> tile.paint(g));
    }
}
