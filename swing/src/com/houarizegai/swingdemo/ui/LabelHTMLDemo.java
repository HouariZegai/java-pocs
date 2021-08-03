package com.houarizegai.swingdemo.ui;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

public class LabelHTMLDemo {
    
    JFrame frame;
    JLabel label;
    
    public LabelHTMLDemo(){
       frame = new JFrame("Using HTML"); 
       label =  new JLabel("<html>Houari ZEGAi<br><i><span bgcolor='red'>Tiaret</span> 14000</i><table border=\"2\"><tr><td>First</td><td>Second</td></tr></table></html>");
       
       frame.add(label);
       
       frame.setBounds(200,300,300,300);
       frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       frame.setVisible(true);
       
    }
    
    public static void main(String[] args){
        new LabelHTMLDemo();
    }
}
