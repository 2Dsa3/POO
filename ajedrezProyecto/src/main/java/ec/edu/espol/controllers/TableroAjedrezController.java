/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import ec.edu.espol.classes.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author japolo15
 */
public class TableroAjedrezController implements Initializable {

    @FXML
    private BorderPane mainpane;
    @FXML
    private GridPane blackpane;
    @FXML
    private Label blackmessage;
    @FXML
    private GridPane whitepane;
    @FXML
    private Label whitemessage;
    private Ficha seleccionado = null;
    private final int tamañoBoton = 60;
    private final int tamañoImagen = 40;
    private String estiloBoton = "";
    final String[] pieceOrder = {"rook", "knight", "bishop", "queen", "king", "bishop", "knight", "rook"};
    static Tablero t = new Tablero();
    private Equipo turno = Equipo.BLANCAS;

    
    
    
    private ArrayList<Ficha> piezasBlancas = new ArrayList<>();
    private ArrayList<Ficha> piezasNegras = new ArrayList<>();
    @FXML
    private GridPane blacktable;
    @FXML
    private GridPane whitetable;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TOD
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
           
                ficha = crearFicha(i,j,t);
                addEvent(ficha,i,j,t,pane);
                t.fichas[j][i]=ficha;
                Tooltip tooltip = new Tooltip(ficha.toString());
                tooltip.setFont(Font.font(14));
                Tooltip.install(ficha, tooltip);
                pane.add(ficha, j, i);
                if (ficha instanceof Casilla == false)
                    {
                        if(ficha.getColor().equals(Equipo.BLANCAS))
                            piezasBlancas.add(ficha);
                        else
                        {
                            piezasNegras.add(ficha);
                        }
                    }
                ficha.setStyle("-fx-background-color: transparent; -fx-border-color: #000000"); 
                
            }
        }
        

       
        mainpane.setCenter(pane);
    }   
    
    private Ficha crearFicha(int i,int j,Tablero t) {
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
                        ficha = new Pawn(Equipo.NEGRAS,j,i,t);
                        break;
                        
                    case 6:
                        img = new Image("ec/edu/espol/chessPieces/whitepawn.png");
                        ficha = new Pawn(Equipo.BLANCAS,j,i,t);
                        break;
                        
                    case 7:
                        img = new Image("ec/edu/espol/chessPieces/" +"white"+ pieceOrder[j]+".png");
                        ficha = elegirFicha(i,j,t);
                        break;
                        
                    default:
                        img = new Image("ec/edu/espol/chessPieces/vacio.png");
                        ficha = new Casilla(j,i,t);
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
                            ficha = new Rook(e,j,i,t);
                            break;
                    case 1:
                        case 6:
                            ficha = new Knight(e,j,i,t);
                            break;
                    case 2:
                        case 5:
                            ficha = new Bishop(e,j,i,t);
                            break;
                    case 3:
                        ficha = new Queen(e,j,i,t);
                        break;
                    case 4:
                        ficha = new King(e,j,i,t);
                        break;
            }
       
    return ficha;
    }
    
    public Ficha crearCasilla(int x, int y, Tablero T,GridPane pane)
    {
        Image img = new Image("ec/edu/espol/chessPieces/vacio.png");
        Ficha ficha = new Casilla(x,y,t);
        ficha.setPrefSize(tamañoBoton, tamañoBoton);
        ImageView imageView = new ImageView(img); // Cambia por la imagen por defecto
        imageView.setFitWidth(tamañoImagen);
        imageView.setFitHeight(tamañoImagen);
        ficha.setGraphic(imageView);
        Tooltip tooltip = new Tooltip(ficha.toString());
        tooltip.setFont(Font.font(14));
        Tooltip.install(ficha, tooltip);
        ficha.setStyle("-fx-background-color: transparent; -fx-border-color: #000000");
        addEvent(ficha,x,y,t,pane);
        
        return ficha;
    }
    
    public void addEvent(Ficha ficha,int x,int y, Tablero t,GridPane pane)
    {
    ficha.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event e) -> {
                    try{
                        if (seleccionado == null){
                            if (!ficha.getColor().equals(turno))
                                    throw new WrongTurnException("Es el turno de las "+ turno.toString());
                            }
                        else{
                        if (!seleccionado.getColor().equals(turno))
                                throw new WrongTurnException("Es el turno de las "+ turno.toString());
                        }
                        if (seleccionado instanceof Casilla)
                        {
                            seleccionado.setStyle("-fx-background-color: transparent; -fx-border-color: #000000");
                            seleccionado = ficha;
                           
                            estiloBoton = "-fx-background-color: transparent; -fx-border-color: #000000"; // Almacena el estilo original del botón
                            seleccionado.setStyle("-fx-background-color: #FFD700;"); // Cambiar el fondo del botón cuando se selecciona
                            
                        }
                        else if (seleccionado != null)
                        {
                            if (seleccionado == ficha)
                                throw new IllegalArgumentException();
                            int row1 = GridPane.getRowIndex(seleccionado);
                            int column1 = GridPane.getColumnIndex(seleccionado);
                            int row2 = GridPane.getRowIndex(ficha);
                            int column2 = GridPane.getColumnIndex(ficha);
                            
                            if(ficha instanceof Casilla)
                            {
                                seleccionado.mover(ficha);
                                t.fichas[x][y]=ficha;
                                
                                pane.getChildren().remove(seleccionado);
                                pane.getChildren().remove(ficha);
                                Ficha cas= crearCasilla(column1,row1,t,pane);
                                pane.add(cas, column1, row1);
                                t.fichas[column1][row1]=cas;
                                pane.add(seleccionado, column2, row2);
                                if (seleccionado==null)
                                    {t.fichas[column2][row2]= new Casilla(column2,row2,t);
                                    }
                                else 
                                    {t.fichas[column2][row2]=seleccionado;
                                    }
                            }
                            else if (ficha.getColor()==seleccionado.getColor())
                                throw new NonValidMove("No puedes moverte donde hay una pieza de tu color.");
                            else
                            {
                                seleccionado.capturar(ficha);
                                pane.getChildren().remove(seleccionado);
                                pane.getChildren().remove(ficha);
                                pane.add(crearCasilla(column1,row1,t,pane), column1, row1);
                                t.fichas[column1][row1]=crearCasilla(column1,row1,t,pane);
                                pane.add(seleccionado, column2, row2);
                                if (seleccionado==null)
                                    {t.fichas[column2][row2]= new Casilla(column2,row2,t);
                                    }
                                else 
                                    {t.fichas[column2][row2]=seleccionado;
                                   }
                                if (ficha.getColor().equals(Equipo.BLANCAS))
                                    piezasBlancas.remove(ficha);
                                else
                                    piezasNegras.remove(ficha);
                                //mostrarMensaje("¡Tu turno!",ficha);
                            }
                            seleccionado.setStyle(estiloBoton);
                            seleccionado = null;
                            cambiarTurno();
                            ficha.setStyle("-fx-background-color: transparent; -fx-border-color: #000000");
                        }
//                    
                        else
                        {
                            seleccionado = ficha;
                            estiloBoton = seleccionado.getStyle(); // Almacena el estilo original del botón
                            seleccionado.setStyle("-fx-background-color: #FFD700;"); // Cambiar el fondo del botón cuando se selecciona
                        }
//                    
                    }
                    catch(IllegalArgumentException ex)
                    {
                        seleccionado.setStyle("-fx-background-color: transparent; -fx-border-color: #000000");
                        seleccionado = null;
                    }
                    catch(NullPointerException ex)
                    {
//                     
                    }
                    catch (NonValidMove ex) 
                    {
                    mostrarMensaje(ex.getMessage(),turno);
                    }
                    //Hacer un catch que atrape una excepción customizable de jaque
                    //Esta excepción debe ser lanzada por un método del rey, que valide si está en jaque
                    //También debe haber algún catch que atrape una excepción de jaque mate, debe estar antes que la del jaque
                    catch (WrongTurnException ex)
                    {
                    Equipo team;
                    if (turno.equals(Equipo.BLANCAS))
                        team = Equipo.NEGRAS;
                    else
                        team = Equipo.BLANCAS;
                    mostrarMensaje(ex.getMessage(),team);
                    }
                    catch (Exception ex) 
                    {
                    System.out.println(ex);
                    Alert a = new Alert(Alert.AlertType.ERROR,"Error inesperado. Notificar al desarrollador");
                    a.show();
                    }
                });
    }
    
    public void mostrarMensaje(String mensaje, Equipo turno){
        if(turno.equals(Equipo.BLANCAS))
                whitemessage.setText(mensaje);
        else
            blackmessage.setText(mensaje);
    }
 
    public void cambiarTurno()
    {
    if (turno.equals(Equipo.BLANCAS))
        turno = Equipo.NEGRAS;
    else
        turno = Equipo.BLANCAS;
    } 
    }