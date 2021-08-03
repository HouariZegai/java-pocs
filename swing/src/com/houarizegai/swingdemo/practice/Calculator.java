package com.houarizegai.swingdemo.practice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator implements ActionListener{
    
    JFrame frame;
    JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnpoint,btnadd,btnsub,btnmul,btndiv,btnequal,btnc,btnmod;
    JTextField text;
    int x = 0 , y = 0;
    char opt = ' ';
    
    Calculator(){
        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnpoint = new JButton(".");
        btnadd = new JButton("+");
        btnsub = new JButton("-");
        btnmul = new JButton("*");
        btndiv = new JButton("/");
        btnequal = new JButton("=");
        btnc = new JButton("C");
        btnmod = new JButton("%");
                
        int row1 = 20;
        int row2 = 90;
        int row3 = 150;
        int row4 = 210;
        int row5 = 270;
        int row6 = 330;
        
        int col1 = 20;
        int col2 = 80;
        int col3 = 140;
        int col4 = 200;
        
        
        text = new JTextField(); 
        text.setBounds(col1, row1, 230, 60);
        text.setFont(new Font("arial",Font.BOLD,26));
        text.setEnabled(false);
        btnc.setBounds(col1,row2,50,50);
        btnmod.setBounds(col3,row2,50,50);
        btndiv.setBounds(col4,row2,50,50);
        
        btn7.setBounds(col1,row3,50,50);
        btn8.setBounds(col2,row3,50,50);
        btn9.setBounds(col3,row3,50,50);
        btnmul.setBounds(col4,row3,50,50);
        
        btn4.setBounds(col1,row4,50,50);
        btn5.setBounds(col2,row4,50,50);
        btn6.setBounds(col3,row4,50,50);
        btnsub.setBounds(col4,row4,50,50);
        
        btn1.setBounds(col1,row5,50,50);
        btn2.setBounds(col2,row5,50,50);
        btn3.setBounds(col3,row5,50,50);
        btnadd.setBounds(col4,row5,50,50);
        
        btn0.setBounds(col1,row6,50,50);
        btnpoint.setBounds(col2,row6,50,50);
        btnequal.setBounds(col3,row6,110,50);
        
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn0.addActionListener(this);
        btnc.addActionListener(this);
        btnadd.addActionListener(this);
        btnsub.addActionListener(this);
        btnmul.addActionListener(this);
        btndiv.addActionListener(this);
        btnpoint.addActionListener(this);
        btnequal.addActionListener(this);
        btnmod.addActionListener(this);
        
        
        
        frame = new JFrame();
                
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);
        frame.add(btn7);
        frame.add(btn8);
        frame.add(btn9);
        frame.add(btn0);
        frame.add(btnadd);
        frame.add(btnsub);
        frame.add(btnmul);
        frame.add(btndiv);
        frame.add(btnequal);
        frame.add(btnpoint);
        frame.add(text);
        frame.add(btnc);
        frame.add(btnmod);
        
        frame.setBackground(Color.white);
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        
        frame.setBounds(450,200,280,440);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    
    public static void main(String[] args){
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            text.setText(text.getText()+"1");
        }else if (e.getSource() == btn2) {
            text.setText(text.getText()+"2");
        }else if (e.getSource() == btn3) {
            text.setText(text.getText()+"3");
        } else if (e.getSource() == btn4){
            text.setText(text.getText()+"4");
        } else if (e.getSource() == btn5){
            text.setText(text.getText()+"5");
        } else if (e.getSource() == btn6) {
            text.setText(text.getText()+"6");
        } else if (e.getSource() == btn7) {
            text.setText(text.getText()+"7");
        } else if(e.getSource() == btn8) {
            text.setText(text.getText()+"8");
        } else if (e.getSource() == btn9) {
            text.setText(text.getText()+"9");
        } else if (e.getSource() == btn0) {
            text.setText(text.getText()+"0");
        } else if (e.getSource() == btnpoint) {
            text.setText(text.getText() + ".");
        } else if (e.getSource() == btnc) {
            text.setText("");
            x = y = 0;
            opt = ' ';
        } else if (e.getSource() == btnadd) {
            if (x == 0) {
                x = Integer.parseInt(text.getText());
            } else if (y == 0) {
                y = Integer.parseInt(text.getText());
                opt = '+';
            } else {
                int result = calc(x, y, opt);
                text.setText(String.valueOf( result ));
                x = result;
                y = 0;
                opt = '+';
            }
        } else if (e.getSource() == btnsub) {
            if (x == 0) {
                x = Integer.parseInt(text.getText());
            } else if (y == 0) {
                y = Integer.parseInt(text.getText());
                opt = '-';
            } else {
                text.setText(String.valueOf( calc(x, y, opt) ));
                x += y;
                y = 0;
                opt = '-';
            }
        }
        
    }
    
    public int calc(int x, int y, char opt) {
        switch(opt) {
            case '+': return x+y;
            case '-': return x-y;
            case '*': return x*y;
            case '/': return x/y; 
            default: return 0;
        }
    }    
}