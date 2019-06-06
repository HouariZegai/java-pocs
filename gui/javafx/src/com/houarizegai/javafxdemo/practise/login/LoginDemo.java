package com.houarizegai.javafxdemo.practise.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        Label loginLabel = new Label("Login Form");
        loginLabel.setLayoutX(10);
        loginLabel.setLayoutY(10);
        loginLabel.setId("loginLabel");
        
        Label usernameLabel = new Label("Username:");
        usernameLabel.setLayoutX(20);
        usernameLabel.setLayoutY(80);
        
        TextField usernameField = new TextField();
        usernameField.setLayoutX(150);
        usernameField.setLayoutY(80);
        
        Label passwordLabel = new Label("Password:");
        passwordLabel.setLayoutX(20);
        passwordLabel.setLayoutY(140);
        
        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(150);
        passwordField.setLayoutY(140);
        
        Button btnSubmit = new Button("Submit");
        btnSubmit.setLayoutX(325);
        btnSubmit.setLayoutY(205);
        
        btnSubmit.setOnAction(e -> {
            System.out.println("Username: " + usernameField.getText() + "\n" + "Password: " + passwordField.getText());
        });
        
        root.getChildren().addAll(loginLabel, usernameLabel, usernameField, passwordLabel, passwordField, btnSubmit);
        Scene scene = new Scene(root, 450, 300);
        scene.getStylesheets().add("Fx/Practise/Login/style.css");
        
        primaryStage.setTitle("Login");
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
