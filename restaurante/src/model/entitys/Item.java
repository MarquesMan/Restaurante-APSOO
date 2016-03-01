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
public class Item {
    
    private Produto idproduto;
    private int iditem;
    private String data_validade;
    private String lote;
    private int quantidade_estoque;
    private String marca;
    private float preco;

    public Item(Produto idproduto, int iditem, String data_validade, String lote, int quantidade_estoque, String marca, float preco) {
        this.idproduto = idproduto;
        this.iditem = iditem;
        this.data_validade = data_validade;
        this.lote = lote;
        this.quantidade_estoque = quantidade_estoque;
        this.marca = marca;
        this.preco = preco;
    }

    public Produto getIdproduto() {
        return idproduto;
    }

    public int getIditem() {
        return iditem;
    }

    public String getData_validade() {
        return data_validade;
    }

    public String getLote() {
        return lote;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public String getMarca() {
        return marca;
    }
    
    public float getPreco(){
        return preco;
    }
}
