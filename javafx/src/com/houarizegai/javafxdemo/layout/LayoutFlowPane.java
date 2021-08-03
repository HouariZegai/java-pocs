package com.houarizegai.javafxdemo.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LayoutFlowPane extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        FlowPane fp = new FlowPane(20, 5); // 20 : HGap (Margin-right) , 5 : VGap (Margin-bottom)
        
        fp.setHgap(20); // Margin Right
        fp.setVgap(5); // Margin Bottom
        
        for (int i = 0; i < 10; i++) {
            fp.getChildren().add(new Button("Button" + (i + 1)));
        }
        
        Scene scene = new Scene(fp, 300, 250);
        
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
