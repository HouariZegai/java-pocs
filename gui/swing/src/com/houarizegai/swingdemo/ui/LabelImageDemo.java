package com.houarizegai.swingdemo.ui;

import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LabelImageDemo {

	JFrame frame;

	LabelImageDemo(){
	    JLabel label = new JLabel(new ImageIcon(getClass().getResource("/images/gmail.png")), SwingConstants.LEFT /*Like "Float" In CSS*/);

		frame = new JFrame("Test Image Icon");
		frame.add(label);

		//frame.setLayout(new FlowLayout());
		frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new LabelImageDemo();
    }

}
