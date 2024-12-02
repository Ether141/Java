package shapes;

import org.example.shapes.Color;
import org.example.shapes.Rectangle;
import org.example.shapes.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeTest {
    @Test
    public void testRectanglePerimeter() {
        Color color = new Color(255, 0, 0, 255);
        Rectangle rect = new Rectangle(4, 3, color);
        float expected = 14f;

        assertEquals(expected, rect.getPerimeter(), 0.01f);
    }

    @Test
    public void testRectangleArea() {
        Color color = new Color(255, 0, 0, 255);
        Rectangle rect = new Rectangle(4, 3, color);
        float expected = 12f;

        assertEquals(expected, rect.getArea(), 0.01f);
    }

    @Test
    public void testTrianglePerimeter() {
        Color color = new Color(255, 0, 0, 255);
        Triangle tria = new Triangle(4, 3, 5, color);
        float expected = 12f;

        assertEquals(expected, tria.getPerimeter(), 0.01f);
    }

    @Test
    public void testTriangleArea() {
        Color color = new Color(255, 0, 0, 255);
        Triangle tria = new Triangle(4, 3, 5, color);
        float expected = 6f;

        assertEquals(expected, tria.getArea(), 0.01f);
    }

    @Test
    public void testGetColorDescription() {
        Rectangle rect = new Rectangle(1, 2, new Color(255, 0, 0));
        String expected = "Red: 255, Green: 0, Blue: 0, Alpha: 0";

        assertEquals(expected, rect.getColorDescription());
    }
}
