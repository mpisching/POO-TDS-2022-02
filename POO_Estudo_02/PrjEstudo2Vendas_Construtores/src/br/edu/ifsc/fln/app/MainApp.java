/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.app;

import br.edu.ifsc.fln.domain.model.Categoria;
import br.edu.ifsc.fln.domain.model.Produto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mpisc
 */
public class MainApp {
    public static void main(String[] args) {
        int i = 10;
        int[] v = new int[10];
        Produto[] vetor = new Produto[5];
        vetor[2] = new Produto();
        vetor[2].setNome("camisa");
        
        List<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto("Agua mineral"));
        listaProdutos.add(vetor[2]);
        
        Produto p1 = new Produto("Bermuda");//método construtor de classe
        listaProdutos.add(p1);
        p1.setId(10);
        p1.setDescricao("Bermuda Jeans");
        p1.setPreco(new BigDecimal(10.0));
        
        Produto p2 = new Produto("Perfume", "Pefume sei lá");
        
        Categoria c1 = new Categoria();
        c1.setId(1);
        c1.setDescricao("Vestuario");
        //System.out.println("Categoria: " + c1 );
        Categoria c2 = new Categoria();
        c2.setId(2);
        c2.setDescricao("Acessorios");
        //System.out.println("Categoria: " + c2 );
        p1.setCategoria(c1);
        
        System.out.println("Produto: " + p1);
        System.out.println("Categoria do produto: "
                + p1.getCategoria().getDescricao());
        
        print(listaProdutos);
        listaProdutos.remove(p1);
        System.out.println("====");
        print(listaProdutos);
        
    }

    private static void print(List<Produto> listaProdutos) {
        for (Produto p: listaProdutos) {
            System.out.println("Produto: " + p);
        } 
        //o for aprimorado acima pode ser implementado da forma abaixo
//        for (int i = 0; i < listaProdutos.size(); i++) {
//            Produto p = listaProdutos.get(i);
//            System.out.println("Produto: " + p);
//        }
    }
}
