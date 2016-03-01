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
public class Cliente {
    
    private Pessoa idpessoa;
    private int idcliente;
    private String data_cadastro;

    public Cliente(Pessoa idpessoa, int idcliente, String data_cadastro) {
        this.idpessoa = idpessoa;
        this.idcliente = idcliente;
        this.data_cadastro = data_cadastro;
    }

    public Pessoa getIdpessoa() {
        return idpessoa;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }
    
}
