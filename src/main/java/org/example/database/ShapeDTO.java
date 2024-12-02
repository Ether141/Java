package org.example.database;

import org.example.shapes.Rectangle;
import org.example.shapes.Shape;
import org.example.shapes.Triangle;

import java.util.List;

public interface ShapeDTO extends BaseDTO {
    void saveShape(Shape shape);
    List<Rectangle> getAllRectangles();
    List<Triangle> getAllTriangles();
}
