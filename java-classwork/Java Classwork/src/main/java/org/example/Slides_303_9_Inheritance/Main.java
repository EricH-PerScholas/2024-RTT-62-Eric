package org.example.Slides_303_9_Inheritance;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static double PI = 3.14159;

    public static void main(String[] args ) {
        List<Shape> shapes = new LinkedList<>();

        Circle c = new Circle();
        c.setName("Circle");
        c.setDiameter(10.0);

        shapes.add(c);

        Rectangle r = new Rectangle("rectangle");
        r.setLength(10);
        r.setWidth(5);

        shapes.add(r);

        // this is giving an error because Shape has an unimplemented method calculateArea
        // thats why we cant make a new one.
        /* Shape s = new Shape(); */

        // the compiler can automatically go from a child to a parent without typecasting
        // its only when you want to go from a parent to child that you need to typecast it
        Shape s1 = new Rectangle();

        // cant do this because you cant make the parent class and you cant assing a shape to a rectangle
        /* Rectangle r1 = new Shape(); */

        for ( Shape shape : shapes ) {
            // in the case where you might care what kind of shape it is you need to ask
            // using instanceof
            if ( shape instanceof Circle ) {
                Circle c1 = (Circle)shape;
                c1.setDiameter(134);
            }

            //95% of the time you dont care what kind of shape it is you are just acting on all shapes
            System.out.print("The area of " + shape.getName() + " equals " + shape.calculateArea());
            System.out.println(" and the perimeter is " + shape.calculatePerimeter());

            shape.officialNameOfShape();
        }

        List<Object> olist = new ArrayList<>();
    }

}
