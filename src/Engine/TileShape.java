package Engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TileShape {
    private List<Tile> ls = new ArrayList<>();

    //TODO remove
    public Point getFirstCoordinate() {
        return ls.get(0).getLocation();
    }

    //TODO error correction
    public Tile getSquare(int i) {
        return ls.get(i);
    }

    //TODO remove
    public List<Tile> getHole(){
        return ls;
    }

    public void addSquare(Tile s) {
        ls.add(s);
    }

    public void moveRight() {
        for (Tile s : ls)
            s.moveRight();
    }

    public void moveLeft() {
        for (Tile s : ls)
            s.moveLeft();
    }

    public void moveUp() {
        for (Tile s : ls)
            s.moveUp();
    }

    public void moveDown() {
        for (Tile s : ls)
            s.moveDown();
    }

    public boolean isFreeSpace(Point p) {
        for (Tile s : ls)
            if (p.equals(s.getLocation()) == true)
               return false;
        return true;
    }

}
