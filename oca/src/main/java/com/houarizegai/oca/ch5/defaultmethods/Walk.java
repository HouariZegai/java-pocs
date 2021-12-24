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

/*
abstract class Animal implements Walk, Run { // DOES NOT COMPILE
}

class Cat implements Walk, Run { // DOES NOT COMPILE

    public static void main(String[] args) {
        System.out.println(new Cat().getSpeed());
    }
}*/
