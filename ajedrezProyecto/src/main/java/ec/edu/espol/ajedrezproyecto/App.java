package ec.edu.espol.ajedrezproyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ec.edu.espol.controllers.TableroAjedrezController;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
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
    private Button seleccionado = null;
    private final int tamañoBoton = 60;
    private final int tamañoImagen = 40;
    private String estiloBoton = "";
    


    @Override
    public void start(Stage stage) throws IOException {
         scene = new Scene(loadFXML("tableroAjedrez"), 680, 480);
        BorderPane bp = (BorderPane) this.scene.getRoot();

        // Create a GridPane for the chessboard
        GridPane pane = new GridPane();

        String[] filas = {"a","b","c","d","e","f","g","h"};
        int count = 0;
        double s = 60; // side of rectangle
        
       
        String[] pieceOrder = {"rook", "knight", "bishop", "queen", "king", "bishop", "knight", "rook"};
        int size = 8;
        
        for (int i = 0; i < 8; i++) {
            count++;
            for (int j = 0; j < 8; j++) {
                Button boton;
                Rectangle r = new Rectangle(s, s, s, s);
                if (count % 2 == 0)
                    r.setFill(Color.rgb(83, 124, 73));
                else
                    r.setFill(Color.rgb(255, 233, 175));

                Text text = new Text();
                text.setText(filas[j] + String.valueOf(8 - i));
                text.setOpacity(0.5);

                StackPane stack = new StackPane();
                stack.getChildren().addAll(r, text);
                pane.add(stack, j, i);
                count++;
           

                switch (i) {
                    case 0:
                        boton = crearBoton("ec/edu/espol/chessPieces/" +"black"+ pieceOrder[j]+".png");
                        break;
                    case 1:
                        boton = crearBoton("ec/edu/espol/chessPieces/blackpawn.png");
                        break;
                    case 6:
                        boton = crearBoton("ec/edu/espol/chessPieces/whitepawn.png");
                        break;
                    case 7:
                        boton = crearBoton("ec/edu/espol/chessPieces/" +"white"+ pieceOrder[j]+".png");
                        break;
                    default:
                        boton = crearBoton("ec/edu/espol/chessPieces/vacio.png");
                        break;
                }
                
                //Ficha ficha = new 
                boton.setOnAction(event -> moverBoton(boton));
                pane.add(boton, j, i);
                boton.setStyle("-fx-background-color: transparent; -fx-border-color: #000000"); 
               }
            }
        

        // Set up the chessboard with pieces
        //tableroPiezas(pane);
        
//        Scene sc = new Scene(pane);
//        stage.setTitle("Tablero Ajedrez");
//        stage.setScene(sc);
//        stage.show();

        bp.setCenter(pane);
        stage.setScene(scene);
        stage.setTitle("Ajedrez pro (POO Grupo8)");
        stage.show();
    }
    
//    private void tableroPiezas(GridPane pane){
//        Background dark = new Background(new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY));
//        Background light = new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY));
//
//        String[] pieceOrder = {"rook", "knight", "bishop", "queen", "king", "bishop", "knight", "rook"};
//        int size = 8;
//
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                Background bg = (row + col) % 2 == 0 ? dark : light;
//
//                StackPane square = (StackPane) pane.getChildren().get(row * size + col);
//                square.setBackground(bg);
//                square.setMinSize(0, 0);
//
//                ImageView piece = null;
//                Button boton = null;
//
//                switch (row) {
//                    case 0:
//                        boton = crearBoton("ec/edu/espol/chessPieces/" +"black"+ pieceOrder[col]+".png");
//                        break;
//                    case 1:
//                        boton = crearBoton("ec/edu/espol/chessPieces/blackpawn.png");
//                        break;
//                    case 6:
//                        boton = crearBoton("ec/edu/espol/chessPieces/whitepawn.png");
//                        break;
//                    case 7:
//                        boton = crearBoton("ec/edu/espol/chessPieces/" +"white"+ pieceOrder[col]+".png");
//                        break;
//                    default:
//                        break;
//                }
//
//                if (piece != null) {
//                    square.getChildren().add(boton);
//
//                    piece.fitWidthProperty().bind(square.widthProperty().subtract(10));
//                    piece.fitHeightProperty().bind(square.heightProperty().subtract(10));
//                }
//            }
//        }
//    }
    private Button crearBoton(String imagen) {
        Button boton = new Button();
        boton.setPrefSize(tamañoBoton, tamañoBoton);
        ImageView imageView = new ImageView(new Image(imagen)); // Cambia por la imagen por defecto
        imageView.setFitWidth(tamañoImagen);
        imageView.setFitHeight(tamañoImagen);
        boton.setGraphic(imageView);
        return boton;
    }
    
    private void moverBoton(Button boton) {
        if (seleccionado != null) {
            ImageView imageView = (ImageView) boton.getGraphic();
            Image image = imageView.getImage();
            
            ImageView selectedImageView = (ImageView) seleccionado.getGraphic();
            Image selectedImage = selectedImageView.getImage();
            
            imageView.setImage(selectedImage);
            selectedImageView.setImage(image);

            seleccionado.setStyle(estiloBoton); // Restaurar el estilo original del botón
            seleccionado = null;
        } else {
            seleccionado = boton;
            estiloBoton = seleccionado.getStyle(); // Almacena el estilo original del botón
            seleccionado.setStyle("-fx-background-color: #FFD700;"); // Cambiar el fondo del botón cuando se selecciona
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