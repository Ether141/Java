package org.example.shapes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShapeDescriber {
    private final static Logger logger = LoggerFactory.getLogger(ShapeDescriber.class);

    public static void describe(Shape shape) {
        logger.info("Shape: {}, Color: {}", shape.getClass().getSimpleName(), shape.getColorDescription());
        logger.info("Area: {}", shape.getArea());
        logger.info("Perimeter: {}", shape.getPerimeter());
    }
}
