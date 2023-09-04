/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

import ec.edu.espol.controllers.TableroAjedrezController;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

/**
 *
 * @author japolo15
 */
public abstract class Ficha extends Button {
    protected final int puntaje = 0;
    protected Equipo color;
    protected int x;
    protected int y;
    protected Tablero t;
    

    public Ficha(Equipo color, int x, int y, Tablero t) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.t= t;
    }

   public void mover(Ficha f) throws NonValidMove, PossibleCheckmate{
        
        this.validarMovimiento(f.getX(),f.getY());
        this.piezaClavada(f);
        //this.t.getFichas()[this.getX()][this.getY()]= new Casilla(this.getX(),this.getY(),t);
        //this.t.getFichas()[f.getX()][f.getY()]=this;
        int newX = this.getX();
        int newY = this.getY();
        this.setX(f.getX());
        this.setY(f.getY());
        f.setX(newX);
        f.setY(newY);
         
        
        //this.actualizarTooltip();
    }
    
    public int getPuntaje() {
        return puntaje;
    }


    public Equipo getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Tablero getT() {
        return t;
    }
    
    public String getPosicion(){
    String[] filas = {"a","b","c","d","e","f","g","h"};
    return filas[this.getX()] + String.valueOf(8-this.getY());
    }

    public void setColor(Equipo color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "\n"+this.color.toString() + "\n" + this.getPosicion();
          
    }
    public void moverFicha(){
    
    }
    
    public abstract void validarMovimiento(int x, int y) throws NonValidMove;
    
//    public static Ficha elegirFicha(int i, int j,Tablero t)
//    {
//        Ficha ficha = null;
//        Equipo e;
//        if (i == 7)
//            e = Equipo.BLANCAS;
//        else
//            e = Equipo.NEGRAS;
//        switch (j) 
//            {
//                    case 0:
//                        case 7:
//                            ficha = new Rook(e,i,j,t);
//                            break;
//                    case 1:
//                        case 6:
//                            ficha = new Knight(e,i,j,t);
//                            break;
//                    case 2:
//                        case 5:
//                            ficha = new Bishop(e,i,j,t);
//                            break;
//                    case 3:
//                        ficha = new Queen(e,i,j,t);
//                        break;
//                    case 4:
//                        ficha = new King(e,i,j,t);
//                        break;
//            }
//    return ficha;
//    }
//    
//    public static Ficha crearBoton(int i,int j,Tablero t,int tB, int tI) {
//        Ficha ficha;
//        Image img;
//        String[] pieceOrder = {"rook", "knight", "bishop", "queen", "king", "bishop", "knight", "rook"};
//        switch (i) 
//                {
//                    case 0:
//                        img = new Image("ec/edu/espol/chessPieces/" +"black"+ pieceOrder[j]+".png");
//                        ficha = elegirFicha(i,j,t);
//                        break;
//                        
//                    case 1:
//                        img = new Image("ec/edu/espol/chessPieces/blackpawn.png");
//                        ficha = new Pawn(Equipo.NEGRAS,i,j,t);
//                        break;
//                        
//                    case 6:
//                        img = new Image("ec/edu/espol/chessPieces/whitepawn.png");
//                        ficha = new Pawn(Equipo.BLANCAS,i,j,t);
//                        break;
//                        
//                    case 7:
//                        img = new Image("ec/edu/espol/chessPieces/" +"white"+ pieceOrder[j]+".png");
//                        ficha = elegirFicha(i,j,t);
//                        break;
//                        
//                    default:
//                        img = new Image("ec/edu/espol/chessPieces/vacio.png");
//                        ficha = new Casilla(i,j,t);
//                        break;
//                }
//        ficha.setPrefSize(tB, tB);
//        ImageView imageView = new ImageView(img); // Cambia por la imagen por defecto
//        imageView.setFitWidth(tI);
//        imageView.setFitHeight(tI);
//        ficha.setGraphic(imageView);
//        return ficha;
//    }
    
    public void actualizarTooltip()
    {
        Tooltip tooltip = new Tooltip(this.toString());
                tooltip.setFont(Font.font(14));
                Tooltip.install(this, tooltip);
    }
    
    public void capturar (Ficha f) throws NonValidMove,PossibleCheckmate{
        this.validarMovimiento(f.getX(),f.getY());
        this.piezaClavada(f);
        //this.t.getFichas()[this.getX()][this.getY()]= new Casilla(this.getX(),this.getY(),t);
        //this.t.getFichas()[f.getX()][f.getY()]=this;
        int newX = this.getX();
        int newY = this.getY();
        this.setX(f.getX());
        this.setY(f.getY());
        f.setX(newX);
        f.setY(newY);
        //this.actualizarTooltip();
    }
    
    public void piezaClavada(Ficha f) throws PossibleCheckmate{
      Ficha[][] nt = TableroAjedrezController.t.getFichas().clone();
        //try {
            nt[this.getX()][this.getY()] = f;
            nt[f.getX()][f.getY()] = this;
        //} catch (CloneNotSupportedException ex) {
            //ex.printStackTrace();
//        Alert a = new Alert(Alert.AlertType.ERROR,"MO se clonó");
//                    a.show();
       // }
      for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                Equipo color;
                                if (nt[i][j] instanceof King && !(((this.getColor()).equals(nt[i][j].getColor()))) ) {
                                    color = nt[i][j].getColor();
                                    King k= (King)nt[i][j];
                                    System.out.println("CUMPLE");
                                    k.estaEnJaque(color,nt); 
                                    
                                        //TableroAjedrezController.mostrarMensaje("Estas en Jaque",c);
                                        
                                    }
                                    
                                }
                                
                            }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
