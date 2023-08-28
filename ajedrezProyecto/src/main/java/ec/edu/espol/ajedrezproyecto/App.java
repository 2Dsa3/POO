package ec.edu.espol.ajedrezproyecto;

import ec.edu.espol.classes.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ec.edu.espol.controllers.TableroAjedrezController;

import java.io.IOException;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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
    final String[] pieceOrder = {"rook", "knight", "bishop", "queen", "king", "bishop", "knight", "rook"};
    static Tablero t = new Tablero();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("tableroAjedrez"), 680, 480);
        BorderPane bp = (BorderPane) this.scene.getRoot();

        // Create a GridPane for the chessboard
        GridPane pane = new GridPane();
        
        String[] filas = {"a","b","c","d","e","f","g","h"};
        int count = 0;
        double s = 60; // side of rectangle
        
       
        
        
        for (int i = 0; i < 8; i++) 
        {
            count++;
            for (int j = 0; j < 8; j++) 
            {
                Ficha ficha;
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
           
                ficha = crearBoton(i,j,t);
                
                
//                
                ficha.addEventHandler(MouseEvent.MOUSE_CLICKED,(Event e)->
                {   try{
                    if (seleccionado instanceof Casilla)
                    {
                        seleccionado.setStyle("-fx-background-color: transparent; -fx-border-color: #000000");
                        seleccionado = ficha;
                        estiloBoton = "-fx-background-color: transparent; -fx-border-color: #000000"; // Almacena el estilo original del botón
                        seleccionado.setStyle("-fx-background-color: #FFD700;"); // Cambiar el fondo del botón cuando se selecciona

                    }
                    else if (seleccionado != null)
                    {
                    int row1 = GridPane.getRowIndex(seleccionado);
                    int column1 = GridPane.getColumnIndex(seleccionado);
                    int row2 = GridPane.getRowIndex(ficha);
                    int column2 = GridPane.getColumnIndex(ficha);

                    pane.getChildren().remove(seleccionado);
                    pane.getChildren().remove(ficha);

                    pane.add(ficha, column1, row1);
                    pane.add(seleccionado, column2, row2);
                    ficha.mover(column2,row2);
                    seleccionado.setStyle(estiloBoton);
                    seleccionado = null;
                    ficha.setStyle("-fx-background-color: transparent; -fx-border-color: #000000");
                    }
//                    else 
//                    {
//                        seleccionado = ficha;
//                        estiloBoton = seleccionado.getStyle(); // Almacena el estilo original del botón
//                        seleccionado.setStyle("-fx-background-color: #FFD700;"); // Cambiar el fondo del botón cuando se selecciona
//                    }
//                    if (seleccionado != null)
////                    {
////                        ImageView imgVSelect = (ImageView) ficha.getGraphic();
////                        Image imgSelect = (Image) imgVSelect.getImage();
//                        //if (imgSelect.equals(new Image("ec/edu/espol/chessPieces/vacio.png")))
//                        {
//                            ImageView imageView = (ImageView) ficha.getGraphic();
//                            Image image = imageView.getImage();
//
//                            ImageView selectedImageView = (ImageView) seleccionado.getGraphic();
//                            Image selectedImage = selectedImageView.getImage();
//
//                            imageView.setImage(selectedImage);
//                            selectedImageView.setImage(image);hh
//
//                            seleccionado.setStyle(estiloBoton); // Restaurar el estilo original del botón
//                            seleccionado = null;
//                        }
                        else 
                        {
                            seleccionado = ficha;
                            estiloBoton = seleccionado.getStyle(); // Almacena el estilo original del botón
                            seleccionado.setStyle("-fx-background-color: #FFD700;"); // Cambiar el fondo del botón cuando se selecciona
                        }//                    } 
//                    else 
//                    {
//                        seleccionado = ficha;
//                        estiloBoton = seleccionado.getStyle(); // Almacena el estilo original del botón
//                        seleccionado.setStyle("-fx-background-color: #FFD700;"); // Cambiar el fondo del botón cuando se selecciona
//                    }
                        
                    }
                catch(IllegalArgumentException iae)
                {
                    Alert a = new Alert(Alert.AlertType.WARNING,"Mueva la pieza al lugar que le corresponda. \nPieza tocada, pieza movida.");
                    a.show();
                }
                });
                
                Tooltip tooltip = new Tooltip(ficha.toString());
                tooltip.setFont(Font.font(14));
                Tooltip.install(ficha, tooltip);
                pane.add(ficha, j, i);
                ficha.setStyle("-fx-background-color: transparent; -fx-border-color: #000000"); 
            }
        }
        

        // Set up the chessboard with pieces
        //tableroPiezas(pane);
        

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
    
    
    
    private Ficha crearBoton(int i,int j,Tablero t) {
        Ficha ficha;
        Image img;
        switch (i) 
                {
                    case 0:
                        img = new Image("ec/edu/espol/chessPieces/" +"black"+ pieceOrder[j]+".png");
                        ficha = elegirFicha(i,j,t);
                        break;
                        
                    case 1:
                        img = new Image("ec/edu/espol/chessPieces/blackpawn.png");
                        ficha = new Pawn(Equipo.NEGRAS,i,j,t);
                        break;
                        
                    case 6:
                        img = new Image("ec/edu/espol/chessPieces/whitepawn.png");
                        ficha = new Pawn(Equipo.BLANCAS,i,j,t);
                        break;
                        
                    case 7:
                        img = new Image("ec/edu/espol/chessPieces/" +"white"+ pieceOrder[j]+".png");
                        ficha = elegirFicha(i,j,t);
                        break;
                        
                    default:
                        img = new Image("ec/edu/espol/chessPieces/vacio.png");
                        ficha = new Casilla(i,j,t);
                        break;
                }
        ficha.setPrefSize(tamañoBoton, tamañoBoton);
        ImageView imageView = new ImageView(img); // Cambia por la imagen por defecto
        imageView.setFitWidth(tamañoImagen);
        imageView.setFitHeight(tamañoImagen);
        ficha.setGraphic(imageView);
        return ficha;
    }
   
    public static Ficha elegirFicha(int i, int j,Tablero t)
    {
        Ficha ficha = null;
        Equipo e;
        if (i == 7)
            e = Equipo.BLANCAS;
        else
            e = Equipo.NEGRAS;
        switch (j) 
            {
                    case 0:
                        case 7:
                            ficha = new Rook(e,i,j,t);
                            break;
                    case 1:
                        case 6:
                            ficha = new Knight(e,i,j,t);
                            break;
                    case 2:
                        case 5:
                            ficha = new Bishop(e,i,j,t);
                            break;
                    case 3:
                        ficha = new Queen(e,i,j,t);
                        break;
                    case 4:
                        ficha = new King(e,i,j,t);
                        break;
            }
    return ficha;
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