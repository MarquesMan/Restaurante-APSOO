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
import view.RestauranteView;

/**
 *
 * @author pet
 */
public class GerenciarPedidos  implements ActionListener{
   
    protected RestauranteView view;
    private final Conexao db;
    private DecimalFormat floatFormat = new DecimalFormat("0.00");
    
    
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
                view.getInputPedido_Preço().setText("0.00");
                view.getInputPedido_Troco().setText("");
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                view.getInputPedido_Data().setText(dateFormat.format(date));
                clear_row((DefaultTableModel) view.getTabelaPedido_Produtos().getModel());
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
        
        view.getTabelaPedido_Pesquisa().setTabelaCliente(); 
        
        String where = "";
        DefaultTableModel row = (DefaultTableModel) view.getTabelaPedido_Pesquisa().getModel();
        int rowCount = row.getRowCount();

        clear_row(row);
        
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
        view.getTabelaPedido_Pesquisa().setTabelaProduto(); 
        DefaultTableModel row = (DefaultTableModel) view.getTabelaPedido_Pesquisa().getModel();
        
       
       
        
        //view.getTabelaPedido_Pesquisa().repaint();
        
        String pesquisa = view.getInputPesquisa_Pedido().getText();
        if(!"".equals(pesquisa)){
            where = "WHERE nome_produto like '%"+pesquisa+"%' or iditem_menu LIKE '%"+pesquisa+"%'";
        }
        ResultSet query = db.query("SELECT * FROM menu "+ where);
        
        try {
            while(query.next()){ 
                String preco = floatFormat.format(query.getObject("preco"));// 0,00
                
                row.addRow(new Object[]{query.getInt("iditem_menu"), query.getString("nome_produto"),preco , query.getBoolean("disponibilidade")});
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

    public void setProdutosOnTable(int index) {
        
        String nomeProduto,
               precoProduto;
        
        Float precoProdutoFloat,
              precoTotalFloat;
        
        Boolean disponivel;
        
        DefaultTableModel tablePesquisa = (DefaultTableModel) view.getTabelaPedido_Pesquisa().getModel();
        DefaultTableModel tableProduto = (DefaultTableModel) view.getTabelaPedido_Produtos().getModel();
        
        disponivel = Boolean.valueOf(tablePesquisa.getValueAt(index, 3).toString());

        if(!disponivel)
            return;
        
        nomeProduto = tablePesquisa.getValueAt(index, 1).toString();    
        
        precoProduto =  tablePesquisa.getValueAt(index, 2).toString();//0,00
        
        precoProdutoFloat =  Float.parseFloat(tablePesquisa.getValueAt(index, 2).toString().replace(",", "."));
        

        
        precoTotalFloat = Float.parseFloat(view.getInputPedido_Preço().getText().replace(",", ".")) + precoProdutoFloat;
        
      
        view.getInputPedido_Preço().setText( floatFormat.format(precoTotalFloat));
      
        
        tableProduto.addRow(new Object[]{nomeProduto,precoProduto,false});     
        
    }
     
    
    
}
