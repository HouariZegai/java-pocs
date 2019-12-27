package com.houarizegai.javase.java8;

public class CharacterDemo {
    public static void main(String[] args) {
        Character ch = new Character('A');
        System.out.println(Character.isLetter(ch));
        System.out.println(Character.isAlphabetic(ch));
        System.out.println(Character.isDigit(ch));
        System.out.println(Character.isWhitespace(ch));
        System.out.println(Character.isUpperCase(ch));
        System.out.println(Character.isLowerCase(ch));
        System.out.println(Character.toString(ch).equals('1'));
    }
}
