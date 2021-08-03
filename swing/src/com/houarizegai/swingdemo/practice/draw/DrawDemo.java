package com.houarizegai.swingdemo.practice.draw;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawDemo extends JFrame {
    
    JPanel panel;
    Panneau pan;
    
    DrawDemo() {
    
        this.setTitle("My First DrawDemo !"); // Le Title de fenètre
        this.setSize(400,400); // la Taille de Fenètre
        this.setLocation(400,100); // Position de la Fenètre dans ma Ecran
        this.setResizable(true); // Déactiver la Modification sur la Taille de ma Fenètre
        this.setAlwaysOnTop(true); // Garder la Fenètre toujour en Premier Plan
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Stop Processus Lorque Click sur la botton Rouge
        this.setVisible(true); // Affiche La fenètre
        
        panel = new JPanel();
        panel.setVisible(true);
        panel.setBackground(Color.GREEN);
        pan = new Panneau();
        this.setContentPane(pan);
        
        go();
    }
    private void go(){
        for(int i = -50; i < panel.getWidth(); i++){
            int x = pan.getX(),
                y = pan.getY();
            x++;
            y++;
            pan.setAlignmentX(x);
            pan.setAlignmentY(y);
            pan.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main (String [] args) {
        new DrawDemo();
    }
}
