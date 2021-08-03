package com.houarizegai.javafxdemo.transformation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ScaleExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Group g  = new Group();
        
        ImageView img = new ImageView("images/image.jpg");
        img.setFitWidth(200);
        img.setFitHeight(200);
        img.setLayoutX(100);
        img.setLayoutY(100);
        
        g.getChildren().add(img);
        
        img.setOnMouseEntered(e -> {
            img.setScaleX(1.2);
            img.setScaleY(1.2);
        });
        
        img.setOnMouseExited(e -> {
            img.setScaleX(1);
            img.setScaleY(1);
        });
        
        Scene scene = new Scene(g, 500, 500);
        
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
