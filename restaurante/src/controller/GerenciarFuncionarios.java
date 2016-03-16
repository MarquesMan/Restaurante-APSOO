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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void clear_row(DefaultTableModel table) {
        int rowCount = table.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            table.removeRow(i);
        }
    }
    
}
