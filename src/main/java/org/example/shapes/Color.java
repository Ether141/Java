package org.example.shapes;

import jakarta.persistence.Embeddable;

@Embeddable
public record Color(int r, int g, int b, int a) {
    public Color(int r, int g, int b) {
        this(r, g, b, 0);
    }

    public Color {
        if (a < 0 || a > 255) {
            throw new IllegalArgumentException("a must be between 0 and 255");
        }

        if (r < 0 || r > 255) {
            throw new IllegalArgumentException("r must be between 0 and 255");
        }

        if (g < 0 || g > 255) {
            throw new IllegalArgumentException("g must be between 0 and 255");
        }

        if (b < 0 || b > 255) {
            throw new IllegalArgumentException("b must be between 0 and 255");
        }
    }
}
