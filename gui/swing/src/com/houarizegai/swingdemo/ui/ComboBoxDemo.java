package com.houarizegai.swingdemo.ui;
import javax.swing.JComboBox;
import javax.swing.JFrame;


public class ComboBoxDemo { // ListDemo Choisir

	JComboBox<String> jcb;
	JFrame frame;
	
	ComboBoxDemo(){
		String[] names = {"Houari","Zegai","Mohamed","Abdelkader"};
		jcb = new JComboBox<String>(names); 
		jcb.setBounds(50, 40, 100, 20);
		
		frame = new JFrame("ComboBoxDemo");
		frame.add(jcb);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ComboBoxDemo();
	}

}
