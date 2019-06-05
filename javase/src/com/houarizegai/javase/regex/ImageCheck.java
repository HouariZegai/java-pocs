package com.houarizegai.javase.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ImageCheck {
	
	private static final String PATTERN = "\\S.+\\.(png|jpg|jpeg|gif|bmp)";

	public static boolean valid(final String imageName){
		return Pattern.matches(PATTERN, imageName);
	}
	
	public static void main(String[] args) {
		
		Scanner mScanner = new Scanner(System.in);
		System.out.print("Type Image Name: ");
		System.out.println("\nTyped Name Of Image is: " + (ImageCheck.valid(mScanner.nextLine()) ? "Valid" : "Not valid"));

		mScanner.close();

	}

}
