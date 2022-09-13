/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author mpisc
 */
public class Caneta {
    public String marca;
    public String modelo;
    public String cor;
    public float preco;
    
    public void escrever(String msg) {
        System.out.println("a caneta está escrevendo " + msg );
    }
    
    public void pintar() {
        System.out.println("a caneta está pintando...");
    }
    
    public void desenhar(String figura) {
        System.out.println("a caneta está desenhando a figura " + figura);
    }
}
