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

   public void mover(int x, int y){
            this.t.getFichas()[this.getX()][this.getY()]= new Casilla(this.getX(),this.getY(),t);
            this.t.getFichas()[x][y]=this;
            this.setX(x);
            this.setY(y);
        
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
    return filas[this.getY()] + String.valueOf(8 - this.getX());
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
        return this.color.toString() + "\n" + this.getPosicion();
          
    }
    public void moverFicha(){
    
    }
    
}
