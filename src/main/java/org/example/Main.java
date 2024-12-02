package org.example;

import org.example.database.ShapeDTO;
import org.example.database.ShapeDTOImpl;
import org.example.shapes.Color;
import org.example.shapes.Rectangle;
import org.example.shapes.ShapeDescriber;
import org.example.shapes.Triangle;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ShapeDTO dto = new ShapeDTOImpl();

        Rectangle rectangle = new Rectangle(3, 5, new Color(255, 0, 255, 255));
        Triangle triangle = new Triangle(1, 2, 3, new Color(0, 250, 100, 150));

        dto.saveShape(rectangle);
        dto.saveShape(triangle);

        List<Rectangle> rectangles = dto.getAllRectangles();
        List<Triangle> triangles = dto.getAllTriangles();

        ShapeDescriber.describe(rectangles.getFirst());
        ShapeDescriber.describe(triangles.getFirst());

        dto.close();
    }

}