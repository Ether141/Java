package org.example.database;

import org.example.shapes.Rectangle;
import org.example.shapes.Shape;
import org.example.shapes.Triangle;

import java.util.List;

public class ShapeDTOImpl extends BaseDTOImpl implements ShapeDTO {

    public ShapeDTOImpl() {
        super();
    }

    public ShapeDTOImpl(String configFileName) {
        super(configFileName);
    }

    @Override
    public void saveShape(Shape shape) {
        saveObject(shape);
    }

    @Override
    public List<Rectangle> getAllRectangles() {
        return loadAllObjects(Rectangle.class);
    }

    @Override
    public List<Triangle> getAllTriangles() {
        return loadAllObjects(Triangle.class);
    }
}
