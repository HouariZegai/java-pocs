package com.houarizegai.javafxdemo.transformation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class TranslationDemo extends Application {
    int i = 0;
    @Override
    public void start(Stage primaryStage) {
        Group g = new Group();
        
        Button btn = new Button("Translation");
        btn.setLayoutX(10);
        btn.setLayoutY(10);
        
        Translate t = new Translate();
        
        btn.setOnAction(e -> {
            i+=10;
            t.setX(i);
            t.setY(i);
        });
        
        btn.getTransforms().add(t);
        
        /* Start Other Method */
        
        btn.setTranslateX(100);
        btn.setTranslateY(100);
        
        /* End Other Method */
        
        g.getChildren().add(btn);
        
        Scene scene = new Scene(g, 600, 350);
        
        primaryStage.setTitle("Translation");
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
