package com.houarizegai.oca;

public class BooleanDemo {

    public static void main(String[] args) {
        booleanWithValueOf();
        booleanWithNewObj();
    }

    private static void booleanWithValueOf() {
        Boolean b1 = Boolean.valueOf(null);
        Boolean b2 = Boolean.valueOf(false);
        System.out.print((b1 == b2) + " ");
        System.out.print(b1.equals(b2));
    }

    public static void booleanWithNewObj() {
        Boolean b1 = new Boolean(null);
        Boolean b2 = new Boolean(false);
        System.out.print((b1 == b2) + " ");
        System.out.print(b1.equals(b2));
    }
}

