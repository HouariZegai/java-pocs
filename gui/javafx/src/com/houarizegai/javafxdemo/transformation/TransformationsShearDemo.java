package com.houarizegai.javafxdemo.transformation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;

public class TransformationsShearDemo extends Application {
    
    double i = 0.1;
    
    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Rectangle rec = new Rectangle(100, 100, 100, 100);
        
        Shear sh = new Shear();
        
        rec.getTransforms().add(sh);
        rec.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                sh.setX(i); // In7iraf ll x إنحراف من جهة ال 
                sh.setY(i);
                i += 0.1;
            }
        
        });
        
        group.getChildren().add(rec);
        
        Scene scene = new Scene(group, 400, 400);
        
        primaryStage.setTitle("Transformations Shear !");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
