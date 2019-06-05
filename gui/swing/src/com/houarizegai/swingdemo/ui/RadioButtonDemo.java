package com.houarizegai.swingdemo.ui;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;


public class RadioButtonDemo {

	JFrame frame;
	public RadioButtonDemo() {
		frame = new JFrame("Test Radio Button");
		JRadioButton r1 = new JRadioButton(" Male",true); // checked by default
		JRadioButton r2 = new JRadioButton(" Female");
		r1.setBounds(50, 100, 80, 40); // Position : Width Height | Width height
		r2.setBounds(50, 140, 80, 40);
		ButtonGroup obg = new ButtonGroup(); // pour choisier un seul choix
		obg.add(r1);
		obg.add(r2);
		
		frame.add(r1);
		frame.add(r2);
		
		frame.setSize(300,300);
		frame.setLayout(null);
		frame.setVisible(true); 		
		
	}
        
	public static void main(String [] args){
            new RadioButtonDemo();
        }
}
