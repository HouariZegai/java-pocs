package com.houarizegai.javase.regex;

import java.util.regex.Pattern;

public class IP {

	public static void main(String[] args){
		String pattern =  "^(([01]?\\d?\\d)|(2[0-4]\\d)|(25[0-5]))"
						+ "[.](([01]?\\d?\\d)|(2[0-4]\\d)|(25[0-5]))"
						+ "[.](([01]?\\d?\\d)|(2[0-4]\\d)|(25[0-5]))";
		
		String[] ips ={",92.168.1.2","255.255.255.255","15.12.2.0.","0.0.0.1","123.10.10","999.10.45.10","1.0.1","10.10.10.270","100,10.5.20"}; 

		for(String ip : ips){
			System.out.println(ip+" \t"+(Pattern.matches(pattern,ip)? "Ok":"Not IP"));
		}
		/*
		pattern = "\\d+";
		pat = Pattern.compile(pattern);
		mat = pat.matcher(ips[0]);
	
		
		while(mat.find()){
			System.out.print(mat.group()+" "); // For Copy The IP To 4 Part
		}*/

	}
}