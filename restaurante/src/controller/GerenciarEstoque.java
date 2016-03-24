/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    }
    
    public void LimparItem(){
        view.getInputItem_Lote().setText("");
        view.getInputItem_Produto().setText("");
        view.getInputItem_Quantidade().setText("");
        view.getInputItem_Validade().setSelectedDate(today);
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
        int quantidade;
        
        if("".equals(view.getInputProduto_Nome().getText())
            || "".equals(view.getInputProduto_Quantidade().getText())){
            
            return;
        }
        
        nome = view.getInputProduto_Nome().getText();
        categoria = view.getSelectProduto_Categoria().getSelectedItem().toString();
    }
    
    public void SalvarItem(){
        
    }
    
    public void Pesquisar(){
        
    }

    public void setProduto_values(int row) {
        
    }

    public void setItem_values(int row) {
        
    }
}
