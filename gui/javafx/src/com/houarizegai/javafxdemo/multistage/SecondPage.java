package com.houarizegai.javafxdemo.multistage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SecondPage extends Application {

    Stage stage;
            
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Move To the First Page");
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Second Page!");
        primaryStage.setScene(scene);
        primaryStage.show();
        stage = primaryStage;
        btn.setOnAction(e -> {
            stage.close();
            FirstPage fp = new FirstPage();
            fp.start(new Stage());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
