package com.houarizegai.javafxdemo.animation;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TranslateTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();

        Button btn = new Button("Translate Transition !"); //
        TranslateTransition tt = new TranslateTransition(Duration.millis(4000), btn);
        tt.setToX(100); // Change X Position Of The Element
        tt.setToY(100); // Change Y Position Of The Element
        tt.setAutoReverse(true); // Ro7 w Rja3,
        tt.setCycleCount(TranslateTransition.INDEFINITE); // Number of Repeat or INDEFINITE = Repeat This Animation Forever
        tt.play();
        
        group.getChildren().add(btn);
        Scene scene = new Scene(group, 400, 400);
        
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
