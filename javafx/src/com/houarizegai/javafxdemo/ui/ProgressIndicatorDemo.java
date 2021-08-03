package com.houarizegai.javafxdemo.ui;

import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

public class ProgressIndicatorDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        ProgressIndicator pi = new ProgressIndicator(0);
        
        pi.setPrefSize(100, 100);
        
        Button btnAdd = new Button("Add Progress");
        btnAdd.setLayoutY(100);
        
        Button btnCancel = new Button("Cancel");
        btnCancel.setLayoutY(100);
        btnCancel.setLayoutX(100);
        btnCancel.setDisable(true);
        
        btnAdd.setOnAction(e -> {
           pi.setProgress(pi.getProgress() + 0.05);
           if (pi.getProgress() > 1) {
               btnAdd.setDisable(true);
               btnCancel.setDisable(false);
           }
        });
        
        btnCancel.setOnAction(e -> {
            pi.setProgress(0);
            btnAdd.setDisable(false);
            btnCancel.setDisable(true);
        });
        
        root.getChildren().addAll(pi, btnAdd, btnCancel);
        Scene scene = new Scene(root, 300, 250);
        
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
