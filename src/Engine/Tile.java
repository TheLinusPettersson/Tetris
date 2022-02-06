package Engine;


import java.awt.*;


public class Tile {
    private final Point point;
    private final Color color;
    private static final int TILE_SIZE = 25;
    private static final int STEP_SIZE = TILE_SIZE / 2;
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
    public void moveRight(){point.setLocation(point.getX() + STEP_SIZE, point.getY());}
    public void moveLeft(){
        point.setLocation(point.getX() - STEP_SIZE, point.getY());
    }
    public void moveUp(){
        point.setLocation(point.getX(), point.getY() - STEP_SIZE);
    }
    public void moveDown(){
        point.setLocation(point.getX(), point.getY() + STEP_SIZE);
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(point.x, point.y, TILE_SIZE, TILE_SIZE);
    }

}
