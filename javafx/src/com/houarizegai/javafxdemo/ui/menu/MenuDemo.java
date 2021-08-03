package com.houarizegai.javafxdemo.ui.menu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuDemo extends Application implements EventHandler<ActionEvent>{
    
    private BorderPane root;
    
    MenuBar menuBar;
    private Menu menuFile,
            menuView,
            menuLanguage,
            menuBackground;
    
    private MenuItem newProject,
            newFile,
            openProject,
            openFile,
            closeProject,
            save,
            saveAs,
            exit;
    
    private CheckMenuItem checkLang1,
            checkLang2,
            checkLang3;
    
    private RadioMenuItem r1,r2,r3; // Select One Color Between 3
    
    private Slider slider;
            
    private CustomMenuItem cmi;
    
    private ImageView img1, img2, img3;
    
    private Label l; // This Label Showing In The Center OF the Page
            
    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        
        menuBar = new MenuBar();
        menuFile = new Menu("File");
        
        /* Image View */
        img1 = new ImageView("images/Facebook.png");
        img2 = new ImageView("images/Twitter.png");
        img3 = new ImageView("images/YouTube.png");
        
        newProject = new MenuItem("New Project", img1);
        newFile = new MenuItem("New File");
        newFile.setGraphic(img2); // Add image in the menu item
        openProject = new MenuItem("Open Project");
        openFile = new MenuItem("Open File");
        closeProject = new MenuItem("Close Project");
        save = new MenuItem("Save");
        save.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        saveAs = new MenuItem("Save As");
        exit = new MenuItem("Exit");
        exit.setOnAction(this);
        
        /* Adding ShortCut To This Element */
        exit.setAccelerator(new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN)); // Any: not Obligatoire (Optional), Down: this Key Obligat Pressed to Do This
        
        
        menuFile.getItems().addAll(newProject, newFile,
                new SeparatorMenuItem(), openProject, openFile, closeProject,
                new SeparatorMenuItem(), save, saveAs,
                new SeparatorMenuItem(), exit);
        
        menuView = new Menu("View");
        
        menuLanguage = new Menu("Language");
        
        /* Check Menu Item */
        checkLang1 = new CheckMenuItem("Java", img3);
        checkLang1.setSelected(true);
        checkLang2 = new CheckMenuItem("C++");
        checkLang3 = new CheckMenuItem("PHP");
        
        checkLang1.setOnAction(this);
        checkLang2.setOnAction(this);
        checkLang3.setOnAction(this);
        
        menuLanguage.getItems().addAll(checkLang1, checkLang2, checkLang3);
        
        /* Menu Inside another Menu */
        menuView.getItems().addAll(menuLanguage);
        
        menuBackground = new Menu("Background");
        
        r1 = new RadioMenuItem("Black");
        r2 = new RadioMenuItem("Green");
        r3 = new RadioMenuItem("White");
        
        r1.setOnAction(this);
        r2.setOnAction(this);
        r3.setOnAction(this);
        
        /* I use toggle group For Select One Radio Only */
        ToggleGroup tg = new ToggleGroup();
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        r3.setToggleGroup(tg);
        
        menuBackground.getItems().addAll(r1, r2, r3);
        
        slider = new Slider(0, 100, 10);
        slider.valueProperty().addListener(e -> {
            l.setFont(Font.font(slider.getValue()));
        });
        
        cmi = new CustomMenuItem(slider); /* Custom Menu Item use to Add any element */
        
        menuView.getItems().addAll(menuBackground, cmi);
        
        menuBar.getMenus().addAll(menuFile, menuView);
        
        l = new Label("Welcome To: ");
        l.setFont(new Font("Comic Sans MS", 22));
        root.setCenter(l);
        
        root.setTop(menuBar);
        Scene scene = new Scene(root, 700, 500);
        
        primaryStage.setTitle("Menu Bar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource().equals(exit)) {
            Platform.exit(); // Exit The Program (Close Window & Stop Process)
        } else if (event.getSource().equals(r1)) {
            root.setBackground(new Background(new BackgroundFill(Paint.valueOf("#000"), CornerRadii.EMPTY, Insets.EMPTY)));
        } else if (event.getSource().equals(r2)) {
            root.setBackground(new Background(new BackgroundFill(Paint.valueOf("#080"), CornerRadii.EMPTY, Insets.EMPTY)));
        } else if (event.getSource().equals(r3)) {
            root.setBackground(new Background(new BackgroundFill(Paint.valueOf("#FFF"), CornerRadii.EMPTY, Insets.EMPTY)));
        }
        
        if (event.getSource().equals(checkLang1) || event.getSource().equals(checkLang2) || event.getSource().equals(checkLang3)) {
            String s = "You Select: ";
            if (checkLang1.isSelected())
                s += checkLang1.getText() + " ";
            if (checkLang2.isSelected())
                s += checkLang2.getText() + " ";
            if (checkLang3.isSelected())
                s += checkLang3.getText() + " ";
            
            l.setText(s);
        }
        
    }
    
}
