package com.houarizegai.oca;

public class StringDemo {

    public static void main(String[] args) {
        String s1 = "OCA";
        String s2 = "OCA" + "";
        System.out.println(s1 == s2);

        String str1 = "OCA";
        String str2 = "OCA ".trim();
        System.out.println(str1 == str2);
    }
}
