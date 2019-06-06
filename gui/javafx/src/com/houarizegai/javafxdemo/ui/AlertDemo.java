package com.houarizegai.javafxdemo.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AlertDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("First Message");
        alert.setHeaderText("About Me");
        alert.setContentText("My Name is :\nHouari ZEGAI");
        /* The Position of the Alert */
        alert.setX(250);
        alert.setY(250);
        
        /* add Button to this alert */
        alert.getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.NEXT, ButtonType.OK, ButtonType.PREVIOUS);
        
        /* Event: if close dialog do this */
        alert.setOnCloseRequest(e -> {
            ButtonType result = alert.getResult();
            if (result == ButtonType.NO)
                System.out.println("You Press: " + result.getText());
            else if (result == ButtonType.CANCEL)
                System.out.println("Cancel");
            else
               System.out.println("Other"); 
        });
        
        alert.setOnHidden(event -> {
            System.out.println("You hide the window");
        });
        
        alert.setOnShown(event -> { // in the first showing
            Scene scene = new Scene(root, 300, 250);
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        
        //alert.show();
        alert.showAndWait(); // show alert dialog and stop execution the rest of line until presse ok or close alert

//        Scene scene = new Scene(root, 300, 250);
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
