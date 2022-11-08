/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prjaberturas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mpisc
 */
public class PrjAberturas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Porta> portas = new ArrayList<>();
        portas.add(new Correr());
        portas.add(new Giratoria());
        portas.add(new Correr());
        portas.add(new Basculante());
        
        //print(portas);
        abrir(portas);
        fechar(portas);
    }
    
    public static void print(List<Porta> portas) {
        for (Porta p : portas) {
            System.out.println("Portas: " + p.getClass().getSimpleName());
        }
    }

    public static void abrir(List<Porta> portas) {
        for (Porta p : portas) {
            System.out.println("Portas: " + p.getClass().getSimpleName());
            p.abrir();
            System.out.println("");
        }
    }
    
    public static void fechar(List<Porta> portas) {
        for (Porta p : portas) {
            System.out.println("Portas: " + p.getClass().getSimpleName());
            p.fechar();
            System.out.println("");
        }
    }    
    
}
