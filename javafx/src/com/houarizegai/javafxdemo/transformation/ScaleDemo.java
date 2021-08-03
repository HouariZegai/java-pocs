package com.houarizegai.javafxdemo.transformation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class ScaleDemo extends Application {
    int i = 1;
    
    @Override
    public void start(Stage primaryStage) {
        Group g = new Group();
        Button btn = new Button("Button");
        btn.setPrefSize(100, 30);
        btn.setLayoutX(100);
        btn.setLayoutY(100);
        
        btn.setScaleX(2); // The Width of Button x2, The Default Value Is 1
        btn.setScaleY(3); // The Width of Button x3
        
        // Other Method
        
        Scale sc = new Scale();
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                i+=1;
                sc.setX(i);
                sc.setY(i);
            }
        });
        
        btn.getTransforms().add(sc);
        g.getChildren().add(btn);
        
        Scene scene = new Scene(g, 300, 300);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}