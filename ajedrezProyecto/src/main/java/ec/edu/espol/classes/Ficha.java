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
    protected Equipo color;
    protected int x;
    protected int y;
    protected Tablero t;
    

    public Ficha(int puntaje, Equipo color, int x, int y, Tablero t) {
        this.puntaje = puntaje;
        this.color = color;
        this.x = x;
        this.y = y;
        this.t= t;
    }

   public void mover(int x, int y){
        
            this.t.getFichas()[x][y]=this;
            this.t.getFichas()[this.getX()][this.getY()]= null;
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
    
    
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
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
    
    
    
    
    
}
