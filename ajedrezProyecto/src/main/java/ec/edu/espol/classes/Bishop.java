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
    public void validarMovimiento(int x, int y) throws NonValidMove 
    {
        if(Math.abs(this.getX()-x)!=Math.abs(this.getY()-y)){
        throw new NonValidMove("Movimiento fuera de rango de la pieza.");
        }
        
        else if( this.getX()<x && this.getY()<y )
        {for (int i = this.getX()+1; i < x; i++) {
                for (int j = this.getY()+1; j < y; j++) {
                    if (Math.abs(this.getX()-x)==Math.abs(this.getY()-y) && (Math.abs(i-x)==Math.abs(j-y)) &&!(t.fichas[i][j] instanceof Casilla) )
                        throw new NonValidMove("No puedes moverte adelante de otra pieza.");
                    }
        
        }}
        else if( this.getX()<x && this.getY()>y ){
            for ( int i = this.getX() +1; i < x; i++) {
                for ( int j = y; j < this.getY(); j++) {
                    if ( Math.abs(this.getX()-x)==Math.abs(this.getY()-y) && (Math.abs(i-x)==Math.abs(j-y)) && !(t.fichas[i][j] instanceof Casilla))
                        throw new NonValidMove("No puedes moverte adelante de otra pieza.");                

                }
            }}
        else if( this.getX()>x && this.getY()<y ){
            for ( int i = x; i < this.getX(); i++) {
                for ( int j = this.getY(); j < y ; j++) {
                    if (Math.abs(this.getX()-x)==Math.abs(this.getY()-y) && (Math.abs(i-x)==Math.abs(j-y)) && !(t.fichas[i][j] instanceof Casilla))
                        throw new NonValidMove("No puedes moverte adelante de otra pieza.");                

                }
            }}
        else if( this.getX()>x && this.getY()>y ){
            for ( int i = x; i < this.getX(); i++) {
                for ( int j = y; j < this.getY() ; j++) {
                    if ( Math.abs(this.getX()-x)==Math.abs(this.getY()-y) &&(Math.abs(i-x)==Math.abs(j-y)) && !(t.fichas[i][j] instanceof Casilla))
                        throw new NonValidMove("No puedes moverte adelante de otra pieza.");                

                }
            }}
    }
}
            
     

