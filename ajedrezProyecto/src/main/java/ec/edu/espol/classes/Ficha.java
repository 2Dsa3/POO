/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

/**
 *
 * @author japolo15
 */
public abstract class Ficha {
    protected int puntaje;
    protected String color;
    protected int x;
    protected int y;
    protected Tablero t;

    public Ficha(int puntaje, String color, int x, int y, Tablero t) {
        this.puntaje = puntaje;
        this.color = color;
        this.x = x;
        this.y = y;
        this.t= t;
    }

   
    
    public int getPuntaje() {
        return puntaje;
    }


    public String getColor() {
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
    
    
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
    
}
