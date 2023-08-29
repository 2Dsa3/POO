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
    final int puntaje = 1;
    public boolean primerMovimiento = true;

    public Pawn(Equipo color, int x, int y, Tablero t) {
        super(color, x, y, t);
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

    @Override
    public String toString() {
        return "Peón"+super.toString();
    }

    @Override
    public void validarMovimiento(int x, int y) throws NonValidMove 
    {    
        int difY = 1;
        if (this.primerMovimiento)
            difY = 1 + difY;
        if(this.getColor().equals(Equipo.BLANCAS))
        {
        if(this.getY()-y> difY ||this.getY()-y<0|| x-this.getX()!= 0)
            throw new NonValidMove("Movimiento fuera del rango de la pieza.");
        }
        else
            if(y-this.getY()> difY ||y-this.getY()<0|| x-this.getX()!= 0)
            throw new NonValidMove("Movimiento fuera del rango de la pieza.");
        this.primerMovimiento = false;
    }
   
}
