/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

import java.util.ArrayList;


/**
 *
 * @author abisu
 */
public class Tablero {
         
    public Ficha[][] fichas;
    private ArrayList<Ficha> eliminadas;

    public Tablero() {
        this.fichas = new Ficha[8][8];
    }
//    public void llenarTablero(){
//        for (int i = 0; i < 8; i++) {
//            fichas[1][i]= new Pawn(0,Equipo.NEGRAS,1,i);
//        }
//        for (int i = 0; i < 8; i++) {
//            fichas[6][i]= new Pawn(0,Equipo.BLANCAS,6,i);
//        }
//        //....
//        
//    }
    
    public Tablero invertirTablero(){
        Tablero t_i= new Tablero();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int posX= 7-i;
                int posY= 7-j;
                t_i.getFichas()[posX][posY]=fichas[i][j];
            }
        }
        return t_i;
    }
    
    public void Eliminar(Ficha f, int x, int y){
        fichas[f.getX()][f.getY()]= null;
        eliminadas.add(f);
    }

    public Ficha[][] getFichas() {
        return fichas;
    }

    public ArrayList<Ficha> getEliminadas() {
        return eliminadas;
    }

    public void setFichas(Ficha[][] fichas) {
        this.fichas = fichas;
    }

    public void setEliminadas(ArrayList<Ficha> eliminadas) {
        this.eliminadas = eliminadas;
    }
    

    
}
