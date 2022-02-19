package Engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//TODO render only the tiles that dont have another tile directly above it.
public class Model {
    private final List<Tile> movingShape;
    private final List<Tile> stationaryTiles;
    private final int gameWidth, gameHeight;
    private int score = 0;

    Model(int x, int y, List<Tile> movingShape, List<Tile> stationaryShape) {
        this.gameWidth = x;
        this.gameHeight = y;
        this.movingShape = movingShape;
        this.stationaryTiles = stationaryShape;
    }

    // *** OUTPUT ***
    public List<Tile> getTileInformation(){
        List<Tile> r = new ArrayList<>();
        for (Tile t : movingShape)
            r.add(t);
        for (Tile t: stationaryTiles)
            r.add(t);
        return r;
    }

    // *** GAME LOGIC ***
    /**
     * @param xStep next x-coordinate step
     * @param yStep next y-coordinate step
     * @return true, if the shape moves out of bounds. false if not.
     */
    public boolean movingShapeOutOfBounds(int xStep, int yStep) {
        for (Tile t : movingShape) {
            if (t.getLocation().x + xStep < 0 || t.getLocation().x + xStep + Tile.getTileSize() > gameWidth)
                return true;
            if (t.getLocation().y +  yStep >= gameHeight)
                return true;
        }
        return false;
    }

    public boolean collision(int xStep, int yStep) {
        if (stationaryTiles != null)
            for (Tile mt : movingShape)
                for (Tile st : stationaryTiles)
                    if (mt.getLocation().x + xStep == st.getLocation().x && mt.getLocation().y + yStep == st.getLocation().y)
                        return true;
        return false;
    }

    public void createNewMovingShape() {
        movingShape.clear();
        movingShape.addAll(ShapeFactory.generateShape(gameWidth / 2, -2 * Tile.getTileSize()));
        fullRow();
    }

    public void toStationary() {
        stationaryTiles.addAll(movingShape);
        createNewMovingShape();
        if (collision(0, 0)) {
            System.out.println("Game Over");
            movingShape.clear();
            stationaryTiles.clear();
        }
    }
    //TODO simplify the shit out of it
    public void fullRow() {
        int nrOfRows = gameHeight / Tile.getTileSize();
        int nrOfColumns = gameWidth / Tile.getTileSize();
        int nrORowClears = 0;
        List<Tile> tilesToRemove = new ArrayList<>();
        
        for (int currentRow = 0; currentRow < nrOfRows; currentRow++) {
            int tilesInRow = 0;

            for (Tile t : stationaryTiles)
                if (t.getLocation().y == currentRow * Tile.getTileSize())
                    tilesInRow++;

            if (tilesInRow == nrOfColumns) {
                nrORowClears++;
                for (Tile t : stationaryTiles) {
                    if (t.getLocation().y == currentRow * Tile.getTileSize())
                        tilesToRemove.add(t);
                    if (t.getLocation().y < currentRow * Tile.getTileSize())
                        t.setLocation(t.getLocation().x, t.getLocation().y + Tile.getTileSize());
                }
                stationaryTiles.removeAll(tilesToRemove);
            }

        }
        System.out.println(nrORowClears);
        increaseScore(nrORowClears);
    }
    private void increaseScore(int nrOfRows){
        switch (nrOfRows){
            case 1:
                this.score += 100;
                break;
            case 2:
                this.score += 300;
                break;
            case 3:
                this.score += 500;
                break;
            case 4:
                this.score += 800;
                break;
        }
    }
    public int getScore(){
        return score;
    }


    // *** MOVEMENT ***
    public void moveRight() {
        if (!movingShapeOutOfBounds(Tile.getTileSize(), 0) && !collision(Tile.getTileSize(), 0))
            movingShape.forEach(tile -> tile.setLocation(tile.getLocation().x + Tile.getTileSize(), tile.getLocation().y));
    }

    public void moveLeft() {
        if (!movingShapeOutOfBounds(-Tile.getTileSize(), 0) && !collision(-Tile.getTileSize(), 0))
            movingShape.forEach(tile -> tile.setLocation(tile.getLocation().x - Tile.getTileSize(), tile.getLocation().y));
    }

    //should go faster down. increase gravity?
    public void moveDown() {
        if (collision(0, Tile.getTileSize()))
            toStationary();
        else if (!movingShapeOutOfBounds(0, Tile.getTileSize()))
            movingShape.forEach(tile -> tile.setLocation(tile.getLocation().x, tile.getLocation().y + Tile.getTileSize()));
        else
            toStationary();
    }

    /**
     * rotates the movingShape 90 degrees clockwise
     */
    public void rotateClockwise() {
        Point stemCoordinates = movingShape.get(1).getLocation();
        List<Tile> tempShape = new ArrayList<>();
        for (Tile t : movingShape)
            tempShape.add(t.clone());

        //rotation clockwise: (y, -x), same but around other point p = (a, b): ((y - b) + a , -(x -a) + b)
        for (Tile t : movingShape)
            t.setLocation(t.getLocation().y - stemCoordinates.y + stemCoordinates.x,
                    -(t.getLocation().x - stemCoordinates.x) + stemCoordinates.y);

        if (movingShapeOutOfBounds(0, 0) || collision(0,0)) {
            for(int i = 0; i < movingShape.size(); i++)
                movingShape.get(i).setLocation(tempShape.get(i).getLocation());
        }
    }

}

