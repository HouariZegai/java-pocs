package com.houarizegai.swingdemo.layout;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridLayout2Demo extends JFrame {

    JPanel panel;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;

    GridLayout2Demo() {
        this.setTitle("Test GridLayout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        GridLayout g = new GridLayout(1, 3);
        g.setHgap(10);
        g.setVgap(10);
        this.setLayout(g);

        this.add(new JButton("btn1"));

        this.add(new JButton("btn2"));

        this.add(new JButton("btn3"));        

        this.add(new JButton("btn4"));
        
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new GridLayout2Demo();
    }
}
