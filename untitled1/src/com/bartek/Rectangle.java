package com.bartek;

public class Rectangle extends Shape {

    private float a;
    private float b;

    public Rectangle(float a, float y) {
        this.a = a;
        this.b = y;
    }

    @Override
    public float getArea() {
        return a * b;
    }

    @Override
    public float getPerimeter() {
        return (2 * a) + (2 * b);
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }
}
