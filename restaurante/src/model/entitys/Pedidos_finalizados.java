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
public class Pedidos_finalizados {
    
    private int idpedido_finalizado;
    private Cliente idcliente;
    private Funcionario idfuncionario;
    private Mesa idmesa;
    private String data;
    private boolean pagamento;
    private float troco;
    private float total;

    public Pedidos_finalizados(int idpedido_finalizado, Cliente idcliente, Funcionario idfuncionario, Mesa idmesa, String data, boolean pagamento, float troco, float total) {
        this.idpedido_finalizado = idpedido_finalizado;
        this.idcliente = idcliente;
        this.idfuncionario = idfuncionario;
        this.idmesa = idmesa;
        this.data = data;
        this.pagamento = pagamento;
        this.troco = troco;
        this.total = total;
    }

    public int getIdpedido_finalizado() {
        return idpedido_finalizado;
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

    public float getTotal() {
        return total;
    }
    
}
