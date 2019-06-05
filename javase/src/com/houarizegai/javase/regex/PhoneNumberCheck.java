package com.houarizegai.javase.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberCheck {
	public static void main(String[] args){
		// Phone Format : yxx-xxx-xxxx AND y <> 0
		String pattern = "[1-9]\\d{2}-\\d{3}-\\d{4}";
		Pattern pat = Pattern.compile(pattern);
		
		Scanner mScanner = new Scanner(System.in);
		System.out.print("Type Phone Number: ");
		String num = mScanner.nextLine();
		
		Matcher mat = pat.matcher(num);

		System.out.println(mat.matches()? "Valid !" : "Invalid !");

		mScanner.close();
	}
}
