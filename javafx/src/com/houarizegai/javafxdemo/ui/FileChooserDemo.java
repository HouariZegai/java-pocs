import java.io.File;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        
        FileChooser fc = new FileChooser(); // Open dialog for open file
        fc.setTitle("Open File"); // the name of this new window (chooser file)
        
        FileChooser.ExtensionFilter all = new FileChooser.ExtensionFilter("All", "*.*"); // Filter search
        FileChooser.ExtensionFilter txt = new FileChooser.ExtensionFilter("Text", "*.txt");
        FileChooser.ExtensionFilter image = new FileChooser.ExtensionFilter("Image", "*.png", "*.jpg", "*.jpeg", "*.gif");
        
        fc.getExtensionFilters().addAll(all, txt, image); // Add filter search
        
        //File f = fc.showOpenDialog(primaryStage); // save the link of my file chooser (if i don't choose return null)
        List<File> f = fc.showOpenMultipleDialog(primaryStage);
        //File f  = fc.showSaveDialog(primaryStage);
        if (f != null)
            System.out.println(f);
            
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("File Chooser");
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
