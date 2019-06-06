package com.houarizegai.javafxdemo.chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BarChartDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        CategoryAxis x = new CategoryAxis();
        x.setLabel("Name Student");
        
        NumberAxis y = new NumberAxis(0, 100, 5);
        y.setLabel("Avarege Course");
        
        XYChart.Series houari = new XYChart.Series();
        houari.setName("Houari");
        houari.getData().add(new XYChart.Data("Java", 80));
        houari.getData().add(new XYChart.Data("C++", 40));
        houari.getData().add(new XYChart.Data("PHP", 70));
        
        XYChart.Series mohammed = new XYChart.Series();
        mohammed.setName("Mohammed");
        mohammed.getData().add(new XYChart.Data("Java", 70));
        mohammed.getData().add(new XYChart.Data("C++", 90));
        mohammed.getData().add(new XYChart.Data("PHP", 10));
        
        XYChart.Series aek = new XYChart.Series();
        aek.setName("Abdelkader");
        aek.getData().add(new XYChart.Data("Java", 30));
        aek.getData().add(new XYChart.Data("C++", 40));
        aek.getData().add(new XYChart.Data("PHP", 60));
        
        BarChart bc = new BarChart(x, y);
        bc.getData().addAll(houari, mohammed, aek);
        
        root.setCenter(bc);
        Scene scene = new Scene(root, 700, 500);
        primaryStage.setTitle("Bar Chart");
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
