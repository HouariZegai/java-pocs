package com.houarizegai.javafxdemo.event;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KeyEventDemo extends Application implements EventHandler<KeyEvent> {
    
    TextField t[] = new TextField[2];
    Label l[] = new Label[2];
    String s[] = {"Key Pressed", "Key Released"};
    
    @Override
    public void start(Stage primaryStage) {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20));
        gp.setHgap(10);
        gp.setVgap(10);
        
        for (int i = 0; i < t.length; i++) {
            gp.add(t[i] = new TextField(), 0, i);
            t[i].setPromptText(s[i]); // Place Holder
            t[i].setFocusTraversable(false);
            gp.add(l[i] = new Label("---"), 1, i);
        }
        
        t[0].setOnKeyPressed(this);
        t[1].setOnKeyReleased(this);
        

        Scene scene = new Scene(gp, 400, 400);
        
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
    public void handle(KeyEvent event) {
        if (event.getEventType() == event.KEY_PRESSED) {
            l[0].setText(t[0].getText().toUpperCase());
        }
        
        if (event.getEventType() == event.KEY_RELEASED) {
            l[1].setText(t[1].getText().toUpperCase());
        }
    }
    
}
