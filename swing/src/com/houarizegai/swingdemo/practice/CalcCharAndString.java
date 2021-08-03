package com.houarizegai.swingdemo.practice;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class CalcCharAndString implements ActionListener {

    JFrame frame;
    JButton btn1,btn2;
    JTextArea inputText;
    
    CalcCharAndString(){
        
        inputText = new JTextArea();
        inputText.setBounds(10,10,220,180);
        inputText.setFont(new Font("Tahoma",Font.BOLD,20));
        
        btn1 = new JButton("Character");
        btn2 = new JButton("Word");
        
        btn1.setBounds(10,200,100,30);
        btn2.setBounds(120,200,100,30);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        
        
        frame = new JFrame("Calc Number Of ");
        frame.setBounds(400,170,300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        frame.add(inputText);
        frame.add(btn1);
        frame.add(btn2);
        
        frame.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == btn1){
           JOptionPane.showMessageDialog(btn1, "Numbers Of Caracter IS : "+inputText.getText().length());
       }
       if(e.getSource() == btn2){
           if(inputText.getText().equals("")){
               inputText.setText(" ");
           }               
           String[] s = inputText.getText().split("\\s");
           JOptionPane.showMessageDialog(btn2, "Numbers Of Word IS : "+s.length);
       }
       
    }
    
    
    public static void main(String[] args){
        new CalcCharAndString();
    }
}
