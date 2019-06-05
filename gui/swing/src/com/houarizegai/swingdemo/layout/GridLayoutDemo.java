package com.houarizegai.swingdemo.layout;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutDemo extends JFrame {
    
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    

    GridLayoutDemo(){

        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        this.setLayout(new GridLayout(3,2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(500,500);

    }
    
    public static void main(String[] args){
        new GridLayoutDemo().setVisible(true);
    }
}
