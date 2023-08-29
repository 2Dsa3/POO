/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

/**
 *
 * @author japolo15
 */
public class Queen extends Ficha {
    final int puntaje = 9;

    public Queen(Equipo color, int x, int y, Tablero t) {
        super(color, x, y, t);
    }
    
    @Override
    public String toString() {
        return "Dama"+super.toString();
    }
    
    @Override
    public void validarMovimiento(int x, int y) throws NonValidMove
    {   if(this.getX()!=x && this.getY()!=y && Math.abs(this.getX()-x)!= Math.abs(this.getY()-y))
        throw new NonValidMove("Movimiento fuera de rango de la pieza.");
    }
}
