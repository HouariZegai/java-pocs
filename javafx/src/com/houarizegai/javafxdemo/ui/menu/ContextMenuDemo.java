package com.houarizegai.javafxdemo.ui.menu;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.NativeArray;

public class ContextMenuDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        
        TextField text = new TextField("Welcome To This TextField Test!");
        text.setPrefSize(300, 50);
        
        ContextMenu cm = new ContextMenu();
        MenuItem i1 = new MenuItem("Copy");
        MenuItem i2 = new MenuItem("Cut");
        MenuItem i3 = new MenuItem("Past");
        cm.getItems().addAll(i1, i2, i3);
        
        text.setContextMenu(cm); // change the default context menu by the new context menu
        
        text.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.SECONDARY) { // Check If I Click To The Right Button
                    cm.show(text, event.getX(), event.getY()); // Show The Context Menu In The Element text , in X, Y (position of the Action)
                }
            }
        });
        
        root.getChildren().add(text);
        
        Scene scene = new Scene(root, 700, 500);
        
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
