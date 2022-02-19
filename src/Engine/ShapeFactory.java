package Engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TODO make it possible to create a random shape consisting of any number of squares
public class ShapeFactory {
    public static List<Tile> generateShape(int x, int y ){
        List<Tile> tiles = new ArrayList<>();
        Color rndColor = randomColor();
        Tile currentTile = new Tile(rndColor, new Point(x,y));
        tiles.add(currentTile);

        for (int i = 0; i < 3; i++) {
            currentTile = new Tile(rndColor, nextPoint(tiles, currentTile));
            tiles.add(currentTile);
        }
        return tiles;
    }

    public static Tile generateTile(int x, int y){
        Color rndColor = randomColor();
        return new Tile(rndColor, new Point(x,y));
    }


    /**
     *
     * @param tiles cluster of tiles that the new tile is to be added to
     * @param sq last square that's been added to the shape
     * @return point that is not already occupied by the shape, but touches it
     */
    private static Point nextPoint(List<Tile> tiles, Tile sq) {
        Point newPoint;

        Random rand = new Random();
        boolean isX =  rand.nextBoolean();
        int sign =  rand.nextBoolean() ? 1 : -1;

        if (isX)
            newPoint =  new Point(sq.getLocation().x + sign * Tile.getTileSize(), sq.getLocation().y);
        else
           newPoint = new Point(sq.getLocation().x, sq.getLocation().y + sign * Tile.getTileSize());



        for (int i = 0; i < tiles.size(); i++)
            if (newPoint.equals(tiles.get(i).getLocation()))
                return nextPoint(tiles, sq); // try again
        return newPoint;
    }


    /**
     *
     * @return random light color
     */
    private static Color randomColor(){
        Random rnd = new Random();
        float r = (float) (rnd.nextFloat() / 2f + 0.5);
        float g = (float) (rnd.nextFloat() / 2f + 0.5);
        float b = (float) (rnd.nextFloat() / 2f + 0.5);
        return new Color(r,g,b);

    }

}
