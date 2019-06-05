package com.houarizegai.swingdemo.practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;



public class ActionButtonRadioButton extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	
	JRadioButton r1 , r2 , r3;
	JButton btn;
	
	ActionButtonRadioButton(){
		r1 = new JRadioButton("Windows");
		r2 = new JRadioButton("Linux");
		r3 = new JRadioButton("Mac OS");
		
		r1.setBounds(110,60,100,50);
		r2.setBounds(110,100,120,50);
		r3.setBounds(110,140,140,50);
		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		
		btn = new JButton("Submit");
		btn.setBounds(100, 200, 90, 40);
		btn.addActionListener(this);

		this.setTitle("Operating System");
		this.add(r1);
		this.add(r2);
		this.add(r3);
		this.add(btn);
		
		this.setSize(400, 400);
		this.setLayout(null);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		 
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(r1.isSelected()){
			JOptionPane.showMessageDialog(this,"You Select Windows !");
		}else
		if(r2.isSelected()){
			JOptionPane.showMessageDialog(this,"You Select Linux !");
		}else
		if(r3.isSelected()){
			JOptionPane.showMessageDialog(this,"You Select Mac OS !");
		}
		
	}

	public static void main(String[] args) {
		new ActionButtonRadioButton(); 
	}
	
}