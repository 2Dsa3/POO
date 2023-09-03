/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

/**
 *
 * @author japolo15
 */
public class Rook extends Ficha {
    final int puntaje = 5;

    public Rook(Equipo color, int x, int y, Tablero t) {
        super(color, x, y, t);
    }
    
    @Override
    public String toString() {
        return "Torre"+super.toString();
    }

   @Override
    public void validarMovimiento(int x, int y) throws NonValidMove 
    {
        if(this.getX()!=x && this.getY()!=y)
            throw new NonValidMove("Movimiento fuera de rango de la pieza.");
         
        else if (this.getX()<x )
        {for (int i = this.getX()+1; i < x; i++) {
                if ( !(t.fichas[i][y] instanceof Casilla) )
                        throw new NonValidMove("No puedes moverte encima de otra pieza.");
                    }}
        else if (this.getX()>x){
           {for (int i = x+1; i < this.getX(); i++) {
                if ( !(t.fichas[i][y] instanceof Casilla) )
                        throw new NonValidMove("No puedes moverte encima de otra pieza.");
                    }} 
        }
        else if (this.getY()<y )
        {for (int j = this.getY()+1; j < y; j++) {
                if (!(t.fichas[x][j] instanceof Casilla) )
                        throw new NonValidMove("No puedes moverte encima de otra pieza.");
                    }}
        else if (this.getY()>y )
        {for (int j = y+1; j < this.getY(); j++) {
                if (!(t.fichas[x][j] instanceof Casilla) )
                        throw new NonValidMove("No puedes moverte encima de otra pieza.");
                    }}
    }
    
}
