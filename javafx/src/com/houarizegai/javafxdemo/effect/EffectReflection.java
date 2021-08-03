package com.houarizegai.javafxdemo.effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EffectReflection extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        Text t = new Text("Before Effect Houari ZEGAI");
        t.setX(20);
        t.setY(50);
        t.setFill(Color.RED);
        t.setFont(Font.font("Arial Black", FontWeight.BOLD, 34));
        
        Text txt = new Text("After Effect Houari ZEGAI");
        txt.setX(20);
        txt.setY(200);
        txt.setFill(Color.RED);
        txt.setFont(Font.font("Arial Black", FontWeight.BOLD, 34));
        /* Make Shadow To The Element */
        Reflection r = new Reflection();
        r.setTopOffset(50); // Space Between Text & Reflection
        r.setFraction(1); // Show Or Hide Reflection (All Or ..)
        r.setTopOpacity(0.5); // الشفافية
        r.setBottomOpacity(0.5);
        
        txt.setEffect(r);
        
        root.getChildren().addAll(t, txt);
        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("Reflection");
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
