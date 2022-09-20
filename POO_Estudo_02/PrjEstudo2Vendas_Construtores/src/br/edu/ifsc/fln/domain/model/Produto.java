/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.domain.model;

import java.math.BigDecimal;


/**
 *
 * @author mpisc
 */
public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    //Relação de associação da classe Produto com a classe Categoria
    private Categoria categoria;

    /**
     * Método construtor da classe Produto - o método
     * serve para construir objetos Produto
     */
    public Produto() {
        
    }
    
    /**
     * Método para construir objetos Produto com o nome pre-definido
     * @param nome - é nome do produto
     */
    public Produto(String nome) {
        this.nome = nome;
    }
    
    public Produto(String nome, String descricao)  {
        //this(nome);
        this(nome);
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void setPreco(BigDecimal preco) {
        if (preco.doubleValue() >= 0.0) {
            this.preco = preco;
        }
    }
    
    public BigDecimal getPreco() {
        return preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", categoria=" + categoria + '}';
    }




}
