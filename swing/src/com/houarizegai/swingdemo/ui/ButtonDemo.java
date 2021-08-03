package com.houarizegai.swingdemo.ui;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class ButtonDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	ButtonDemo(){
		JButton youtubeButton = new JButton(new ImageIcon(getClass().getResource("/images/Youtube.png")));
		youtubeButton.setBounds(20, 50, 64, 64);
		youtubeButton.setEnabled(true);
				
		JButton facebookButton = new JButton(new ImageIcon(getClass().getResource("/images/Facebook.png")));
		facebookButton.setBounds(100, 50, 64, 64);
		facebookButton.setEnabled(true);

		JButton twitterButton = new JButton(new ImageIcon(getClass().getResource("/images/Twitter.png")));
		twitterButton.setBounds(180, 50, 64, 64);
		twitterButton.setEnabled(true);
		
		this.add(youtubeButton);
		this.add(facebookButton);
		this.add(twitterButton);

		this.setSize(300,300);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ButtonDemo();
	}

}
