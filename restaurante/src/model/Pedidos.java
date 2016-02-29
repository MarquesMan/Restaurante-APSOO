/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pet
 */
public class Pedidos extends Conexao{
    
    public void addPessoa(String nome, String cpf, String telefone){
        String query = "INSERT INTO pessoa(nome, cpf, telefone) VALUES ('"+nome+"', '"+cpf+"','"+telefone+"')";
        System.out.println(query);
        Statement stmt;
        try {
            stmt = con.createStatement();
            int executeUpdate = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
