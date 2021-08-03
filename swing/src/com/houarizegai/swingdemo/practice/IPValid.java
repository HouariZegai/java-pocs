package com.houarizegai.swingdemo.practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IPValid extends JFrame implements ActionListener {

    JTextField input;
    JLabel label;
    JButton button;
    
    IPValid(){
        label = new JLabel("Type WebSite : ");
        label.setBounds(20,20,100,40);
        
        input = new JTextField();
        input.setBounds(20, 70, 200, 30);
        
        button = new JButton("Submit");
        button.setBounds(20,120,100,40);
        button.addActionListener(this);
        
        this.setTitle("Check IP");
        this.setSize(400, 400);    
        
        this.add(label);
        this.add(input);
        this.add(button);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
        String url = input.getText();
        try {
            InetAddress i = InetAddress.getByName(url);
            String ip = i.getHostAddress();
            JOptionPane.showMessageDialog(this,ip);
            
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(this,ex.toString());
        }
        
    }
    
    public static void main(String[] args){
        new IPValid().setVisible(true);
    }
}
