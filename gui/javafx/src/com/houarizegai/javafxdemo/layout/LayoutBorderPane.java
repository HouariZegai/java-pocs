package com.houarizegai.javafxdemo.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutBorderPane extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane bp = new BorderPane(); // Other Constractor(Center, Top, Right, Bottom, Left)
        
        TextField tf = new TextField();
        bp.setTop(tf);
        
        VBox vb = new VBox(10);
        for (int i = 1; i <= 4; i++)
            vb.getChildren().add(new Button("Button" + i));
        
        bp.setLeft(vb);
        
        Label l1 = new Label("Welcome To BorderPane");
        bp.setCenter(l1);
        
        PasswordField pass = new PasswordField();
        pass.setText("Bottom");
        bp.setBottom(pass);
        
        bp.setRight(new Button("Right"));
                
        Scene scene = new Scene(bp, 300, 250);
        
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
