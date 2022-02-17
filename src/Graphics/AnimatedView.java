package Graphics;


import Engine.Tile;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AnimatedView extends JPanel {
    private final List<Tile> MovingTiles;
    private final List<Tile> StationaryTiles;
    List<Point> points = new ArrayList<>();
    List<Color> color = new ArrayList<>();

    public AnimatedView(int x, int y, List<Tile> movingTiles, List<Tile> stationaryTiles) {
        this.MovingTiles = movingTiles;
        this.StationaryTiles = stationaryTiles;



        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.darkGray);
        this.setVisible(true);
        this.repaint();
    }
    public void updateView(List<Point> p , List<Color> c){
        this.points = p;
        this.color = c;
    }
    public void paint(Graphics g) {
        for (int i = 0; i< points.size(); i++){
            g.setColor(color.get(i));
            g.fillRect(points.get(i).x, points.get(i).y, Tile.getTileSize(), Tile.getTileSize());
        }
    }
}
