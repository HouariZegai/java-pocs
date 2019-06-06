package com.houarizegai.javafxdemo.effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class EffectBlendMode extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        ImageView img = new ImageView("images/steve.png");
        
        Rectangle r1 = new Rectangle(20, 100, 100, 100);
        r1.setFill(Color.BLACK);
        Rectangle r2 = new Rectangle(130, 100, 100, 100);
        r2.setFill(Color.GRAY);
        Rectangle r3 = new Rectangle(240, 100, 100, 100);
        r3.setFill(Color.WHITE);
        
        /* BlendMode.
            Show Dark Color: 
                DARKEN (إظهار الجزد الغامق من الصورة)
                MULTIPLY (Show Background)
                COLOR_BURN (حرق الصورة)
            Show Lighting Color : اللون المضيء
                LIGHTEN
                SCREEN (Show More Lighting Color)
                COLOR_DODGE (حرق  - لون مخادع)   
            Merge Layers :
                OVERLAY (More Marge)
                SOFT_LIGHT (Moin Merge)
                HARD_LIGHT (Force Color - 9owat Color Howa Mosaytir)
                DIFFERENCE (Show Different Color)
                EXCLUSION 
                RED (Merge Color RED & Color Of Element)
                GREEN (Merge Color GREEN & Color Of Element)
                BLUE (Merge Color BLUE & Color Of Element)
                ADD (Merge Layers)
            
        */
        
        r1.setBlendMode(BlendMode.ADD);
        r2.setBlendMode(BlendMode.ADD);
        r3.setBlendMode(BlendMode.ADD);
        
        root.getChildren().addAll(img, r1, r2, r3);
        Scene scene = new Scene(root, 400, 400);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
