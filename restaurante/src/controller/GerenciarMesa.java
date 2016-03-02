/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Conexao;
import view.NovoPedido;

/**
 *
 * @author gabryelR
 */
public class GerenciarMesa implements ActionListener{
    NovoPedido view;
    
    public GerenciarMesa(NovoPedido view){
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String status;
        status = view.getStatus_mesa().getText();
        Conexao inserir = new Conexao();
        
        if (inserir.query_update("mesa", "status", status)){
            view.getMensagem().setText("Mesa inserida com sucesso");
            view.getStatus_mesa().setText("");
        }
        else{
            view.getMensagem().setText("Erro ao inserir a mesa. Por favor tente novamente");
        }
    }
    
}
