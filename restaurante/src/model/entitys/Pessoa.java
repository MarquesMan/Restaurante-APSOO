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
public class Pessoa {
    
    private int idpessoa;
    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa(int idpessoa, String nome, String cpf, String telefone) {
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    
    
}
