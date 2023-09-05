/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

import ec.edu.espol.controllers.TableroAjedrezController;
import java.util.ArrayList;
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
        try{this.piezaClavada(f);}
        catch(PossibleCheckmate ex)
        {
            int newX = this.getX();
            int newY = this.getY();
            this.setX(f.getX());
            this.setY(f.getY());
            f.setX(newX);
            f.setY(newY);
            throw new PossibleCheckmate(ex.getMessage());
        }
        //this.t.getFichas()[this.getX()][this.getY()]= new Casilla(this.getX(),this.getY(),t);
        //this.t.getFichas()[f.getX()][f.getY()]=this;
//        int newX = this.getX();
//        int newY = this.getY();
//        this.setX(f.getX());
//        this.setY(f.getY());
//        f.setX(newX);
//        f.setY(newY);
         
        
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
    
    public abstract void validarMovimiento(int x, int y) throws NonValidMove;
    
    
    public void actualizarTooltip()
    {
        Tooltip tooltip = new Tooltip(this.toString());
                tooltip.setFont(Font.font(14));
                Tooltip.install(this, tooltip);
    }
    
    public void capturar (Ficha f) throws NonValidMove,PossibleCheckmate{
        this.validarMovimiento(f.getX(),f.getY());
        
        try{this.piezaClavada(f);}
        catch(PossibleCheckmate ex)
        {
            int newX = this.getX();
            int newY = this.getY();
            this.setX(f.getX());
            this.setY(f.getY());
            f.setX(newX);
            f.setY(newY);
            throw new PossibleCheckmate(ex.getMessage());
        }
        //this.t.getFichas()[this.getX()][this.getY()]= new Casilla(this.getX(),this.getY(),t);
        //this.t.getFichas()[f.getX()][f.getY()]=this;
        
//        int newX = this.getX();
//        int newY = this.getY();
//        this.setX(f.getX());
//        this.setY(f.getY());
//        f.setX(newX);
//        f.setY(newY);
        //this.actualizarTooltip();
    }
    
    public void piezaClavada(Ficha f) throws PossibleCheckmate{
//      Ficha[][] nt = TableroAjedrezController.t.getFichas().clone();
//        //try {
//            Ficha cloned;
//            nt[this.getX()][this.getY()] = new Casilla(this.getX(),this.getY(),t);
//            if (f instanceof Casilla)
//                cloned = new Casilla(this.getX(),this.getY(),t);
//            else
//                cloned = f.clone();
//            nt[f.getX()][f.getY()] = cloned;
//            cloned.setX(f.getX());
//            cloned.setY(f.getY());
        int newX = this.getX();
        int newY = this.getY();
        this.setX(f.getX());
        this.setY(f.getY());
        f.setX(newX);
        f.setY(newY);
        //} catch (CloneNotSupportedException ex) {
            //ex.printStackTrace();
//        Alert a = new Alert(Alert.AlertType.ERROR,"MO se clonó");
//                    a.show();
       // }
      ArrayList<Ficha> piezasColor = null;
        if (this.getColor().equals(Equipo.BLANCAS))
            piezasColor = t.piezasBlancas;
        else
            piezasColor = t.piezasNegras;
      for (Ficha pieza: piezasColor){
            //Equipo color;
            if (pieza instanceof King) {
                King k = (King) pieza;
                k.estaEnJaque(this,f); //This se mueva a F
                                    
                                        //TableroAjedrezController.mostrarMensaje("Estas en Jaque",c);
                                        
                                    }
                                    
                                }
                                
                            }

    

    @Override
    protected Ficha clone(){
    Ficha f = null;
        if (this instanceof Queen)
        {
            f = new Queen(this.getColor(),this.getX(),this.getY(),t);
        }
        if (this instanceof Rook)
        {
            f = new Rook(this.getColor(),this.getX(),this.getY(),t);
        }
        if (this instanceof Bishop)
        {
            f = new Rook(this.getColor(),this.getX(),this.getY(),t);
        }
        if (this instanceof Knight)
        {
            f = new Rook(this.getColor(),this.getX(),this.getY(),t);
        }
        if (this instanceof Pawn)
        {
            f = new Rook(this.getColor(),this.getX(),this.getY(),t);
        }
    
        return f; 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
