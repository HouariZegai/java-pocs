package com.houarizegai.javafxdemo.transformation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class RotationDemo extends Application {
    int i = 1;
    @Override
    public void start(Stage primaryStage) {
        Group g = new Group();
        
        Button btn = new Button("Translation");
        btn.setLayoutX(100);
        btn.setLayoutY(100);
        
        Rotate r = new Rotate();
        r.setPivotX(100); // تحديد التقطة التي يدور حولها
        r.setPivotY(50); // تحدبد نصف قطر الدوران الذي تدور حوله
        
        btn.setOnAction(e -> {
            i-=10;
            r.setAngle(i);
        });
        
        btn.getTransforms().add(r);
        
        /* Start Other Method */
        
        btn.setRotate(360);
        
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
