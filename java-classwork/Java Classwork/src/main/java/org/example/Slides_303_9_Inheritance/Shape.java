package org.example.Slides_303_9_Inheritance;

public abstract class Shape {

    public static double area;

    private String name;

    // this is the definition for a method that all child classes
    // must implement.  There is no implementation here
    public abstract double calculateArea();







    public Shape() {

    }

    public Shape(String name) {
        this.name = name;
    }

    protected void printName() {
        System.out.println("The name of the shape is " + name);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
