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
public class Itens_pedidos {
    
    private int iditens_pedidos;
    private Pedido idpedido;
    private Menu iditem_menu;

    public Itens_pedidos(int iditens_pedidos, Pedido idpedido, Menu iditem_menu) {
        this.iditens_pedidos = iditens_pedidos;
        this.idpedido = idpedido;
        this.iditem_menu = iditem_menu;
    }

    public int getIditens_pedidos() {
        return iditens_pedidos;
    }

    public Pedido getIdpedido() {
        return idpedido;
    }

    public Menu getIditem_menu() {
        return iditem_menu;
    }
    
}
