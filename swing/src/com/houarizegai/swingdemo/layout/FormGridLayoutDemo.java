package com.houarizegai.swingdemo.layout;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormGridLayoutDemo extends JFrame {
    
    JLabel firstName;
    JLabel middleName;
    JLabel lastName;
    
    JTextField firstField;
    JTextField middleField;
    JTextField lastField;
    JPanel panel;
    void start(){
        firstName = new JLabel("FirstName",JLabel.RIGHT);
        middleName = new JLabel("MiddleName",JLabel.RIGHT);
        lastName = new JLabel("LastName",JLabel.RIGHT);
        
        firstField = new JTextField(10);
        middleField = new JTextField(10);
        lastField = new JTextField(10);
        
        firstName.setDisplayedMnemonic('F'); // add line under character 'F'
        middleName.setDisplayedMnemonic('M');
        lastName.setDisplayedMnemonic('L');
        
        firstName.setLabelFor(firstField);
        middleName.setLabelFor(middleField);
        lastName.setLabelFor(lastField);
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(3,2,5,5));
        
        panel.add(firstName);
        panel.add(firstField);
        panel.add(middleName);
        panel.add(middleField);
        panel.add(lastName);
        panel.add(lastField);
        
        this.addWindowFocusListener(null);
        this.setContentPane(panel);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args){
        new FormGridLayoutDemo().start();
    }
}
