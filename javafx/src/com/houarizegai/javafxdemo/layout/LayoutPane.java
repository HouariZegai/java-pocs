package com.houarizegai.javafxdemo.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LayoutPane extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane p = new Pane();
        
        Button b1 = new Button("Button1");
        b1.setLayoutX(10);
                
        Button b2 = new Button("Button2");
        b2.setLayoutX(70);
        b2.setLayoutY(25);
        
        p.getChildren().add(b1);
        p.getChildren().add(b2);
                        
        Scene scene = new Scene(p, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
