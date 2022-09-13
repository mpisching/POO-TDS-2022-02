/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import entity.Caneta;

/**
 *
 * @author mpisc
 */
public class MainApp {
    public static void main(String[] args) {
        Caneta caneta1 = new Caneta();
        caneta1.cor = "Azul";
        caneta1.marca = "Faber Castell";
        caneta1.modelo = "Esferográfica";
        caneta1.preco = 3.00F;
        caneta1.pintar();
        
        Caneta caneta2 = null;
        caneta2 = new Caneta();
        caneta2.escrever("Aula de programação orientada a objetos");
        
        caneta2.cor = "Preta";
        caneta2.marca = "BIC";
        caneta2.modelo = "Esferográfica";
        caneta2.preco = 2.00F;

        
        Caneta caneta3 = caneta2;
        caneta3.cor = "Vermelha";
        
        print(caneta1);
        print(caneta2);
        print(caneta3);
        
    }

    private static void print(Caneta caneta) {
        System.out.println("Dados da caneta" );
        System.out.println("Marca.....: " + caneta.marca);
        System.out.println("Modelo....: " + caneta.modelo);
        System.out.println("Cor.......: " + caneta.cor);
        System.out.println("Preço.....: R$ " + caneta.preco);
    }
}
