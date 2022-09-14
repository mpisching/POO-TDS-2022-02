/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.app;

import br.edu.ifsc.fln.domain.model.Categoria;
import br.edu.ifsc.fln.domain.model.Produto;
import java.math.BigDecimal;

/**
 *
 * @author mpisc
 */
public class MainApp {
    public static void main(String[] args) {
        Produto p1 = new Produto();
        p1.setId(10);
        p1.setNome("Bermuda");
        p1.setDescricao("Bermuda Jeans");
        p1.setPreco(new BigDecimal(10.0));
        
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
        
    }
}
