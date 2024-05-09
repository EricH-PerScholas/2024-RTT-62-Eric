package org.example.Slides_303_9_Inheritance;

public class Rectangle extends Shape {

    private int length;
    private int width;

    @Override
    public double calculateArea() {
        super.printName();
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return (2*length) + (2*width);
    }

    @Override
    public void officialNameOfShape() {
        System.out.println("Rectangle");
    }

    @Override
    public int bedtime() {
        return 12;
    }






























    public Rectangle() {

    }

    public Rectangle(String name) {
        super(name);
    }

    protected void printName() {
        System.out.println("Rectangle is named rectangle ... rectangle mcrectface");
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
