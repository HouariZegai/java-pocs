package com.houarizegai.javase.regex;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRegular {


	public static void main(String[] args) {
		
		File dir = new File("C:/Users/HouariZegai/Desktop/file"); 
		int count = 0;
		File[] file = dir.listFiles();
		
		System.out.println("My File : ");
		for(File f: file){
			System.out.println(f.getName());
			count++;
		}
		System.out.println("\nNumbers Of File Is : "+count);
		
		count = 0;
		Pattern pattern = Pattern.compile(".*.txt");
		for(File f: file){
			Matcher mat = pattern.matcher(f.getName());
			if(mat.matches())
				count++;
		}
		System.out.println("Number Of File With Extension .txt is : "+count);
		
		count = 0;
		pattern = Pattern.compile(".*.png");
		for(File f: file){
			Matcher mat = pattern.matcher(f.getName());
			if(mat.matches())
				count++;
		}
		System.out.println("Number Of File With Extension .png is : "+count);
		
		count = 0;
		pattern = Pattern.compile(".*.rar");
		for(File f: file){
			Matcher mat = pattern.matcher(f.getName());
			if(mat.matches())
				count++;
		}
		System.out.println("Number Of File With Extension .rar is : "+count);
		
		
	}

}
