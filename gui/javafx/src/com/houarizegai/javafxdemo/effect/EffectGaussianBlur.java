package com.houarizegai.javafxdemo.effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EffectGaussianBlur extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        ImageView img = new ImageView("images/steve.png");
        Text txt = new Text("Houari ZEGAI");
        txt.setX(50);
        txt.setY(150);
        txt.setFont(Font.font("Arial Black", FontWeight.BOLD, 34));
        
        GaussianBlur gb = new GaussianBlur(); // Add ضباب  Like Captcha
        gb.setRadius(13); // نسبة التضبيب
        txt.setEffect(gb);
        
        root.getChildren().addAll(txt);
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
