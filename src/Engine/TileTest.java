package Engine;

import org.junit.jupiter.api.Assertions;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {
    Tile s = ShapeFactory.generateTile(0,0);

    @org.junit.jupiter.api.Test
    void getLocation() {
        Assertions.assertEquals(s.getLocation(), new Point(0,0));
    }

    @org.junit.jupiter.api.Test
    void moveRight() {
        s.moveRight();
        assertEquals(s.getLocation(), new Point(10, 0));
    }

    @org.junit.jupiter.api.Test
    void moveLeft() {
        s.moveLeft();
        assertEquals(s.getLocation(), new Point(-10, 0));
    }

    @org.junit.jupiter.api.Test
    void moveUp() {
        s.moveUp();
        assertEquals(s.getLocation(), new Point(0, 10));
    }

    @org.junit.jupiter.api.Test
    void moveDown() {
        s.moveDown();
        assertEquals(s.getLocation(), new Point(0, -10));
    }
}