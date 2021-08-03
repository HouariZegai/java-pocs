package com.houarizegai.javafxdemo.multistage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FirstPage extends Application {
    
    Stage stage1;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Move To Second Page");
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("First Page!");
        primaryStage.setScene(scene);
        primaryStage.show();
        stage1 = primaryStage;
        btn.setOnAction(e -> {
            SecondPage sp = new SecondPage();
            stage1.close(); // Close The First Window
            sp.start(new Stage()); // Change Stage (set Stage)
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
