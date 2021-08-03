package com.houarizegai.javafxdemo.effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EffectInnerShadow extends Application {
    
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
        /* Make Shadow Inside (Inner) To The Element */
        InnerShadow ds = new InnerShadow(5, Color.GREEN); // Raddius, Color
        ds.setOffsetX(3); // Margin-Right Of the Shadow
        ds.setOffsetY(3); // Margin-Bottom Of The Shadow
        ds.setBlurType(BlurType.THREE_PASS_BOX);
        
        txt.setEffect(ds);
        
        root.getChildren().addAll(t, txt);
        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("Inner Shadow");
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
