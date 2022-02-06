package Engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShapeTest {
    TileShape shape = new TileShape();
    @Test
    void addSquare() {
        Tile tile = ShapeFactory.generateTile(0,0);
        shape.addSquare(tile);
        Assertions.assertEquals(tile, shape.getSquare(0));
    }

    @Test
    void moveRight() {
    }

    @Test
    void moveLeft() {
    }

    @Test
    void moveUp() {
    }

    @Test
    void moveDown() {
    }

    @Test
    void isFreeSpace() {
    }
}