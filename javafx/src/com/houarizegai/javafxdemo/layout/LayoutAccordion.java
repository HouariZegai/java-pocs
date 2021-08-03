package com.houarizegai.javafxdemo.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class LayoutAccordion extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Accordion ac = new Accordion();
        
        TitledPane tp1 = new TitledPane("Button", new Button("Btn1")); 
        TitledPane tp2 = new TitledPane("Button2", new Button("Btn2"));        
        TitledPane tp3 = new TitledPane("Button3", new Button("Btn3"));
        
        
        ac.getPanes().addAll(tp1, tp2, tp3);
        
        Scene scene = new Scene(ac, 300, 250);
        
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
