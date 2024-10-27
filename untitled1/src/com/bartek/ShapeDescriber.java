package com.bartek;

public class ShapeDescriber {
    public static void describe(Shape shape) {
        System.out.println("Area: " + shape.getArea());
        System.out.println("Perimeter: " + shape.getPerimeter());
    }
}
