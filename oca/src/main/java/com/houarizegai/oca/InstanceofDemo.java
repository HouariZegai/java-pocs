package com.houarizegai.oca;

public class InstanceofDemo {

    public static void main(String[] args) {
        Error obj = new Error();
        // compile error in: Line 1 and Line 2
//        boolean flag1 = obj instanceof RuntimeException; //Line n1
//        boolean flag2 = obj instanceof Exception; //Line n2
        boolean flag3 = obj instanceof Error; //Line n3
        boolean flag4 = obj instanceof Throwable; //Line n4
//        System.out.println(flag1 + ":" + flag2 + ":" + flag3 + ":" + flag4);
    }
}
