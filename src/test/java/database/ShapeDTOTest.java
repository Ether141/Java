package database;

import org.example.shapes.Color;
import org.example.shapes.Rectangle;
import org.example.shapes.Triangle;
import org.example.database.ShapeDTOImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShapeDTOTest {

    private ShapeDTOImpl shapeDTO;

    @BeforeEach
    public void setup() {
        shapeDTO = new ShapeDTOImpl("hibernate-test.cfg.xml");
    }

    @AfterEach
    void tearDown() {
        shapeDTO.close();
    }

    @Test
    public void testIfTablesWereCreatedSuccessfully() {
        assertTrue(shapeDTO.doesTableExist("rectangle"));
        assertTrue(shapeDTO.doesTableExist("triangle"));
    }

    @Test
    public void testIfRectangleObjectIsSavedToDatabase() {
        // given
        Color color = new Color(255, 125, 20, 255);
        Rectangle rectangle = new Rectangle(5.0f, 10.0f, color);

        // when
        shapeDTO.saveShape(rectangle);

        List<Rectangle> rectangles = shapeDTO.getAllRectangles();

        // then
        assertEquals(1, rectangles.size(), "rectangle table should contain exactly one record!");
        Rectangle loadedRectangle = rectangles.getFirst();
        assertEquals(5.0, loadedRectangle.getA());
        assertEquals(10.0, loadedRectangle.getB());
        assertEquals(color, loadedRectangle.getColor());
    }

    @Test
    public void testIfTriangleTwoObjectsAreSavedToDatabase() {
        // given
        Color color = new Color(255, 125, 20, 255);
        Triangle triangleA = new Triangle(1, 2, 3, color);
        Triangle triangleB = new Triangle(3, 2, 1, color);

        // when
        shapeDTO.saveShape(triangleA);
        shapeDTO.saveShape(triangleB);

        List<Triangle> triangles = shapeDTO.getAllTriangles();

        // then
        assertEquals(2, triangles.size(), "triangle table should contain exactly two records!");

        Triangle loadedTriangle1 = triangles.getFirst();
        assertEquals(1.0, loadedTriangle1.getA());
        assertEquals(2.0, loadedTriangle1.getB());
        assertEquals(3.0, loadedTriangle1.getC());
        assertEquals(color, loadedTriangle1.getColor());

        Triangle loadedTriangle2 = triangles.getLast();
        assertEquals(3.0, loadedTriangle2.getA());
        assertEquals(2.0, loadedTriangle2.getB());
        assertEquals(1.0, loadedTriangle2.getC());
        assertEquals(color, loadedTriangle2.getColor());
    }
}
