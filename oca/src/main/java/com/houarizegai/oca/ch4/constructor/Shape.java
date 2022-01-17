package com.houarizegai.oca.ch4.constructor;

public class Shape {

    static {
        System.out.println("super static block");
    }

    {
        System.out.println("super reference block");
    }

    public Shape() {
        System.out.println("super constructor");
    }
}
