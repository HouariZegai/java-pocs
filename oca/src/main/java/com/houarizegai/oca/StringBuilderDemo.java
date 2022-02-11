package com.houarizegai.oca;

public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Java8");
        sb.reverse().deleteCharAt(0).append("SE").delete(3, sb.length());
        System.out.println(sb);
    }
}
