package com.houarizegai.swingdemo.practice.draw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel{
    @Override
    public void paintComponent (Graphics g) {
        //Vous verrez cette phrase chaque fois que la méthode sera invoquée
        System.out.println("Je suis exécutée !");
        int w = this.getWidth()/4;
        int h = this.getHeight()/4;
        // g.fillOval(w, h, w*2, h*2); // Trace un rond plein en commençant à dessiner sur l'axe x à 80 pixels et sur l'axe y à 80 pixels, et fais en sorte qu'il occupe 100 pixels de large et 100 pixels de haut
        // g.drawOval(10, 10, 75, 75);
        
        int [] x = {20, 50, 70, 100};
        int [] y = {20, 50, 70, 20};
        g.drawPolygon(x, y, 4);
        
        g.setFont(new Font("Comic Sans MS", Font.ITALIC, 33));
        g.setColor(Color.BLUE);
        g.drawString("Hello This String Drawed By Graphics", 20, 40);
        this.setVisible(true);
    }
}
