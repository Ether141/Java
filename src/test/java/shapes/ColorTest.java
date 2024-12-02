package shapes;

import org.example.shapes.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {
    @Test
    public void testValidColor() {
        assertDoesNotThrow(() -> new Color(100, 150, 200, 255));
    }

    @Test
    public void testInvalidRedValueTooLow() {
        assertThrows(IllegalArgumentException.class, () -> new Color(-1, 100, 100, 100));
    }

    @Test
    public void testInvalidGreenValueTooLow() {
        assertThrows(IllegalArgumentException.class, () -> new Color(100, -1, 100, 100));
    }

    @Test
    public void testInvalidBlueValueTooLow() {
        assertThrows(IllegalArgumentException.class, () -> new Color(100, 100, -1, 100));
    }

    @Test
    public void testInvalidAlphaValueTooLow() {
        assertThrows(IllegalArgumentException.class, () -> new Color(100, 100, 100, -1));
    }

    @Test
    public void testInvalidRedValueTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> new Color(256, 100, 100, 100));
    }

    @Test
    public void testInvalidGreenValueTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> new Color(100, 256, 100, 100));
    }

    @Test
    public void testInvalidBlueValueTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> new Color(100, 100, 256, 100));
    }

    @Test
    public void testInvalidAlphaValueTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> new Color(100, 100, 100, 256));
    }
}
