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
public class Funcionario {
    
    private Pessoa idpessoa;
    private int idfuncionario;
    private String data_admissao;
    private String cargo;
    private String usuario_sistema;
    private String senha_sistema;
    private boolean ativo; 

    public Funcionario(Pessoa idpessoa, int idfuncionario, String data_admissao, String cargo, String usuario_sistema, String senha_sistema, boolean ativo) {
        this.idpessoa = idpessoa;
        this.idfuncionario = idfuncionario;
        this.data_admissao = data_admissao;
        this.cargo = cargo;
        this.usuario_sistema = usuario_sistema;
        this.senha_sistema = senha_sistema;
        this.ativo = ativo;
    }

    public Pessoa getIdpessoa() {
        return idpessoa;
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public String getData_admissao() {
        return data_admissao;
    }

    public String getCargo() {
        return cargo;
    }

    public String getUsuario_sistema() {
        return usuario_sistema;
    }

    public String getSenha_sistema() {
        return senha_sistema;
    }

    public boolean isAtivo() {
        return ativo;
    }
    
}
