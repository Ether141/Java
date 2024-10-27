package com.bartek;

public class Application {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(2f, 5f);
        Triangle triangle = new Triangle(2f, 3f, 4f);

        rect.print();
        ShapeDescriber.describe(rect);

        triangle.print();
        ShapeDescriber.describe(triangle);
    }
}
