/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

import javafx.scene.control.Button;

/**
 *
 * @author japolo15
 */
public class Casilla extends Ficha {
    private int x;
    private int y;
    private Tablero t;

    public Casilla(int x, int y, Tablero t) {
        super(null, x, y, t);
        this.x = x;
        this.y = y;
        this.t = t;
    }

    @Override
    public String toString() {
        return "Casilla " + this.getPosicion();
    }
    
    
}
