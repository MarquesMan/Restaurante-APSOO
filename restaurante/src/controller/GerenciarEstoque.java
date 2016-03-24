/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static java.util.Date.from;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexao;
import view.EstoqueView;

/**
 *
 * @author Leonardo
 */
public class GerenciarEstoque {
    
    protected EstoqueView view;
    private final Conexao db;
    private final DecimalFormat floatFormat = new DecimalFormat("0.00");
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Calendar today = Calendar.getInstance();
    
    public GerenciarEstoque(EstoqueView view) {
        this.view = view;
        this.db = Conexao.getConnection();
        Date date = new Date();
        today.set(Calendar.HOUR_OF_DAY, 0); // same for minutes and seconds
    }
    
    public void LimparProduto(){
        view.getInputProduto_Nome().setText("");
        view.getInputProduto_Quantidade().setText("");
        view.getSelectProduto_Categoria().setSelectedIndex(0);
        view.getInputProduto_Codigo().setText("");
    }
    
    public void LimparItem(){
        view.getInputItem_Lote().setText("");
        view.getInputItem_Produto().setText("");
        view.getInputItem_Quantidade().setText("");
        view.getInputItem_Validade().setSelectedDate(today);
        view.getInputItem_Codigo().setText("");
        view.getInputItem_Marca().setText("");
        view.getInputItem_Preco().setValue(new BigDecimal("0.00"));
    }
    
    public void LimparPesquisa(){
        view.getSelectPesquisa().setSelectedIndex(0);
        view.getInputPesquisa_Nome().setText("");
        view.getInputPesquisa_Lote().setText("");
        view.getSelectPesquisa_Categoria().setSelectedIndex(0);
         view.getInputPesquisa_Validade().setSelectedDate(today);
    }
    
    public void SalvarProduto(){
        String nome, categoria;
        int quantidade, codigo;
        
        String where = "";
        
        if("".equals(view.getInputProduto_Nome().getText())
            || "".equals(view.getInputProduto_Quantidade().getText())){
            
            return;
        }
        
        nome = view.getInputProduto_Nome().getText();
        categoria = view.getSelectProduto_Categoria().getSelectedItem().toString();
        quantidade = Integer.parseInt(view.getInputProduto_Quantidade().getText());
        
        if(!"".equals(categoria)){
                    where = "WHERE nome like '%"+categoria+"%'";
                }
        ResultSet query = db.query("SELECT idcategoria FROM categoria "+ where); //retorna idcategoria
                
        if("".equals(view.getInputProduto_Codigo().getText())){    
            try {
                if(query.next()){
                    db.query_insert("produto", "nome, idcategoria, quantidade_estoque", "'"+nome+"'," +query.getInt("idcategoria")+",'" +quantidade+"'");
                }
                
                LimparProduto();
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        
        else{
            codigo = Integer.parseInt(view.getInputProduto_Codigo().getText());
            
            try{
                if(query.next()){
                    db.query_update("produto", "nome ='" +nome+ "' ,idcategoria = '" +query+"', quantidade_estoque = '" +quantidade+"'", "idproduto ="+codigo);
                    LimparProduto();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void SalvarItem(){
        String produto, lote, marca;
        int quantidade, codigo;
        float preco;
        Calendar validade;
        
        String where = "";
        
        if("".equals(view.getInputItem_Produto().getText())
            || "".equals(view.getInputItem_Lote().getText())
            || "".equals(view.getInputItem_Quantidade().getText())
            || "".equals(view.getInputItem_Marca().getText())
            || "".equals(view.getInputItem_Preco().getText())){
            
            return;
        }
        
        produto = view.getInputItem_Produto().getText();
        lote = view.getInputItem_Lote().getText();
        quantidade = Integer.parseInt(view.getInputItem_Quantidade().getText());
        marca = view.getInputItem_Marca().getText();
        preco = view.getInputItem_Preco().getValue().floatValue();
        validade = view.getInputItem_Validade().getSelectedDate();
        
        
        SimpleDateFormat from = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat to = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        
        if("".equals(view.getInputItem_Codigo().getText())){    
           
            String mysqlString = to.format(validade.getTime());
            db.query_insert("item", "idproduto, data_validade, lote, quantidade_estoque, marca, preco", "'"+produto+"', '" +mysqlString+"' , '"+lote+"', "+quantidade+", '"+marca+"' , "+preco+"");
            LimparItem();    
        }
        
        else{
            codigo = Integer.parseInt(view.getInputItem_Codigo().getText());
            
            validade.add(Calendar.DATE, 1);
            String mysqlString = to.format(validade.getTime());
            db.query_update("item", "idproduto ='" +produto+ "' ,data_validade = " +mysqlString+", lote = '" +lote+ "', quantidade_estoque = '" +quantidade+ "', marca = '" +marca+ "', preco = '" +preco+ "'", "iditem ="+codigo);
            LimparItem();
        }
        
    }
    
    public void Pesquisar(){
        
    }

    public void setProduto_values(int row) {
        
    }

    public void setItem_values(int row) {
        
    }
}
