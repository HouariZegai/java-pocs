package com.houarizegai.javafxdemo.ui;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ScrollBarDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        
        ScrollBar sbX = new ScrollBar();
        sbX.setMin(0); // By default 0 , you can change this value by anything other value
        sbX.setMax(200); // By default 100 , you can change this value by anything other value
        sbX.setPrefWidth(300);
        
        ScrollBar sbY = new ScrollBar();
        sbY.setPrefHeight(300);
        sbY.setOrientation(Orientation.VERTICAL);
        
        Rectangle rec = new Rectangle(100, 100);
        rec.setLayoutX(20);
        rec.setLayoutY(20);
        
        
        sbX.valueProperty().addListener(e -> {
            rec.setTranslateX(sbX.getValue());
        });
        
        sbY.valueProperty().addListener(e -> {
            rec.setTranslateY(sbY.getValue());
        });
        
        root.getChildren().addAll(sbX, sbY, rec);
        Scene scene = new Scene(root, 400, 400);
        
        primaryStage.setTitle("Scroll Bar");
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
