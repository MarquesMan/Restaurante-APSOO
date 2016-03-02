/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.RestauranteView;

/**
 *
 * @author pet
 */
public class GerenciarPedidos  implements ActionListener{
   
    protected RestauranteView view;
    
    
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
                System.out.println("Foi");
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
    }
    
    
    
    
}
