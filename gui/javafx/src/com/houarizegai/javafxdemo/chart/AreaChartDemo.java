package com.houarizegai.javafxdemo.chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AreaChartDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        CategoryAxis x = new CategoryAxis();
        x.setLabel("Weeks");
        
        NumberAxis y = new NumberAxis(-50, 100, 10);
        y.setLabel("Avarege Health");
        
        AreaChart ac = new AreaChart(x, y);
        ac.setTitle("Health Status");
        
        XYChart.Series p1 = new XYChart.Series();
        p1.setName("Houari");
        p1.getData().add(new XYChart.Data("First Week", -10));
        p1.getData().add(new XYChart.Data("Second Week", 10));
        p1.getData().add(new XYChart.Data("Third Week", 30));
        p1.getData().add(new XYChart.Data("Fourth Week", 60));
        
        XYChart.Series p2 = new XYChart.Series();
        p2.setName("Ali");
        p2.getData().add(new XYChart.Data("First Week", 20));
        p2.getData().add(new XYChart.Data("Second Week", 10));
        p2.getData().add(new XYChart.Data("Third Week", 40));
        p2.getData().add(new XYChart.Data("Fourth Week", 30));
        
        ac.getData().addAll(p1, p2);
        root.setCenter(ac);
        Scene scene = new Scene(root, 700, 500);
        primaryStage.setTitle("Area Chart");
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
