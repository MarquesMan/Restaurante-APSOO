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
public class Cliente extends Pessoa{
    
    private final int idcliente;
    private final String data_cadastro;

    public Cliente(int idcliente, String data_cadastro, int idpessoa, String nome, String cpf, String telefone) {
        super(idpessoa, nome, cpf, telefone);
        this.idcliente = idcliente;
        this.data_cadastro = data_cadastro;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }
    
}
