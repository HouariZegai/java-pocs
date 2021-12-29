package com.houarizegai.oca.ch4.constructor;

public class Circle extends Shape {

    static {
        System.out.println("static block");
    }

    {
        System.out.println("reference block");
    }

    public Circle() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        new Circle();
    }
}
