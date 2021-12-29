package com.houarizegai.oca.ch4;

public class StaticDemo {

    static int x = 10;
    int y;

    static void greeting() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        StaticDemo obj = new StaticDemo();
        obj.greeting();
        obj = null;
        obj.greeting();
        System.out.println(obj.x);
        System.out.println(obj.y);
    }
}
