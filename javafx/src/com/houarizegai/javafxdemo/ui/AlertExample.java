package com.houarizegai.javafxdemo.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlertExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        
        Button btnFacebook = new Button("Facebook");
        Button btnYoutube = new Button("Youtube");
        Button btnTwitter = new Button("Twitter");
        
        btnFacebook.setOnAction(e -> {
            makeAlert(AlertType.INFORMATION, "Facebook", "images/Facebook.png");
        });
        btnYoutube.setOnAction(e -> {
            makeAlert(AlertType.INFORMATION, "Youtube", "images/YouTube.png");
        });
        btnTwitter.setOnAction(e -> {
            makeAlert(AlertType.INFORMATION, "Twitter", "images/Twitter.png");
        });
        
        root.getChildren().addAll(btnFacebook, btnYoutube, btnTwitter);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void makeAlert(AlertType type, String title, String urlImage) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setGraphic(new ImageView("images/" + urlImage));
        alert.showAndWait();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
