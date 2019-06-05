package com.houarizegai.swingdemo.ui;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class TextAreaDemo {

	JTextArea area;
	JFrame frame;
	
	TextAreaDemo(){
		area = new JTextArea(200,200);
		area.setBounds(15, 50, 200, 200); 
		area.setBackground(Color.darkGray); // Background Color
		area.setForeground(Color.ORANGE); // Text Color
		
		Font font = new Font("Arial",Font.BOLD,18);
		area.setFont(font);
		
		frame = new JFrame();
		frame.setSize(500,500);
		frame.add(area);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args){
		new TextAreaDemo();
	}
}
