/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

import ec.edu.espol.controllers.TableroAjedrezController;
import java.util.ArrayList;

/**
 *
 * @author japolo15
 */
public class King extends Ficha{
    final int puntaje = -1;
    static int count;

    public King(Equipo color, int x, int y, Tablero t) {
        super(color, x, y, t);
    }
    
    @Override
    public String toString() {
        return "Rey"+super.toString();
    }
    
    @Override
    public void validarMovimiento(int x, int y) throws NonValidMove
    {
        int dX = Math.abs(x-this.getX());
        int dY = Math.abs(y-this.getY());
        double d = (double) Math.sqrt(dX^2+dY^2);
        if(d > Math.sqrt(2)||dX==2)
            throw new NonValidMove("Movimiento fuera del rango de la pieza.");
    }
        
//     

//    @Override
//    public void piezaClavada(Ficha f) throws PossibleCheckmate{
//        this.estaEnJaque(this.getColor(),nt); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//    }
//                            
                        
    

    @Override
    public void mover(Ficha f) throws NonValidMove, PossibleCheckmate{
        super.mover(f);
        if (reySolo())
            King.count = King.count + 1;
    }
    
    public boolean reySolo()
    {
        //Esto es para trabajar en las finales
        return false;
    }
    //color es el del rey
    public void estaEnJaque(Ficha ths, Ficha f) throws PossibleCheckmate
    {
        ArrayList<Ficha> piezasColor = null;
        if (this.getColor().equals(Equipo.BLANCAS))
            piezasColor = t.piezasNegras;
        else
            piezasColor = t.piezasBlancas;
        for (Ficha pieza: piezasColor){
            try{
            if (pieza instanceof Pawn)
                {
                    Pawn p = (Pawn) pieza;
                    p.validarCaptura(this.getX(),this.getY());
                }
            else
                pieza.validarMovimiento(this.getX(),this.getY());
                //pieza.
            throw new PossibleCheckmate("Estás en Jaque. \n" + pieza.toString() + "te ataca en" + this.toString());
            }
            catch(NonValidMove e){
//                int newX = ths.getX();
//                int newY = ths.getY();
//                ths.setX(f.getX());
//                ths.setY(f.getY());
//                f.setX(newX);
//                f.setY(newY);
                System.out.println("Se lanza el no valid move de "  + pieza.toString());
            }

                    }
                }
                    
            }
     
