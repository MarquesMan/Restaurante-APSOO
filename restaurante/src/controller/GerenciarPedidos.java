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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Conexao;
import view.RestauranteView;

/**
 *
 * @author pet
 */
public class GerenciarPedidos  implements ActionListener{
   
    protected RestauranteView view;
    private final Conexao db;
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand() ){
        
            case "Finalizar":
                System.out.println("Foi");
                break;
            case "Salvar":
                System.out.println("Foi");
                break;
            case "Pesquisar":
                int index_p = view.getMetodoPesquisaPedido().getSelectedIndex();
                
                if(0 == index_p)
                    lista_clientes();
                else if(1 == index_p)
                    lista_menu();
                
                break;
            case "Limpar":
                view.getInputPedido_Cliente().setText("");
                view.getInputPedido_Data().setText("");
                view.getInputPedido_Desconto().setText("");
                view.getInputPedido_Mesa().setText("");
                view.getInputPedido_Preço().setText("");
                view.getInputPedido_Troco().setText("");
                break;
            case "comboBoxChanged":
                int index = view.getMetodoPesquisaPedido().getSelectedIndex();
                if(index==0){
                    view.getLabelPedido_MetodoPesquisa().setText("Cliente:");
                }else if(index==1){
                    view.getLabelPedido_MetodoPesquisa().setText("Produtos:");
                }else{
                    view.getLabelPedido_MetodoPesquisa().setText("Mesa:");
                }
              
                break;
            default:
                System.out.println(e.getActionCommand() );
                break;
        }
            
    }

    public GerenciarPedidos(RestauranteView view) {
        this.view = view;
        this.db = new Conexao();
    }
    
    public void lista_clientes(){

        String where = "";
        DefaultTableModel row = (DefaultTableModel) view.getTabelaPedido_Pesquisa().getModel();
        int rowCount = row.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            row.removeRow(i);
        }
        
        String pesquisa = view.getInputPesquisa_Pedido().getText();
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
    
    public void lista_menu(){
        String where = "";
        DefaultTableModel row = (DefaultTableModel) view.getTabelaPedido_Pesquisa().getModel();
        
        clear_row(row);
        row.setColumnCount(0);
        
        row.addColumn("Código");
        row.addColumn("Nome");
        row.addColumn("Preço");
        row.addColumn("Disponivel");
        
        String pesquisa = view.getInputPesquisa_Pedido().getText();
        if(!"".equals(pesquisa)){
            where = "WHERE nome_produto like '%"+pesquisa+"%' or iditem_menu LIKE '%"+pesquisa+"%'";
        }
        ResultSet query = db.query("SELECT * FROM menu "+ where);
        
        try {
            while(query.next()){
                row.addRow(new Object[]{query.getInt("iditem_menu"), query.getString("nome_produto"), query.getString("preco"), query.getString("disponibilidade")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void setCliente_values(int index){
        DefaultTableModel row = (DefaultTableModel) view.getTabelaPedido_Pesquisa().getModel();
        view.getInputPedido_Cliente().setText(row.getValueAt(index, 0).toString());
    }
    
    
    protected void clear_row(DefaultTableModel table){
        int rowCount = table.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            table.removeRow(i);
        }
    }
     
    
    
}
