package com.houarizegai.javafxdemo.animation;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        
        Rectangle rec = new Rectangle(100, 100, 300, 300);
        rec.setFill(Paint.valueOf("#F00"));
        
        Circle cer = new Circle(500, 300, 150);
        
        Button btn = new Button("Hello Sun !");
        
        PathTransition ft = new PathTransition(Duration.millis(6000), rec, btn); // Duration Is The Time to do it
        ft.setCycleCount(10); // Numner of Animation (number of Cycle)
        ft.setAutoReverse(true);
        ft.play();
        
        PathTransition ft1 = new PathTransition(Duration.millis(6000), cer, btn); // Duration Is The Time to do it
        ft1.setCycleCount(10); // Numner of Animation (number of Cycle)
        ft1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT); // element ydor m3a shape
        ft1.play();
        
        
        group.getChildren().addAll(rec, cer, btn);
        
        Scene scene = new Scene(group, 700, 700);
        
        primaryStage.setTitle("Fill Transition !");
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
