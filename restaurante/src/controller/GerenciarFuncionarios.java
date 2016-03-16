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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Conexao;
import view.FuncionarioView;

/**
 *
 * @author 201319040195
 */
public class GerenciarFuncionarios implements ActionListener{

    protected FuncionarioView view;
    private final Conexao db;
    private final DecimalFormat floatFormat = new DecimalFormat("0.00");
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public GerenciarFuncionarios(FuncionarioView view) {
        this.view = view;
        this.db = new Conexao();
        Date date = new Date();
        view.getInputFuncionario_Data().setText(dateFormat.format(date));
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand() ){
            case "Limpar":
                LimparCamposFuncionario();
                break;
            case "Salvar":
                salva_funcionario();
                break;
            case "Pesquisar":
                lista_funcionario();
                break;
            default:
                System.out.println(e.getActionCommand() );
                break;
        }
    }

    private void LimparCamposFuncionario() {
        view.getInputFuncionario_Nome().setText("");
        view.getInputFuncionario_Cpf().setText("");
        view.getInputFuncionario_Telefone().setText("");
        view.getInputFuncionario_Cargo().setText("");
        view.getInputFuncionario_Salario().setText("");
        view.getInputFuncionario_Data().setText("");
        view.getInputFuncionario_Usuario().setText("");
        view.getInputFuncionario_Senha().setText("");
        Date date = new Date();
        view.getInputFuncionario_Data().setText(dateFormat.format(date));
        clear_row((DefaultTableModel) view.getjTable1().getModel());
    }

    private void salva_funcionario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void lista_funcionario() {
        String where = "";
        DefaultTableModel row = (DefaultTableModel) view.getjTable1().getModel();
        int rowCount = row.getRowCount();

        clear_row(row);
        
        String pesquisa = view.getInputPesquisa_Funcionario().getText();
        if(!"".equals(pesquisa)){
            where = "WHERE nome like '%"+pesquisa+"%' or cpf LIKE '%"+pesquisa+"%'";
        }
        ResultSet query = db.query("SELECT * FROM funcionario INNER JOIN pessoa ON  funcionario.idpessoa = pessoa.idpessoa "+ where);
        
        try {
            while(query.next()){
                row.addRow(new Object[]{query.getInt("idfuncionario"), query.getString("nome"), query.getString("cpf")});
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
    
    public void setFuncionario_values(int index){
        String where = "";
        String pesquisa = view.getInputPesquisa_Funcionario().getText();
        
        DefaultTableModel row = (DefaultTableModel) view.getjTable1().getModel();
        view.getInputFuncionario_Nome().setText(row.getValueAt(index, 0).toString());
        
        if(!"".equals(pesquisa)){
            where = "WHERE nome like '%"+pesquisa+"%' or cpf LIKE '%"+pesquisa+"%'";
        }
        
        ResultSet query = db.query("SELECT * FROM funcionario INNER JOIN pessoa ON  funcionario.idpessoa = pessoa.idpessoa "+ where);
        
        try {
            if(query.next()){
                view.getInputFuncionario_Nome().setText(query.getString("nome"));
                view.getInputFuncionario_Cpf().setText(query.getString("cpf"));
                view.getInputFuncionario_Telefone().setText(query.getString("telefone"));
                view.getInputFuncionario_Data().setText(dateFormat.format(query.getString("data")));
                view.getInputFuncionario_Codigo().setText(query.getString("idpessoa"));
                view.getInputFuncionario_Cargo().setText(query.getString("cargo"));
                view.getInputFuncionario_Salario().setText(query.getString("salario"));
                view.getInputFuncionario_Usuario().setText(query.getString("usuario"));
                view.getInputFuncionario_Senha().setText(query.getString("senha"));
                
            }     
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
