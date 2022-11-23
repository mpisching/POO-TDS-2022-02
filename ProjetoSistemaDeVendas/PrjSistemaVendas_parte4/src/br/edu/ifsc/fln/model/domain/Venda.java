/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.model.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mpisc
 */
public class Venda {
    private int id;
    private LocalDate data;
    private BigDecimal total;
    private boolean pago;
    private double taxaDesconto;
    private static String empresa;
    
    private EStatusVenda statusVenda;
    
    private List<ItemDeVenda> itensDeVenda;
    private Cliente cliente;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getTotal() {
        return total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public double getTaxaDesconto() {
        return taxaDesconto;
    }
    
    public void setTaxaDesconto(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public static String getEmpresa() {
        return empresa;
    }

    public static void setEmpresa(String empresa) {
        Venda.empresa = empresa;
    }
    
    public EStatusVenda getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(EStatusVenda statusVenda) {
        this.statusVenda = statusVenda;
    }

    public List<ItemDeVenda> getItensDeVenda() {
        return itensDeVenda;
    }

    public void setItensDeVenda(List<ItemDeVenda> itensDeVenda) {
        this.itensDeVenda = itensDeVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void add(ItemDeVenda itemVenda) {
        if (itensDeVenda == null) {
            itensDeVenda = new ArrayList<>();
        }
        itensDeVenda.add(itemVenda);
        itemVenda.setVenda(this);
    }
    
    public void remove(ItemDeVenda itemVenda) {
        itensDeVenda.remove(itemVenda);
    }
    
    public BigDecimal calcularTotalVenda() {
        //TODO fazer o calculo com base nos itens de venda
        return null;
        
    }
    
    public BigDecimal calcularTotalVenda(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
        total = calcularTotalVenda();
        total.subtract(new BigDecimal(total.doubleValue() * taxaDesconto / 100.0));
        return total;
    }
    
}
