package com.houarizegai.swingdemo.layout;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class BorderLayoutDemo extends JFrame{
    
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    
    BorderLayoutDemo(){
                
        JButton btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
                        
        add(btn1,BorderLayout.NORTH);
        add(btn2,BorderLayout.SOUTH);
        add(btn3,BorderLayout.EAST);
        add(btn4,BorderLayout.WEST);
        add(btn5,BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(500,500);
        
    }
    
    public static void main(String[] args){
        new BorderLayoutDemo().setVisible(true);
    }
}
