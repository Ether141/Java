package org.example.shapes;

import jakarta.persistence.*;

@Entity
@Table(name = "rectangle")
public class Rectangle extends Shape {

    @Column
    private float a;

    @Column
    private float b;

    public Rectangle() { }

    public Rectangle(float a, float y, Color color) {
        super(color);
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
