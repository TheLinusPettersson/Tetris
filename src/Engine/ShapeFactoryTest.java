package Engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

class ShapeFactoryTest {
    Tile s =  ShapeFactory.generateTile(0,0);

    @Test
    void generateShape() {
    }

    @Test
    void generateSquare() {

        Assertions.assertEquals(s.getLocation(), new Point(0,0));
    }
}