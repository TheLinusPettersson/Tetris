package Graphics;


import Engine.Tile;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controls the animated part of the game
 * @author Linus Pettersson
 */
public class AnimatedView extends JPanel {
    List<Point> points = new ArrayList<>();
    List<Color> color = new ArrayList<>();

    /**
     *
     * @param windowWidth width of AnimatedView
     * @param windowHeight height of AnimatedView
     */
    public AnimatedView(int windowWidth, int windowHeight) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(windowWidth,  windowHeight / (3/2)));
        this.setBackground(Color.darkGray);
        this.setVisible(true);
    }

    /**
     * @pre p.size() == c.size(), p.get(i) and c.get(i) contains information about the same tile;
     * @param p list of the objects points
     * @param c the same objects color, in tha same order as the points
     */
    public void updateView(List<Point> p , List<Color> c){
        this.points = p;
        this.color = c;
        this.repaint();
    }

    /**
     * paints the tiles
     * @param g graphics
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i< points.size(); i++){
            g.setColor(color.get(i));
            g.fillRect(points.get(i).x, points.get(i).y, Tile.getTileSize(), Tile.getTileSize());
        }
    }
}
