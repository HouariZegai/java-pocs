package com.houarizegai.javafxdemo.animation;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        
        Rectangle rec = new Rectangle(100, 100, 150, 150);
        
        FadeTransition ft = new FadeTransition(Duration.millis(3000), rec); // Duration Is The Time to do it
        ft.setCycleCount(FadeTransition.INDEFINITE); // Infinity Animation (Don't Stop)
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setAutoReverse(true);
        ft.play();
        
        group.getChildren().add(rec);
        
        Scene scene = new Scene(group, 400, 400);
        
        primaryStage.setTitle("Fill Transition !");
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
