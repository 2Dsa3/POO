/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

import javafx.scene.control.Alert;
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
    
    @Override
    public void validarMovimiento(int x, int y) throws NonValidMove {    
        throw new NonValidMove("");
                }

    @Override
    public void mover(Ficha f) {
        try {
            super.mover(f); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        } catch (NonValidMove ex) {
            Alert a = new Alert(Alert.AlertType.WARNING,"Mensaje secreto!");
            a.show();
        }
    }
    
    
    
}
