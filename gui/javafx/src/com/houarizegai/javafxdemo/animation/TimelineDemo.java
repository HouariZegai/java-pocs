package com.houarizegai.javafxdemo.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimelineDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Button btn = new Button("Test Button !");
        btn.setLayoutX(50);
        btn.setLayoutY(100);
        group.getChildren().add(btn);
        
        /*
            Create Presonal Animation
        */
        
        Timeline t = new Timeline();
        
        KeyValue k1v1 = new KeyValue(btn.scaleXProperty(), 3); // Animation Width Of Button x 3
        KeyValue k1v2 = new KeyValue(btn.scaleYProperty(), 3);
        KeyFrame k1 = new KeyFrame(Duration.seconds(2),k1v1, k1v2);
        
        KeyValue k2v1 = new KeyValue(btn.translateXProperty(), 100); // Animation Move Button,
        KeyValue k2v2 = new KeyValue(btn.translateYProperty(), 200);
        KeyValue k2v3 = new KeyValue(btn.borderProperty(), new Border(new BorderStroke(Color.RED, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        KeyFrame k2 = new KeyFrame(Duration.seconds(3),k2v1, k2v2, k2v3);
        
        KeyValue k3v1 = new KeyValue(btn.rotateProperty(), 360); // Animation Rotation Button,
        KeyValue k3v2 = new KeyValue(btn.backgroundProperty(), new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY))); // Animation  Button,
        KeyValue k3v3 = new KeyValue(btn.effectProperty(), new DropShadow(2, Color.BLUE));
        KeyFrame k3 = new KeyFrame(Duration.seconds(5),k3v1, k3v2, k3v3);
        
        t.getKeyFrames().addAll(k1, k2, k3);
        t.play();
        
        Scene scene = new Scene(group, 700, 700);
        
        primaryStage.setTitle("Timeline!");
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
