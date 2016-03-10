/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Conexao;
import view.ClienteView;

/**
 *
 * @author pet
 */
public class GerenciarClientes implements ActionListener{
    
    protected ClienteView view;
    private final Conexao db;
    private final DecimalFormat floatFormat = new DecimalFormat("0.00");
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public GerenciarClientes(ClienteView view) {
        this.view = view;
        this.db = new Conexao();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand() ){
            case "Limpar":
                LimparCamposCliente();
                break;
            case "Salvar":
                salva_cliente();
                break;
            case "Pesquisar":
                lista_clientes();
                break;
            default:
                System.out.println(e.getActionCommand() );
                break;
        }
    }

    private void LimparCamposCliente() {
        view.getInputCliente_Nome().setText("");
        view.getInputCliente_Cpf().setText("");
        view.getInputCliente_Telefone().setText("");
        view.getInputCliente_Rua().setText("");
        view.getInputCliente_Numero().setText("");
        view.getInputCliente_Bairro().setText("");
        view.getInputCliente_Cidade().setText("");
        view.getInputCliente_Data().setText("");
        view.getInputCliente_Codigo().setText("");
        Date date = new Date();
        view.getInputCliente_Data().setText(dateFormat.format(date));
        clear_row((DefaultTableModel) view.getjTable1().getModel());
    }

    private void salva_cliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void lista_clientes() {
        String where = "";
        DefaultTableModel row = (DefaultTableModel) view.getjTable1().getModel();
        int rowCount = row.getRowCount();

        clear_row(row);
        
        String pesquisa = view.getInputPesquisa_Cliente().getText();
        if(!"".equals(pesquisa)){
            where = "WHERE nome like '%"+pesquisa+"%' or cpf LIKE '%"+pesquisa+"%'";
        }
        ResultSet query = db.query("SELECT * FROM cliente INNER JOIN pessoa ON  cliente.idpessoa = pessoa.idpessoa "+ where);
        
        try {
            while(query.next()){
                row.addRow(new Object[]{query.getInt("idcliente"), query.getString("nome"), query.getString("cpf")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void clear_row(DefaultTableModel table) {
        int rowCount = table.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            table.removeRow(i);
        }
    }
    
    public void setCliente_values(int index){
        String where = "";
        String pesquisa = view.getInputPesquisa_Cliente().getText();
        
        DefaultTableModel row = (DefaultTableModel) view.getjTable1().getModel();
        view.getInputCliente_Nome().setText(row.getValueAt(index, 0).toString());
        
        if(!"".equals(pesquisa)){
            where = "WHERE nome like '%"+pesquisa+"%' or cpf LIKE '%"+pesquisa+"%'";
        }
        
        ResultSet query = db.query("SELECT * FROM cliente INNER JOIN pessoa ON  cliente.idpessoa = pessoa.idpessoa "+ where);
        
        try {
            if(query.next()){
                view.getInputCliente_Nome().setText(query.getString("nome"));
                view.getInputCliente_Cpf().setText(query.getString("cpf"));
                view.getInputCliente_Telefone().setText(query.getString("telefone"));
                view.getInputCliente_Rua().setText(query.getString("rua"));
                view.getInputCliente_Numero().setText(query.getString("numero"));
                view.getInputCliente_Bairro().setText(query.getString("bairro"));
                view.getInputCliente_Cidade().setText(query.getString("cidade"));
                view.getInputCliente_Data().setText(dateFormat.format(query.getString("data")));
                view.getInputCliente_Codigo().setText(query.getString("idpessoa"));
            }     
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
