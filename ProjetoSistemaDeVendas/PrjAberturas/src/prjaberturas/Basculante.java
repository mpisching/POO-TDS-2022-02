/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjaberturas;

/**
 *
 * @author mpisc
 */
public class Basculante extends Porta {

    @Override
    public void abrir() {
        System.out.println("Abrindo porta basculante...");
    }

    @Override
    public void fechar() {
        System.out.println("Fechando porta basculante...");
    }
    
    @Override
    public void travar() {
        System.out.println("travando porta basculante");
    }

    @Override
    public void destravar() {
        System.out.println("destravando porta basculante");
    }    
}
