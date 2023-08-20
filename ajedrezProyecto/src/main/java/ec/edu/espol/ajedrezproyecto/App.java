package ec.edu.espol.ajedrezproyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ec.edu.espol.controllers.TableroAjedrezController;

import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("tableroAjedrez"), 680, 480);
        BorderPane bp = (BorderPane) this.scene.getRoot();
        
            // Create a GridPane
        GridPane pane = new GridPane();

        // Create 64 rectangles and add to pane
        String[] filas = {"a","b","c","d","e","f","g","h"};
        int count = 0;
        double s = 60; // side of rectangle
        for (int i = 0; i < 8; i++) {
          count++;
          for (int j = 0; j < 8; j++) {
            Rectangle r = new Rectangle(s, s, s, s);
            if (count % 2 == 0)
              r.setFill(Color.rgb(83, 124, 73));
            else
              r.setFill(Color.rgb(255, 233, 175));
            Text text = new Text();
            text.setText(filas[j]+String.valueOf(8-i));
            //text.setX(j); 
            //text.setY(i);
            StackPane stack = new StackPane();
            stack.getChildren().addAll(r, text);
            //stack.setLayoutX(30);
            //stack.setLayoutY(30);
            pane.add(stack, j, i);
            count++;
          }
        bp.setCenter(pane);
        stage.setScene(scene);
        stage.setTitle("Ajedrez pro (POO Grupo8)");
        stage.show();
        }
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}