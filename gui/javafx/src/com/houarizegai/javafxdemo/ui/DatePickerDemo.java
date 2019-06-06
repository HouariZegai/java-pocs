package com.houarizegai.javafxdemo.ui;

import java.time.LocalDate;
import java.time.Month;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DatePickerDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        DatePicker dp = new DatePicker(LocalDate.of(1996, Month.NOVEMBER, 17)); // Date Chooser
        /*
            LocalDate.now(); return the date of this day
            LocalDate.of(Year, Month(int or Enum type), Day); return the date of this day
        */
        
        Label l = new Label("Date: ");
        l.setLayoutY(40);
        
        dp.valueProperty().addListener(event -> {
            l.setText("Year: " + dp.getValue().getYear()
                    + "\nMonth: " + dp.getValue().getMonth().toString()
                    + "\nDay: " + dp.getValue().getDayOfMonth() + " " + dp.getValue().getDayOfWeek().toString());
        });
        
        root.getChildren().addAll(dp, l);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
