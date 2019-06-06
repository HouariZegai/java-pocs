package com.houarizegai.javafxdemo.effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EffectPerspective extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        Text t = new Text("Before Effect Houari ZEGAI");
        t.setX(20);
        t.setY(250);
        t.setFill(Color.RED);
        t.setFont(Font.font("Arial Black", FontWeight.BOLD, 34));
        
        Text txt = new Text("After Effect Houari ZEGAI");
        txt.setFill(Color.RED);
        txt.setFont(Font.font("Arial Black", FontWeight.BOLD, 34));
        /* منظور ثلاثي الأبعاد 
            3D Model
        */
        PerspectiveTransform rt = new PerspectiveTransform(); // 
        rt.setUlx(10);
        rt.setUly(10);
        
        rt.setUrx(300);
        rt.setUry(40);
        
        rt.setLrx(310);
        rt.setLry(70);
        
        rt.setLlx(10);
        rt.setLly(90);
        
        txt.setEffect(rt);
        
        root.getChildren().addAll(t, txt);
        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("PerspectiveTransform");
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
