/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Conexao;
import view.PedidoView;


/**
 *
 * @author pet
 */
public class GerenciarPedidos  implements ActionListener{
   
    protected PedidoView view;
    private final Conexao db;
    private final DecimalFormat floatFormat = new DecimalFormat("0.00");
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public GerenciarPedidos(PedidoView view) {
        this.view = view;
        this.db = new Conexao();
    }
    
    //Identifica os eventos dos botões e xecuta a açao correspondente
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand() ){
        
            case "Finalizar":
                System.out.println("Foi");
                break;
            case "Salvar":
                salva_pedido();
                break;
            case "Pesquisar":
                int index_p = view.getMetodoPesquisaPedido().getSelectedIndex();
                
                if(0 == index_p)
                    lista_clientes();
                else if(1 == index_p)
                    lista_menu();
                
                break;
            case "Limpar":
                limparCamposPedido();            
                break;
            case "comboBoxChanged":
                int index = view.getMetodoPesquisaPedido().getSelectedIndex();
                
                switch (index) {
                    case 0:
                        view.getLabelPedido_MetodoPesquisa().setText("Cliente:");
                        break;
                    case 1:
                        view.getLabelPedido_MetodoPesquisa().setText("Produtos:");
                        break;
                    default:
                        view.getLabelPedido_MetodoPesquisa().setText("Mesa:");
                        break;
                }
              
                break;
            case "Remover":
                removeSelectedProduct((DefaultTableModel) view.getTabelaPedido_Produtos().getModel());
                break;
            default:
                System.out.println(e.getActionCommand() );
                break;
        }
            
    }
    
    public void limparCamposPedido(){
        view.getInputPedido_Cliente().setText("");
        view.getInputPedido_Data().setText("");
        view.getInputPedido_Desconto().setValue(new BigDecimal("0.00"));
        view.getInputPedido_Mesa().setText("");
        view.getInputPedido_Preco().setValue(new BigDecimal("0.00"));
        view.getInputPedido_Pago().setValue(new BigDecimal("0.00"));
        view.getInputPedido_Troco().setValue(new BigDecimal("0.00"));
        Date date = new Date();
        view.getInputPedido_Data().setText(dateFormat.format(date));
        clear_row((DefaultTableModel) view.getTabelaPedido_Produtos().getModel());
    }
    
    //Lista os clientes na Tabela Pesquisa
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
    
    //Lista os itens do menu na Tabela Pesquisa
    public void lista_menu(){
        String where = "";
        view.getTabelaPedido_Pesquisa().setTabelaProduto(); //Deixa a tabela no formato do produto
        DefaultTableModel row = (DefaultTableModel) view.getTabelaPedido_Pesquisa().getModel();
        
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
    
    //Pega os valores do cliente na Tabela de Pesquisa e insere seu codigo no campo Cliente do pedido
    public void setCliente_values(int index){
        DefaultTableModel row = (DefaultTableModel) view.getTabelaPedido_Pesquisa().getModel();
        view.getInputPedido_Cliente().setText(row.getValueAt(index, 0).toString());
    }
    
    //Limpa todas as linhas de uma tabela
    protected void clear_row(DefaultTableModel table){
        int rowCount = table.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            table.removeRow(i);
        }
    }

    //Pega o produto da Tabela de Pesquisa e passa para a tabela de Produdos do pedido
    //somando o valor do preço total
    public void setProdutosOnTable(int index) {
        
        String nomeProduto,
               precoProduto,
               codigoProduto;
        
        Float precoProdutoFloat,
              precoTotalFloat;
        
        Boolean disponivel;
        
        DefaultTableModel tablePesquisa = (DefaultTableModel) view.getTabelaPedido_Pesquisa().getModel();
        DefaultTableModel tableProduto = (DefaultTableModel) view.getTabelaPedido_Produtos().getModel();
        
        
        disponivel = Boolean.valueOf(tablePesquisa.getValueAt(index, 3).toString());

        //Se o Produdo não estiver disponivel não faz coloca ele no pedido
        if(!disponivel)
            return;
        
        codigoProduto = tablePesquisa.getValueAt(index, 0).toString();
        nomeProduto = tablePesquisa.getValueAt(index, 1).toString();    
        precoProduto =  tablePesquisa.getValueAt(index, 2).toString();//0,00
        precoProdutoFloat =  Float.parseFloat(tablePesquisa.getValueAt(index, 2).toString().replace(",", "."));       

        
        precoTotalFloat = view.getInputPedido_Preco().getValue().floatValue() + precoProdutoFloat;
        view.getInputPedido_Preco().setValue(new BigDecimal(Float.toString(precoTotalFloat)));
        
        tableProduto.addRow(new Object[]{codigoProduto,nomeProduto,precoProduto,false});  
        
    }
    

    //Remove da Tabela de Produdos do Pedidos os produtos marccados como remover
    public void removeSelectedProduct(DefaultTableModel table){
        int rowCount = table.getRowCount();
        Float precoProdutoFloat,
              precoTotalFloat;  

        
        for (int i = rowCount - 1; i >= 0; i--) {
            
            if(Boolean.valueOf(table.getValueAt(i, 3).toString())){
                precoProdutoFloat =  Float.parseFloat(table.getValueAt(i, 2).toString().replace(",", "."));
                precoTotalFloat = view.getInputPedido_Preco().getValue().floatValue() - precoProdutoFloat;
                view.getInputPedido_Preco().setValue(new BigDecimal(Float.toString(precoTotalFloat)));
                calcula_troco();
                table.removeRow(i);
            }            
        }
    }
     
    
    public void salva_pedido(){
        int cliente, funcionario, mesa;
        float pagamento, troco;
        String data;
        
        if(   "".equals(view.getInputPedido_Cliente().getText())
           || "".equals(view.getInputPedido_Mesa().getText())){
            return;
        }

        cliente = Integer.parseInt(view.getInputPedido_Cliente().getText());
        funcionario = 1;
        mesa = Integer.parseInt(view.getInputPedido_Mesa().getText());
        data = view.getInputPedido_Data().getText();
        pagamento = view.getInputPedido_Pago().getValue().floatValue();
        troco = view.getInputPedido_Troco().getValue().floatValue();
        
        SimpleDateFormat from = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat to = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            
            date = from.parse(data); // 01/02/2014
            String mysqlString = to.format(date);     // 2014-02-01
      
            int id_pedido = db.query_insert("pedido", "idcliente, idfuncionario, idmesa, data, pagamento, troco",
                            cliente+", "+funcionario+", "+mesa+", '"+mysqlString+"', "+pagamento+", "+troco);
        
            //Erro na inserção
            if(id_pedido == 0){
                return;
            }
        
            DefaultTableModel tabela_produtos = (DefaultTableModel) view.getTabelaPedido_Produtos().getModel();
            int rowCount = tabela_produtos.getRowCount();
     
            for(int i = 0; i < rowCount; i++){
                int iditem_menu = Integer.parseInt(tabela_produtos.getValueAt(i, 0).toString());
            
                db.query_insert("itens_pedidos", "idpedido, iditem_menu", id_pedido+", "+iditem_menu);
            }
            
            limparCamposPedido();
            
        } catch (ParseException ex) {
            Logger.getLogger(GerenciarPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }
    
    public void calcula_troco(){
        float troco, pago, total, desconto;
        
        desconto = view.getInputPedido_Desconto().getValue().floatValue();
        pago = view.getInputPedido_Pago().getValue().floatValue();
        total = view.getInputPedido_Preco().getValue().floatValue();
        
        if(pago > (total-desconto)){
            troco =  pago - (total - desconto);
            view.getInputPedido_Troco().setValue(new BigDecimal(troco));
        }
        else{
            view.getInputPedido_Troco().setValue(new BigDecimal("0.00"));
        }
    }
    
}
