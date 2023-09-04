/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

import ec.edu.espol.controllers.TableroAjedrezController;

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

    @Override
    public void piezaClavada(Ficha f) throws PossibleCheckmate{
        this.estaEnJaque(this.getColor()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
                            
                        
    

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
    public void estaEnJaque(Equipo color) throws PossibleCheckmate
    {
        for (int i = 0; i < 8; i++) 
        {
            for (int j = 0; j < 8; j++) 
            {
                if(t.fichas[i][j] instanceof Casilla == false)
                {
                    if (! (t.fichas[i][j].getColor().equals(color)))
                    {
                        try
                        {
                            if (t.fichas[i][j] instanceof Pawn)
                            {
                                Pawn p = (Pawn) t.fichas[i][j];
                                p.validarCaptura(this.getX(),this.getY());
                            }
                            else
                                t.fichas[i][j].validarMovimiento(this.getX(),this.getY());
                            System.out.println("Se ejecuta el bool");
                            throw new PossibleCheckmate("Estás en Jaque.");
                        }
                        catch(NonValidMove e){
                            System.out.println("Se lanza el no valid move");
                        }

                    }
                }
                    
            }
        }
    }
    
//    for (int i = 0; i < 8; i++) {
//                            for (int j = 0; j < 8; j++) {
//                                String color;
//                                if (t.fichas[i][j] instanceof King && !(String.valueOf(ficha.getColor()).equals(String.valueOf(t.fichas[i][j].getColor()))) ) {
//                                    color= String.valueOf(t.fichas[i][j].getColor());
//                                    King k= (King)t.fichas[i][j];
//                                    System.out.println("CUMPLE");
//                                    if (k.estaEnJaque(color)){ 
//                                        Equipo c= k.getColor();
//                                        mostrarMensaje("Estas en Jaque",c);
//                                        
//                                    }
//                                    
//                                }
//                                
//                            }
//                            
//                        }
}
