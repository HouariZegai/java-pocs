package com.houarizegai.swingdemo.ui;

import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBoxDemo {

    JFrame frame;
    JCheckBox cb1,cb2,cb3,cb4;
    
    CheckBoxDemo(){
        cb1 = new JCheckBox("HP");
        cb2 = new JCheckBox("DELL");
        cb3 = new JCheckBox("TOSHIBA");
        cb4 = new JCheckBox("ACER");
        
        frame = new JFrame("Choose PC");
        
        frame.add(cb1);
        frame.add(cb2);
        frame.add(cb3);
        frame.add(cb4);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        
        
    }
    public static void main(String[] args){
        new CheckBoxDemo();
    }
}
