package com.houarizegai.swingdemo.practice;
import java.util.Scanner;

public class Test {
    // Simple Calculator
    public static void main(String[] args){
        int x,y;
        String opt;
                
        Scanner input = new Scanner(System.in);
        
        System.out.print("X= ");
        x = input.nextInt();
        
        do{
            System.out.print("Opt= ");
            opt = input.next();
            
        }while(!opt.equals("+") && !opt.equals("-") && !opt.equals("*") && !opt.equals("/"));
                
        System.out.print("Y= ");
        y = input.nextInt();
        
        switch(opt) {
            case "+": System.out.println(x+" + "+y+" = "+(x+y));
                break;
            case "-": System.out.println(x+" - "+y+" = "+(x-y));
                break;
            case "*": System.out.println(x+" * "+y+" = "+(x*y));
                break;
            case "/": System.out.println(x+" / "+y+" = "+(x/y));
                break;    
        }
        
        
        input.close();
    }
}
