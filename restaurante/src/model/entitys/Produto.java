/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entitys;

/**
 *
 * @author pet
 */
public class Produto {
    
    private int idproduto;
    private String nome;
    private Categoria idcategoria;
    private int quantidade_estoque;

    public Produto(int idproduto, String nome, Categoria idcategoria, int quantidade_estoque) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.idcategoria = idcategoria;
        this.quantidade_estoque = quantidade_estoque;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }
    
}
