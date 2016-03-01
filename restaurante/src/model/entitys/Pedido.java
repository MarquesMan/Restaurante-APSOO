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
public class Pedido {
    
    private int idpedido;
    private Cliente idcliente;
    private Funcionario idfuncionario;
    private Mesa idmesa;
    private String data;
    private boolean pagamento;
    private float troco;

    public Pedido(int idpedido, Cliente idcliente, Funcionario idfuncionario, Mesa idmesa, String data, boolean pagamento, float troco) {
        this.idpedido = idpedido;
        this.idcliente = idcliente;
        this.idfuncionario = idfuncionario;
        this.idmesa = idmesa;
        this.data = data;
        this.pagamento = pagamento;
        this.troco = troco;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public Funcionario getIdfuncionario() {
        return idfuncionario;
    }

    public Mesa getIdmesa() {
        return idmesa;
    }

    public String getData() {
        return data;
    }

    public boolean isPagamento() {
        return pagamento;
    }

    public float getTroco() {
        return troco;
    }
    
}
