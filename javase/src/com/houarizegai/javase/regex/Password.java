package com.houarizegai.javase.regex;

public class Password {

	public static void main(String[] args) {
		// Check Password Input
		System.out.println("\nTest Password: \n");

		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$#%:;!^&])(?=\\S,$).{5-9}";
		String pass = "8mH8@";
		System.out.println(pattern.matches(pass));
	}

}
