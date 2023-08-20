/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

/**
 *
 * @author abisu
 */
public class Pawn extends Ficha {
    
    public Pawn(int puntaje, String color, int x, int y, Tablero t) {
        super(puntaje, color, x, y,t);
    }
    
    public boolean movimientoPosible(int posX, int posY, Tablero t){
        int a=this.getX();
        int b=this.getY();
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (t.getFichas()[posX][posY].getColor().equals(this.getColor())) {
                    
                }
            }
            
        }
    }
    
   
    
}
