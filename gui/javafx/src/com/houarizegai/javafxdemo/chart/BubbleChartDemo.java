package com.houarizegai.javafxdemo.chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BubbleChartDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        NumberAxis x = new NumberAxis(0, 30, 5);
        x.setLabel("Weeks");
        
        NumberAxis y = new NumberAxis(0, 80, 10); // Min, Max, Length
        y.setLabel("Product Budget");
        y.setTickLabelFormatter(new NumberAxis.DefaultFormatter(y, "$", null)); // Add Prefex , Suffix 
        
        BubbleChart bc = new BubbleChart(x, y);
        
        XYChart.Series p1 = new XYChart.Series();
        p1.getData().add(new XYChart.Data(5, 40, 3)); // X, Y, Radius
        p1.getData().add(new XYChart.Data(6, 50));
        
        XYChart.Series p2 = new XYChart.Series();
        p2.getData().add(new XYChart.Data(1, 40));
        p2.getData().add(new XYChart.Data(2, 50));
        
        bc.getData().addAll(p1, p2);
        
        root.setCenter(bc);
        Scene scene = new Scene(root, 700, 500);
        primaryStage.setTitle("Budget Monitoring");
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
