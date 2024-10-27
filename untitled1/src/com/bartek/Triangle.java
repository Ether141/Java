package com.bartek;

public class Triangle extends Shape {

    public float a;
    public float b;
    public float c;

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public float getArea() {
        float p = getPerimeter() * 0.5f;
        return (float)Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public float getPerimeter() {
        return a + b + c;
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

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }
}
