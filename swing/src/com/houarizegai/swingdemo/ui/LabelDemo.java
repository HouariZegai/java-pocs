package com.houarizegai.swingdemo.ui;

import javax.swing.*;
import java.awt.*;


public class LabelDemo extends JFrame {

	JLabel label1,label2,label3,label4,label5, label;
	
	LabelDemo(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(400,400);
		
		label1 = new JLabel("Username : ", JLabel.RIGHT);
		label2 = new JLabel("Password : ", JLabel.RIGHT);
		label3 = new JLabel("Confirm Password : ", JLabel.RIGHT);
		label4 = new JLabel("Email : ", JLabel.LEFT);
		label5 = new JLabel("Cell Phone : ", JLabel.CENTER);
		
		label5.setToolTipText("This IS Me !"); // sub title

		// change font of Label
		label = new JLabel("Houari ZEGAI");
		label.setFont(new Font("Arial",Font.ITALIC,18));
		label.setForeground(Color.BLACK);

		getContentPane().add(label1); // Or add(label1);
		getContentPane().add(label2);
		getContentPane().add(label3);
		getContentPane().add(label4);
		getContentPane().add(label5);
		getContentPane().add(label);

		//pack();
		
	}
	
	public static void main(String[] args) {
		new LabelDemo().setVisible(true);
	}

}
