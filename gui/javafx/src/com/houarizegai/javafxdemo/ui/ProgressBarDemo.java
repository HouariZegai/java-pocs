package com.houarizegai.javafxdemo.ui;

import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class ProgressBarDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        ProgressBar pb = new ProgressBar(0); // The Value Of ProgressBar Between 0 and 1
        
        pb.setPrefSize(200, 20);
        
        Button btnAdd = new Button("Add Progress");
        btnAdd.setLayoutY(40);
        
        Button btnCancel = new Button("Cancel");
        btnCancel.setLayoutY(40);
        btnCancel.setLayoutX(100);
        btnCancel.setDisable(true);
        
        btnAdd.setOnAction(e -> {
           pb.setProgress(pb.getProgress() + 0.1);
           if (pb.getProgress() > 0.9) {
               btnAdd.setDisable(true);
               btnCancel.setDisable(false);
           }
        });
        
        btnCancel.setOnAction(e -> {
            pb.setProgress(0);
            btnAdd.setDisable(false);
            btnCancel.setDisable(true);
        });
        
        root.getChildren().addAll(pb, btnAdd, btnCancel);
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
