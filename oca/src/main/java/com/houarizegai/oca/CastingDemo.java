package com.houarizegai.oca;

public class CastingDemo {

    CastingDemo(Integer I) {
        System.out.print(0);
    }

    CastingDemo(int... i) {
        System.out.print(1);
    }

    CastingDemo(double d) {
        System.out.print(2);
    }

    CastingDemo(Object o) {
        System.out.print(3);
    }

    public static void main(String[] args) {
        new CastingDemo('a'); // Can be promoted to int or double
        new CastingDemo(10);
        new CastingDemo(10.5);
    }
}
