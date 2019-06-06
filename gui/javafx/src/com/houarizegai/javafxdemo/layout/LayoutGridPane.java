package com.houarizegai.javafxdemo.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LayoutGridPane extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane gp = new GridPane();
        
        gp.setHgap(10); // Margin Between Nodes Horizontal
        gp.setVgap(10); // Margin Between Nodes Vertical
        
        
        Label l1 = new Label("Welcome");
        TextField user = new TextField("123");
        
        gp.add(l1, 0, 0);
        gp.add(user, 1, 0);
        gp.add(new Button("Button"), 1, 1);
        
        Scene scene = new Scene(gp, 300, 250);
        
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
