package com.houarizegai.swingdemo.ui;
import javax.swing.JFrame;
import javax.swing.JProgressBar;


public class ProgressBarDemo extends JFrame {
	
	JProgressBar jprogress;
	int i = 0;
	int num = 0;
	
	ProgressBarDemo(){
		jprogress = new JProgressBar(0,100);
		jprogress.setBounds(10, 80, 400, 30);
		jprogress.setValue(0); // Initial Value In The Progress Bar
		jprogress.setStringPainted(true); // Show Porsentage " % "
		
		add(jprogress);		
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void count(){
		while(i<=100){
			jprogress.setValue(i++);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args){
		ProgressBarDemo test = new ProgressBarDemo();
		test.count();
	}
}
