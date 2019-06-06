package com.houarizegai.javafxdemo.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ColorPickerDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        ColorPicker cp = new ColorPicker(Color.RED);
        
        Label l = new Label("Welcome to JavaFx this is just test color");
        l.setFont(new Font("Comic Sans MS", 22));
        l.setLayoutY(40);
        
        cp.valueProperty().addListener(event -> {
            l.setTextFill(cp.getValue());
        });
        
        root.getChildren().addAll(cp, l);
                
        Scene scene = new Scene(root, 600, 300);
        
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
