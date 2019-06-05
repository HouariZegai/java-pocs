package com.houarizegai.swingdemo.layout;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo extends JFrame {
    
    JButton btn[] = new JButton[6];

    public FlowLayoutDemo(){
        for(int i=0;i<6;i++){
            btn[i] = new JButton("btn"+i);
        }
    }

    void start(){
               
        this.setTitle("Flow Layout");
        
       for(int i=0;i<6;i++){
           this.add(btn[i]);
       }
       
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setLayout(new FlowLayout(FlowLayout.LEFT));
       /*
        FlowLayout.
            CENTER      ->  centre
            LEFT        ->  gauche
            RIGHT       ->  droit
            LEADING     ->  début
            TRAILING    ->  fin 
       */
       this.setSize(500,300);
       this.setVisible(true);        
    }
    
    public static void main(String[] args){
        new FlowLayoutDemo().start();
        
    }
}
