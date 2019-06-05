package com.houarizegai.javase.regex;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Email {

	public static void main(String[] args) {
		// Check Mail Validation: 
				System.out.println("\nTest Mail : \n");
				
				ArrayList<String> emails = new ArrayList<>(); 
				emails.add("houarizegai14@gmail.com");
				emails.add("geekhouari@gmail.com");
				emails.add("houari---_zegai14@hotmail.fr");
				emails.add("user@yahoo.fr");
				emails.add("us@sa");
				emails.add("@zeg.com");
				emails.add("zeg.com");
				emails.add(".user@domain.com");
				emails.add("2-er@domain.com");
				emails.add("user@zeg.com");
				emails.add("_zdz__@zeg.uk");				
				
				
				String pattern = "[a-zA-Z_][\\w]*[-]{0,4}[\\w]+@[a-zA-Z0-9]+.[a-zA-Z]{2,6}"; // This Is My Pattern
				Pattern pa = Pattern.compile(pattern);
			    Matcher mat;
				for(String email : emails){
					mat = pa.matcher(email);
					System.out.println(mat.matches()+" : "+email);
				}

	}

}
