package org.example.Slides_303_9_Inheritance;

public class OuterClass {

    public OuterClass(){
        InnerClass ic = new InnerClass();
    }



    private class InnerClass {
        int x;
        int y;
        int z;
    }


}
