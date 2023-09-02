/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ec.edu.espol.classes;

/**
 *
 * @author japolo15
 */
public enum Equipo {
    BLANCAS,NEGRAS;

    @Override
    public String toString() {
        if (this.equals(Equipo.BLANCAS))
                return "Blancas";
        else
            return "Negras";
    }
    
}
