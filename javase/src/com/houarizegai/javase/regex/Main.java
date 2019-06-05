package com.houarizegai.javase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		Pattern pat = Pattern.compile("..i");  // Dot . = 1 Char / 2Dot = 2 Char
		Matcher mot = pat.matcher("7oi");
		boolean bool = mot.matches();
		System.out.println(bool);
		// Or 
		boolean bool2 = Pattern.compile("h.uari").matcher("houari").matches();
		System.out.println(bool2);
		// Or
		boolean bool3 = Pattern.matches("h.....","houari");
		System.out.println(bool3);
		
		System.out.println("\nChar Classes Reqular Expression : ");
		
		boolean bool4 = Pattern.matches("[abc][ou]","bo"); // il Existe seulment 2 Char [a Or b Or c]+[o Or u] 
		System.out.println(bool4);
		
		boolean bool5 = Pattern.matches("[^ab]","h"); // il Existe seulment 1 Char Not IN[a Or b]
		System.out.println(bool5);
		
		System.out.println(Pattern.matches("[a-x]","h")); // il Existe 1 Char IN[a .. x]
		System.out.println(Pattern.matches("[a-zA-Z0-9]","A")); // il Existe 1 Char IN[a .. z Or A .. Z Or 1 .. 9]
		System.out.println(Pattern.matches("[a-h[m-y]]","A")); // il Existe 1 Char IN[a .. h Or m .. y ]
		
		System.out.println(Pattern.matches("[a-h&&[abc]]","b")); // il Existe 1 Char IN[a .. h] AND IN[a Or b Or c]
		System.out.println(Pattern.matches("[a-z&&[^abc]]","b")); // il Existe 1 Char IN[a .. z] AND NOT IN[a Or b Or c]
		
		System.out.println(Pattern.matches("[a-z&&[^a-h]]","b")); // il Existe 1 Char IN[a .. z] AND NOT IN[a .. h]

		// ............
		
		System.out.println("\nExemple: ");
		
		System.out.println(Pattern.matches("[a-zA-Z0-9]{7}","Houari9"));
		System.out.println(Pattern.matches("[a-zA-Z0-9]{1,}","Houari9"));
		System.out.println(Pattern.matches("[a-zA-Z0-9]{1,8}","Houari1"));

	}

}
