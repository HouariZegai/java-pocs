package com.houarizegai.swingdemo.ui;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;


public class ColorChooserDemo extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	
	JFrame frame;
	JButton btn;
	Container con;
	
	ColorChooserDemo(){
		con = getContentPane();
		con.setLayout(new FlowLayout());
			
		btn = new JButton("Modifier Coleur");
		btn.setBounds(100,100,120,30);
		btn.addActionListener(this);
		
		add(btn);
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new ColorChooserDemo();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Color initialColor = Color.GRAY;
		Color color = JColorChooser.showDialog(this, "choose a color", initialColor);
		con.setBackground(color);
	}

}
