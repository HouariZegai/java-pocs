package com.houarizegai.javase.regex;

import java.util.regex.Pattern;

public class MetaChar {

	public static void main(String[] args){
        /*
			.   : 1 Character
			\d  : [0-9]
			\D  : [^0-9]
			\s  : Space
			\S  : Not Space
			\w  : [a-zA-Z0-9_] All Words
			\W  : Not[a-zA-Z0-9_] == ( /W = [^/w] )
			\b  : ����� ������
			\B  : [^/b]
		*/

		System.out.println("\nMeta Char: ");

		System.out.println(Pattern.matches("\\d","9"));
		System.out.println(Pattern.matches("\\d","9a"));
		System.out.println(Pattern.matches("\\d","987"));

		System.out.println(Pattern.matches("\\D","s"));
		System.out.println(Pattern.matches("\\D","9"));
		System.out.println(Pattern.matches("\\D","dsq9"));
		
		System.out.println(Pattern.matches("\\s"," "));
		System.out.println(Pattern.matches("\\S"," "));
		System.out.println(Pattern.matches("\\w","x"));
		System.out.println(Pattern.matches("\\W","@"));
	}
}
