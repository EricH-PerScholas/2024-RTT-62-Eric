package org.example.Slides_303_9_Inheritance;

import java.util.Arrays;

public class Circle extends Shape {


    private double diameter;

    public double calculateArea() {
        return Math.PI * (diameter / 2) * (diameter / 2);
    }






























    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
}

