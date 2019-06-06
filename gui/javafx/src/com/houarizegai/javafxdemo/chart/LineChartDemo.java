package com.houarizegai.javafxdemo.chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LineChartDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        CategoryAxis x = new CategoryAxis(); // Element Of X (String Value)
        x.setLabel("Student"); // Name Of Horizontal Line X 
        
        NumberAxis y = new NumberAxis(0, 20, 1); // Min , Max , Length Between Numbers
        y.setLabel("Mark");
        
        LineChart lc = new LineChart(x, y);
        lc.setTitle("Mark Student");
        
        XYChart.Series javaMark = new XYChart.Series();
        javaMark.setName("Java");
        javaMark.getData().add(new XYChart.Data("Houari", 11));
        javaMark.getData().add(new XYChart.Data("Brahim", 16));
        javaMark.getData().add(new XYChart.Data("Abdelkrim", 13));
        javaMark.getData().add(new XYChart.Data("Younes", 14));
        javaMark.getData().add(new XYChart.Data("Sofiane", 13));
        
        XYChart.Series algebraMark = new XYChart.Series();
        algebraMark.setName("Algebra");
        algebraMark.getData().add(new XYChart.Data("Houari", 13));
        algebraMark.getData().add(new XYChart.Data("Brahim", 10));
        algebraMark.getData().add(new XYChart.Data("Abdelkrim", 14));
        algebraMark.getData().add(new XYChart.Data("Younes", 13));
        algebraMark.getData().add(new XYChart.Data("Sofiane", 11));
        
        XYChart.Series analyseMark = new XYChart.Series();
        analyseMark.setName("Analyse");
        analyseMark.getData().add(new XYChart.Data("Houari", 15));
        analyseMark.getData().add(new XYChart.Data("Brahim", 6));
        analyseMark.getData().add(new XYChart.Data("Abdelkrim", 16));
        analyseMark.getData().add(new XYChart.Data("Younes", 17));
        analyseMark.getData().add(new XYChart.Data("Sofiane", 8));
        
        lc.getData().addAll(javaMark, algebraMark, analyseMark);
        
        root.setCenter(lc);
        Scene scene = new Scene(root, 700, 500);
        primaryStage.setTitle("Line Chart");
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
