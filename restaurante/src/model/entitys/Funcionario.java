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
public class Funcionario extends Pessoa{
    
    private final int idfuncionario;
    private final String data_admissao;
    private final String cargo;
    private final String usuario_sistema;
    private final String senha_sistema;
    private final boolean ativo; 

    public Funcionario(int idfuncionario, String data_admissao, String cargo, String usuario_sistema, String senha_sistema, boolean ativo, int idpessoa, String nome, String cpf, String telefone) {
        super(idpessoa, nome, cpf, telefone);
        this.idfuncionario = idfuncionario;
        this.data_admissao = data_admissao;
        this.cargo = cargo;
        this.usuario_sistema = usuario_sistema;
        this.senha_sistema = senha_sistema;
        this.ativo = ativo;
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
