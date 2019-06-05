package com.houarizegai.swingdemo.ui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class SliderDemo extends JFrame{

	JSlider slider;
	
	SliderDemo(){
		slider = new JSlider(JSlider.HORIZONTAL,0,100,50); // Min Length | Max Length | Default Value
		slider.setMinorTickSpacing(10);// Distance Between Flesh
		slider.setMajorTickSpacing(20); // Distance Between Numbers
		
		slider.setPaintTicks(true); //Show Flesh ������ ��� ������
		slider.setPaintLabels(true); // Show Numbers 
		
		JPanel panel = new JPanel();
		panel.add(slider);

		add(panel);
		//setSize(500,500);
		//setBounds(300, 300, 500, 500);
		pack(); // Length Of Frame Default => sadipon la taille des Elements
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		SliderDemo f = new SliderDemo();
		
	}

}
