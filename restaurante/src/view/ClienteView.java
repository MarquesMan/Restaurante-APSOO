/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GerenciarClientes;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author gabryel
 */
public class ClienteView extends javax.swing.JPanel {
    private GerenciarClientes ClientesListener;

    /**
     * Creates new form ClienteView
     */
    public ClienteView() {
        initComponents();
        InputCliente_Codigo.setVisible(false);
        
        ClientesListener = new GerenciarClientes(this);
        botaoCliente_Limpar.addActionListener(ClientesListener);
        botaoCliente_Salvar.addActionListener(ClientesListener);
        botaoCliente_Pesquisar.addActionListener(ClientesListener);
    }

    public JTextField getInputCliente_Codigo() {
        return InputCliente_Codigo;
    }
    
    public JTextField getInputCliente_Cpf() {
        return InputCliente_Cpf;
    }

    public JTextField getInputCliente_Data() {
        return InputCliente_Data;
    }

    public JTextField getInputCliente_Nome() {
        return InputCliente_Nome;
    }

    public JTextField getInputCliente_Telefone() {
        return InputCliente_Telefone;
    }

    public JTextField getInputPesquisa_Cliente() {
        return InputPesquisa_Cliente;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        InputCliente_Nome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        InputCliente_Cpf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        InputCliente_Telefone = new javax.swing.JTextField();
        InputCliente_Data = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        botaoCliente_Limpar = new javax.swing.JButton();
        botaoCliente_Salvar = new javax.swing.JButton();
        InputCliente_Codigo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        InputPesquisa_Cliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        botaoCliente_Pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        InputCliente_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCliente_NomeActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome :");
        jLabel1.setToolTipText("");

        jLabel2.setText("CPF :");

        InputCliente_Cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCliente_CpfActionPerformed(evt);
            }
        });

        jLabel3.setText("Telefone :");

        InputCliente_Telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCliente_TelefoneActionPerformed(evt);
            }
        });

        InputCliente_Data.setEditable(false);
        InputCliente_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCliente_DataActionPerformed(evt);
            }
        });

        jLabel9.setText("Data :");

        botaoCliente_Limpar.setText("Limpar");

        botaoCliente_Salvar.setText("Salvar");

        InputCliente_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCliente_CodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(InputCliente_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputCliente_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputCliente_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputCliente_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputCliente_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoCliente_Limpar)
                        .addGap(236, 236, 236)
                        .addComponent(botaoCliente_Salvar)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(InputCliente_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputCliente_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputCliente_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputCliente_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputCliente_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCliente_Limpar)
                    .addComponent(botaoCliente_Salvar))
                .addGap(64, 64, 64))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        InputPesquisa_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPesquisa_ClienteActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Nome / CPF :");

        botaoCliente_Pesquisar.setText("Pesquisar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(38, 38, 38)
                .addComponent(InputPesquisa_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoCliente_Pesquisar)
                .addContainerGap(168, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputPesquisa_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(botaoCliente_Pesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void InputCliente_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCliente_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCliente_NomeActionPerformed

    private void InputCliente_CpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCliente_CpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCliente_CpfActionPerformed

    private void InputCliente_TelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCliente_TelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCliente_TelefoneActionPerformed

    private void InputPesquisa_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPesquisa_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPesquisa_ClienteActionPerformed

    private void InputCliente_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCliente_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCliente_CodigoActionPerformed

    private void InputCliente_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCliente_DataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCliente_DataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InputCliente_Codigo;
    private javax.swing.JTextField InputCliente_Cpf;
    private javax.swing.JTextField InputCliente_Data;
    private javax.swing.JTextField InputCliente_Nome;
    private javax.swing.JTextField InputCliente_Telefone;
    private javax.swing.JTextField InputPesquisa_Cliente;
    private javax.swing.JButton botaoCliente_Limpar;
    private javax.swing.JButton botaoCliente_Pesquisar;
    private javax.swing.JButton botaoCliente_Salvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
