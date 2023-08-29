/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

/**
 *
 * @author japolo15
 */
public class Bishop extends Ficha {
    final int puntaje = 3;

    public Bishop(Equipo color, int x, int y, Tablero t) {
        super(color, x, y, t);
    }
    
    @Override
    public String toString() {
        return "Alfil"+super.toString();
    }
    
    @Override
    public void validarMovimiento(int x, int y) throws NonValidMove {    
        throw new NonValidMove("");
                }
}
