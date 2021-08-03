package com.houarizegai.javafxdemo.layout;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LayoutGridPaneLoginForm extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane gp = new GridPane();
        
        gp.setHgap(15); // Margin Between Nodes Horizontal
        gp.setVgap(20); // Margin Between Nodes Vertical
        gp.setPadding(new Insets(20, 0, 0, 20));
        
        
        Label loginLabel = new Label("Login");
        loginLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Label userLabel = new Label("Username");
        TextField userField = new TextField("123");
        Label passLabel = new Label("Password");
        PasswordField passField = new PasswordField();
        passField.setText("1234");
        Button submit = new Button("Submit");
        GridPane.setHalignment(submit, HPos.RIGHT);
        
        gp.add(loginLabel, 0, 0);
        gp.add(userLabel, 0, 1);
        gp.add(userField, 1, 1);
        gp.add(passLabel, 0, 2);
        gp.add(passField, 1, 2);
        gp.add(submit, 1, 3);
        
        
        Scene scene = new Scene(gp, 300, 250);
        
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
