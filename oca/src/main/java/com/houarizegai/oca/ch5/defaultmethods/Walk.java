package com.houarizegai.oca.ch5.defaultmethods;

interface Walk {

    default int getSpeed() {
        return 5;
    }
}

interface Run {

    default int getSpeed() {
        return 10;
    }
}

abstract class Animal implements Walk, Run {
}

class Cat implements Walk, Run {

    public static void main(String[] args) {
        System.out.println(new Cat().getSpeed());
    }
}