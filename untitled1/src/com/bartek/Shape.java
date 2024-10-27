package com.bartek;

public abstract class Shape {

    public void print() {
        System.out.println(this.getClass().getSimpleName());
    }

    public abstract float getArea();

    public abstract float getPerimeter();
}