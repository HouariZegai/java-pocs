package com.houarizegai.oca;

class A {
    public String toString() {
        return null;
    }
}

public class StringConcatenationDemo {

    public static void main(String [] args) {
        String text = null;
        text = text + new A();
        System.out.println(text.length());
    }
}

