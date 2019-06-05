package com.houarizegai.javase.regex;

import java.util.regex.Pattern;

public class CharQualifies {
	public static void main(String[] args) {
		
		System.out.println("\nChar Quantifies : ");
		/*
			 X? 	: Number Of : X <= 1
			 X+ 	: Number Of : 1 <= X
			 X* 	: Number Of : 0 <= X
			 X{n} 	: Number Of : X = n
			 X{n,} 	: Number Of : n <= X
			 X{n,m} : Number Of : n <= X <= m
                */
                
		System.out.println("X? : "+Pattern.matches("[abc]?", "a"));
		System.out.println("X* : "+Pattern.matches("[abc]*", "abb"));
		System.out.println("X+ : "+Pattern.matches("[abc]+", "abbr"));
		System.out.println("X{1} : "+Pattern.matches("[h]{2}", "hh"));
		System.out.println("X{1} : "+Pattern.matches("[h]{2,}", "hhh"));
	}
}