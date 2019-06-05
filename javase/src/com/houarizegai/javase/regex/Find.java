package com.houarizegai.javase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find {

	public static void main(String[] args) {
		String pattern;
		String name;
		Pattern pat;
		Matcher matcher;
		
		pattern = "My";
		name = "My Name Is Houari My Zegai";
		pat = Pattern.compile(pattern);
		matcher = pat.matcher(name);
		while(matcher.find()){
			System.out.println("Find ! "+matcher.group()+" At : "+matcher.start());	
		}
		
		pattern = "\\s";
		pat = Pattern.compile(pattern);
		matcher = pat.matcher(name);

		int i=0;
		while(matcher.find())
			i++;
		
		System.out.println("Number Of Space Is : "+i);
		
		System.out.println("\n------------");
		
		name = "My Name Is : Houari houari gouari And jouari";
		pattern = ".ouari?";
		pat = Pattern.compile(pattern);
		matcher = pat.matcher(name);
		System.out.println("Before : "+name);
		
		name = matcher.replaceAll("Houari");
		System.out.println("After : "+name);
				
	}

}
