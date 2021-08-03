package com.houarizegai.swingdemo.practice;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CalculatorNew extends JFrame {
    
    JButton btnadd,btnsub,btnmul,btndiv,btnequal;
    
    CalculatorNew () {
        
    }
    
    public static void main (String[] args) {
        new CalculatorNew().setVisible(true);
    }
}
