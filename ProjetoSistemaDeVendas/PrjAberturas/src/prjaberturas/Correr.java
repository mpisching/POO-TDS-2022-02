/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjaberturas;

/**
 *
 * @author mpisc
 */
public class Correr extends Porta{
    @Override
    public void abrir() {
        System.out.println("Abrindo porta correr...");
    }

    @Override
    public void fechar() {
        System.out.println("Fechando porta correr...");
    }    
    
    @Override
    public void travar() {
        System.out.println("travando porta correr");
    }

    @Override
    public void destravar() {
        System.out.println("destravando porta correr");
    }    
}
