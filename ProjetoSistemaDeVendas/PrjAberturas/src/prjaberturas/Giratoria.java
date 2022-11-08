/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjaberturas;

/**
 *
 * @author mpisc
 */
public class Giratoria extends Porta {
    public void fechar() {
        System.out.println("fechando porta giratória....");
    }

    @Override
    public void abrir() {
        System.out.println("abrindo porta Giratória....");
    }

    @Override
    public void travar() {
        System.out.println("travando porta giratoria");
    }

    @Override
    public void destravar() {
        System.out.println("destravando porta giratoria");
    }
}
