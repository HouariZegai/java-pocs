package com.houarizegai.javafxdemo.css;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExternalCss extends Application {
    
    private VBox vbox;
    private Button btn, btn1, btn2, btnEffect;
    private Text text, text2, t, txtCl;
    private Label label;
    
    @Override
    public void start(Stage stage) {
        
        vbox = new VBox();
        vbox.setSpacing(10);
        
        text = new Text("Welcome To JavaFx With CSS"); 
        text.setId("idEffect");
        
        t = new Text("Change Text");
        t.setId("text");
        
        label = new Label("welcome welcome welcome welcome welcome welcome welcome welcome welcome welcome");
        
        
        TextField textfield = new TextField("Welcome");
        textfield.setMaxWidth(200);
        
        text2 = new Text("Welcome To JavaFx With CSS");         
        
        btn = new Button("Normal Button");
        btn.setId("i1"); // i make "id" to the element, for editing this element In Css
                
        btn1 = new Button("Start");
        btn1.getStyleClass().add("c1"); // Add Class to this Element
        
        btn2 = new Button("Pause");
        btn2.getStyleClass().addAll("c1", "c2"); // Add Class to this Element
        
        btnEffect = new Button("Button Effect");
        
        vbox.getChildren().addAll(text, text2, t, btn, btn1, btn2, label, textfield);
        
        Scene scene = new Scene(vbox, 800, 600);
        scene.getStylesheets().add("Fx/CSS/style.css"); // Import Style (Css File) to my 
        
        /*
        Note: Id Prioritaire que Class
        Id > Class > Type Element
        */
        
        stage.setTitle("Try Css");
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
