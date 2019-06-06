package com.houarizegai.javafxdemo.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LayoutTitledPane extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane p = new Pane();
        
        TitledPane tp = new TitledPane();
        tp.setText("Button");
        tp.setContent(new Button("Btn1"));
        tp.setCollapsible(true); // if i Make "False" : Disable Hide Element Of The TitledPane
        tp.setAnimated(true); // if i Make "False" : Disable Animation Of The TitledPane 
        
        TitledPane tp2 = new TitledPane();
        tp2.setText("Button2");
        tp2.setContent(new Button("Btn2"));
        tp2.setLayoutX(100);
        
        p.getChildren().addAll(tp, tp2);
        
        Scene scene = new Scene(p, 300, 250);
        
        primaryStage.setTitle("TitledPane - Layout");
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
