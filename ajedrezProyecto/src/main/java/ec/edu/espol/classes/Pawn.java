/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.classes;

import javafx.scene.control.Alert;


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
            else if(Math.abs(this.getY()-y)==2){
                if(!(t.fichas[x][y+1] instanceof Casilla))
                    throw new NonValidMove("No puedes moverte encima de otra pieza.");
                System.out.println("lol mensaje secreto de Sumba");
                
            }
            
        }
        else
            if(y-this.getY()> difY ||y-this.getY()<0|| x-this.getX()!= 0)
                throw new NonValidMove("Movimiento fuera del rango de la pieza.");
            else if(Math.abs(this.getY()-y)==2){
                if(!(t.fichas[x][y-1] instanceof Casilla))
                    throw new NonValidMove("No puedes moverte encima de otra pieza.");
                
            }
        //Buscar al rey de this.color()    
        //verificas si está en jaque, si está en jaque tira la excepción.
        this.primerMovimiento = false;
        this.llegoAlFinal(x,y);
    }

    @Override
    public void capturar(Ficha f) throws NonValidMove{
        this.validarCaptura(f.getX(),f.getY());
        //this.t.getFichas()[this.getX()][this.getY()]= new Casilla(this.getX(),this.getY(),t);
        //this.t.getFichas()[f.getX()][f.getY()]=this;
        int newX = this.getX();
        int newY = this.getY();
        this.setX(f.getX());
        this.setY(f.getY());
        f.setX(newX);
        f.setY(newY); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public void validarCaptura(int x, int y) throws NonValidMove {
        int disX = Math.abs(this.getX()-x);
        System.out.println("validar Captura se ejecuta");
        int disY = this.getY()-y;
        if(this.getColor().equals(Equipo.NEGRAS))
            disY = -disY;
        if(!(disX == 1 && disY==1))
            throw new NonValidMove("Así no captura un peón, es muy obvio.");
//        for (int i = 0; i < 8; i++) {
//                            for (int j = 0; j < 8; j++) {
//                                Equipo color;
//                                if (t.fichas[i][j] instanceof King && !(((this.getColor()).equals(t.fichas[i][j].getColor()))) ) {
//                                    color = t.fichas[i][j].getColor();
//                                    King k= (King)t.fichas[i][j];
//                                    System.out.println("CUMPLE");
//                                    k.estaEnJaque(color); 
//                                        //TableroAjedrezController.mostrarMensaje("Estas en Jaque",c);
//                                        
//                                    }
//                                    
//                            }}
        this.llegoAlFinal(x,y);
    }
    public void llegoAlFinal(int x, int y ){
        if (this.getColor().equals(Equipo.BLANCAS)) {
            if (y==0) {
                Alert a = new Alert(Alert.AlertType.ERROR,"A coronar");                   
                a.show();
            }
            
        }
        else {
            if (y==7) {
                Alert a = new Alert(Alert.AlertType.ERROR,"A coronar");                   
                a.show();
            }
        }
        
    }
    }
                                
                    
    

