package com.houarizegai.oca.ch5.virtualmethods;

public class Bird {

    public String getName() {
        return "Unknown";
    }
}

class Peacock extends Bird {

    public String getName() {
        return "Peacock";
    }

    public static void main(String[] args) {
        Bird bird = new Peacock();
        System.out.println(bird.getName());;
    }
}