package com.houarizegai.javafxdemo.ui;

import javafx.application.Application;
import javafx.collections.ObservableList; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 
import javafx.scene.text.TextAlignment; 
import javafx.scene.text.TextFlow; 
import javafx.stage.Stage; 
         
public class TextFlowDemo extends Application {
   @Override 
   public void start(Stage stage) {                     
      //Creating text objects  
      Text text1 = new Text("Welcome to Tutorialspoint "); 
      
      //Setting font to the text 
      text1.setFont(new Font(15)); 
      
      //Setting color to the text  
      text1.setFill(Color.DARKSLATEBLUE); 
       
      Text text2 = new Text("We provide free tutorials for readers in various technologies  "); 
      
      //Setting font to the text 
      text2.setFont(new Font(15)); 
      
      //Setting color to the text 
      text2.setFill(Color.DARKGOLDENROD); 
      Text text3 = new Text("\n Recently we started free video tutorials too "); 
      
      //Setting font to the text 
      text3.setFont(new Font(15)); 
      
      //Setting color to the text 
      text3.setFill(Color.DARKGRAY); 
       
      Text text4 = new Text("We believe in easy learning"); 
      
      //Setting font to the text 
      text4.setFont(new Font(15)); 
      text4.setFill(Color.MEDIUMVIOLETRED); 
       
      //Creating the text flow plane 
      TextFlow textFlowPane = new TextFlow(); 
       
      //Setting the line spacing between the text objects 
      textFlowPane.setTextAlignment(TextAlignment.JUSTIFY); 
       
      //Setting the width  
      textFlowPane.setPrefSize(600, 300); 
       
      //Setting the line spacing  
      textFlowPane.setLineSpacing(5.0); 
       
      //Retrieving the observable list of the TextFlow Pane 
      ObservableList list = textFlowPane.getChildren(); 
      
      //Adding cylinder to the pane  
      list.addAll(text1, text2, text3, text4);        
         
      //Creating a scene object 
      Scene scene = new Scene(textFlowPane);  
      
      //Setting title to the Stage 
      stage.setTitle("text Flow Pane Example");
      
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show();         
   } 
   public static void main(String args[]){ 
      launch(args); 
   } 
}