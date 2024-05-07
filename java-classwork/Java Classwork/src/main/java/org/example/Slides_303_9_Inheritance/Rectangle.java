package org.example.Slides_303_9_Inheritance;

public class Rectangle extends Shape {

    private int length;
    private int width;

    public Rectangle() {

    }

    public Rectangle(String name) {
        super(name);
    }

    protected void printName() {
        System.out.println("Rectangle is named rectangle ... rectangle mcrectface");
    }

    @Override
    public double calculateArea() {
        super.printName();
        area = 123;
        return length * width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
