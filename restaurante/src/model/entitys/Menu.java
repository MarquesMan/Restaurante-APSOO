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
public class Menu {
    
    private int iditem_menu;
    private String nome_produto;
    private String ingredientes;
    private Categoria idcategoria;
    private float preco;
    private float preco_producao;
    private boolean disponibilidade;

    public Menu(int iditem_menu, String nome_produto, String ingredientes, Categoria idcategoria, float preco, float preco_producao, boolean disponibilidade) {
        this.iditem_menu = iditem_menu;
        this.nome_produto = nome_produto;
        this.ingredientes = ingredientes;
        this.idcategoria = idcategoria;
        this.preco = preco;
        this.preco_producao = preco_producao;
        this.disponibilidade = disponibilidade;
    }

    public int getIditem_menu() {
        return iditem_menu;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public float getPreco() {
        return preco;
    }

    public float getPreco_producao() {
        return preco_producao;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }
    
}
