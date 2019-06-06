package com.houarizegai.javafxdemo.animation;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FillTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        
        Rectangle rec = new Rectangle(100, 100, 150, 150);
        
        FillTransition ft = new FillTransition(Duration.millis(1000), rec, Color.RED, Color.BLUE);
        ft.setCycleCount(FillTransition.INDEFINITE); // Infinity Animation (Don't Stop)
        ft.setDelay(Duration.seconds(1)); // Wait 2 Minutes and Play The Animation
        ft.setFromValue(Color.AQUA); // Last Color (In this Example make Aqua & blue because is the 2 last Color)
        ft.play();
        
        group.getChildren().add(rec);
        
        Scene scene = new Scene(group, 300, 250);
        
        primaryStage.setTitle("Fill Transition !");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
