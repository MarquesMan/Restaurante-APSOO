/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Conexao.Conectar();
        try {
            Statement stm = Conexao.con.createStatement();
            stm.executeUpdate("INSERT INTO mesa(status) VALUES ('"+status+"')");
            view.getMensagem().setText("Mesa inserida com sucesso");
            view.getStatus_mesa().setText("");
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
