package org.example.shapes;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Shape {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "r", column = @Column(name = "red")),
            @AttributeOverride(name = "g", column = @Column(name = "green")),
            @AttributeOverride(name = "b", column = @Column(name = "blue")),
            @AttributeOverride(name = "a", column = @Column(name = "alpha"))
    })
    private Color color;

    public Shape() {
        color = new Color(0, 0, 0);
    }

    public Shape(Color color) {
        this.color = color;
    }

    public void print() {
        System.out.println(this.getClass().getSimpleName());
    }

    public String getColorDescription() {
        return "Red: %d, Green: %d, Blue: %d, Alpha: %d".formatted(color.r(), color.g(), color.b(), color.a());
    }

    public abstract float getArea();

    public abstract float getPerimeter();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}