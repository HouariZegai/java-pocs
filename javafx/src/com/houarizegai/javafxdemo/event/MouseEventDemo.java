package com.houarizegai.javafxdemo.event;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MouseEventDemo extends Application implements EventHandler<MouseEvent>{
    
    Button []b = new Button[5];
    Label []l = new Label[5];
    String []s = {"Clicked", "Entered", "Exited", "Pressed", "Released"};
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20));
        
        for (int i = 0; i < b.length; i++) {
            gp.add(b[i] = new Button(s[i]), 0, i);
            gp.add(l[i] = new Label("---"), 1, i);   
        }
        
        b[0].setOnMouseClicked(this);
        b[1].setOnMouseEntered(this);
        b[2].setOnMouseExited(this);
        b[3].setOnMousePressed(this);
        b[4].setOnMouseReleased(this);
        
        Scene scene = new Scene(gp, 300, 400);
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

    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType().equals(event.MOUSE_CLICKED)) {
            l[0].setText("Mouse Clicked!");
        } else if (event.getEventType().equals(event.MOUSE_ENTERED)) {
            l[1].setText("Mouse Entered!");
        } else if (event.getEventType().equals(event.MOUSE_EXITED)) {
            l[2].setText("Mouse Exited!");
        } else if (event.getEventType().equals(event.MOUSE_PRESSED)) {
            l[3].setText("Mouse Pressed!");
        } else if (event.getEventType().equals(event.MOUSE_RELEASED)) {
            l[4].setText("Mouse Released!");
        } 
    }
    
}
