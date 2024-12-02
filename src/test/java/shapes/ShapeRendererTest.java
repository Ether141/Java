package shapes;

import org.example.shapes.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShapeRendererTest {
    @Test
    public void testRenderRectangle() {
        Color color = new Color(255, 0, 0, 255);
        Rectangle rect = new Rectangle(4, 3, color);

        String expectedOutput =
                "\033[38;2;255;0;0m****\r\n" +
                "****\r\n" +
                "****\r\n" +
                "\033[0m";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            ShapeRenderer.render(rect);

            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testRenderTriangle() {
        Color color = new Color(255, 0, 0, 255);
        Triangle tria = new Triangle(4, 5, 6, color);

        String expectedOutput =
                "\033[38;2;255;0;0m   *\r\n" +
                "  ***\r\n" +
                " *****\r\n" +
                "*******\r\n" +
                "\033[0m";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            ShapeRenderer.render(tria);

            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testRenderingUnsupportedShape() {
        Shape unsupportedShape = new Shape(null) {

            @Override
            public float getArea() {
                return 0;
            }

            @Override
            public float getPerimeter() {
                return 0;
            }
        };

        assertThrows(UnsupportedOperationException.class, () -> {
            ShapeRenderer.render(unsupportedShape);
        });
    }
}
