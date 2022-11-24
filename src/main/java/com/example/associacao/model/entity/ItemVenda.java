/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.associacao.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
@Entity

public class ItemVenda implements Serializable{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private double qtd;

    @OneToOne
    private Produto produto;

    @ManyToOne
    private Venda venda;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }
    
     
     public double total(){
        return produto.getValor() * qtd;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "ItemVenda{" +
                "id=" + id +
                ", qtd=" + qtd +
                ", produto=" + produto +
                ", venda=" + venda +
                '}';
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
