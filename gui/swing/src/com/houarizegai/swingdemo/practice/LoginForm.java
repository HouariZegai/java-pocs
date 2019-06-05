package com.houarizegai.swingdemo.practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm implements ActionListener {
 
    JFrame frame;
    JButton button;
    JTextField usernameField;
    JPasswordField passwordField;
    JLabel usernameLabel, passwordLabel;
    
    LoginForm(){
        button = new JButton("Login");
        button.addActionListener(this);
        
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        
        frame = new JFrame("LogIn Form");
        
        usernameLabel.setBounds(10, 0, 100, 30);
        passwordLabel.setBounds(10, 60, 100, 30);
        usernameField.setBounds(150, 0, 150, 30);
        passwordField.setBounds(150, 60, 150, 30);
        button.setBounds(150, 100, 80, 30);
        
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(button);
        frame.setLayout(null);
        frame.setSize(400,400);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args){
        new LoginForm();
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
