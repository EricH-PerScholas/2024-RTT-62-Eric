package org.example.Slides_303_9_Inheritance;

public class Square extends Shape{

    private int width;

    @Override
    public double calculateArea() {
        return width * width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
