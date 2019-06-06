package com.houarizegai.javafxdemo.css;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InternalCss extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        Button btn = new Button("Normal Button");
        Button btn1Css = new Button("Start Css");
        btn1Css.setStyle("-fx-font-size:18px; -fx-font-weight:bold; -fx-background-color:gray");
        Button btn2Css = new Button("Pause Css");
        btn2Css.setStyle("-fx-font-family:'Comic Sans MS'; -fx-font-size:20px; -fx-background-color:#080");
        
        vbox.getChildren().addAll(btn, btn1Css, btn2Css);
        
        Scene scene = new Scene(vbox, 300, 250);
        
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
