/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

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

    @Override
    public void mover(Ficha f) throws NonValidMove {
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
    public boolean estaEnJaque(String color) throws PossibleCheckmate{
        boolean b;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (! (t.fichas[i][j].getColor().equals(Equipo.valueOf(color)))){
                    try{
                        t.fichas[i][j].capturar(this);
                        throw new PossibleCheckmate("Estas en Jaque");
                    }
                    catch(NonValidMove e){
                        
                    }
                    
                }
                    
            }
        }
        return false;
    }
}
