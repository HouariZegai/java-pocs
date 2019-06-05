package com.houarizegai.javase.java8.lambda;

public class LambdaDemo {

    public static void main(String[] args) {
        // example 1: (method without argument)
        MyLambda myLambda = () -> System.out.println("Hello world!");
        myLambda.foo();

        // example 2: (method with argument)
        // using annonymous inner class
        Shape circle = new Shape() {
          public void draw(String str) {
              System.out.println("Hello World ! " + str);
          }  
        };
        circle.draw("Test");

        // using lambda expression
        Shape cir = str -> System.out.println("Hello World ! " + str);
        cir.draw("Test 2");
    }
}