package Engine;


import java.awt.*;


public class Tile {
    private final Point point;
    private final Color color;
    private static int TILE_SIZE = 40;
    private static int STEP_SIZE = TILE_SIZE / 2;

    public Tile(Color c, Point p){
        this.color = c;
        this.point = p;
    }
    public static int getTileSize(){
        return TILE_SIZE;
    }
    public Point getLocation(){
        return new Point(point);
    }
    public Color getColor(){return color;}
    public void setLocation(int x, int y){ point.setLocation(x, y);}
    public void setLocation(Point p){ point.setLocation(new Point(p));}

    public static void setTileSize(int size){
        TILE_SIZE = size;
    }


    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(point.x, point.y, TILE_SIZE, TILE_SIZE);
    }

    public Tile clone(){
        return new Tile(color, new Point(point));
    }

}
