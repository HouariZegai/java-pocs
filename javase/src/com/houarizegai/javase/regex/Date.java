package com.houarizegai.javase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {
	public static void main(String[] args){
		String pattern = "^(0*[1-9]|[12][0-9]|3[01])/(0*[1-9]|1[012])/(19|20)\\d\\d$";
		String[] date = {"17/11/1996","05/05/2007","1/1/2010","10/10/","00/09/1996","10/0/1996","31/12/1992"};
		Pattern pat = Pattern.compile(pattern);
		
		for(String d : date){
			Matcher mat = pat.matcher(d);
			System.out.println(d+"\t"+mat.matches());
		}
	}
}
