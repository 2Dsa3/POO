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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    private Ficha[][] fichas;

    public Tablero() {
        this.fichas = new Ficha[8][8];
    }
    public void llenarTablero(){
        for (int i = 0; i < 8; i++) {
            fichas[1][i]= new Pawn(0,casi,"black",1,i);
        }
        for (int i = 0; i < 8; i++) {
            fichas[6][i]= new Pawn(0,casi,"white",6,i);
        }
    }
         
=======
    private Ficha[][] fichas;
    private ArrayList<Ficha> eliminadas;

    public Tablero() {
        this.fichas = new Ficha[8][8];
    }
    public void llenarTablero(){
        for (int i = 0; i < 8; i++) {
            fichas[1][i]= new Pawn(0,"black",1,i);
        }
        for (int i = 0; i < 8; i++) {
            fichas[6][i]= new Pawn(0,"white",6,i);
        }
        //....
        
    }
    
    public void Mover(Ficha f,int x, int y){
        
            fichas[x][y]=f;
            fichas[f.getX()][f.getY()]= null;
        
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
    
    
         
>>>>>>> Stashed changes
    
=======

//    private Ficha[][] fichas;
//
//    public Tablero() {
//        this.fichas = new Ficha[8][8];
//    }
//    public void llenarTablero(){
//        for (int i = 0; i < 8; i++) {
//            fichas[1][i]= new Pawn(0,casi,"black",1,i);
//        }
//        for (int i = 0; i < 8; i++) {
//            fichas[6][i]= new Pawn(0,casi,"white",6,i);
//        }
//    }
//         
//    private Ficha[][] fichas;
//    private ArrayList<Ficha> eliminadas;
//
//    public Tablero() {
//        this.fichas = new Ficha[8][8];
//    }
//    public void llenarTablero(){
//        for (int i = 0; i < 8; i++) {
//            fichas[1][i]= new Pawn(0,"black",1,i);
//        }
//        for (int i = 0; i < 8; i++) {
//            fichas[6][i]= new Pawn(0,"white",6,i);
//        }
//        //....
//        
//    }
//    
//    public void Mover(Ficha f,int x, int y){
//        
//            fichas[x][y]=f;
//            fichas[f.getX()][f.getY()]= null;
//        
//    }
//    public void Eliminar(Ficha f, int x, int y){
//        fichas[f.getX()][f.getY()]= null;
//        eliminadas.add(f);
//    }
//
//    public Ficha[][] getFichas() {
//        return fichas;
//    }
//
//    public ArrayList<Ficha> getEliminadas() {
//        return eliminadas;
//    }
//
//    public void setFichas(Ficha[][] fichas) {
//        this.fichas = fichas;
//    }
//
//    public void setEliminadas(ArrayList<Ficha> eliminadas) {
//        this.eliminadas = eliminadas;
//    }
//    
//    
//         
//    
>>>>>>> Stashed changes
    
}
