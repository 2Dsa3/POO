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
    protected int[][] rango;

    public Pawn(int puntaje, Equipo color, int x, int y, Tablero t) {
        super(puntaje, color, x, y, t);
//        if (x==2) {
//            this.rango= new int[2][1];
//            for (int i = 0; i < 2; i++) {
//                rango[i][y]=x-i;
//            }
//        }
//        else {
//            this.rango= new int[1];
//            rango[0]=x+1;
//            
//        }
    }

    public boolean movimientoPosible(int destinoX, int destinoY, Tablero t){
        int a=this.getX();
        int b=this.getY();
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (t.getFichas()[destinoX][destinoY].getColor().equals(this.getColor())) {
                    return false;
                    
                }
                else if (this.hayUnaPiezaEnelCaminoPAWN(destinoX, destinoY)){
                    return false;
                }
                else if (a==6 && a-destinoX>2) {
                    return false;
                }
                else if (a!=6 && a-destinoX>1){
                    return false;
                }
            }
            
        }
        return false;
    }
    
    public boolean hayUnaPiezaEnelCaminoPAWN(int destinoX, int destinoY){
        
        for (int i = 0; i < destinoX; i++) {
            for (int j = 0; j < destinoY; j++) {
                if(destinoX==i && destinoY==j){
                    return true;
                }
                else if (t.getFichas()[i][j]!=null){
                    if(j==destinoY){
                        return true;
                    }
                    
                }
            }
            
        }
        return false;
    }
    
   
    
}
