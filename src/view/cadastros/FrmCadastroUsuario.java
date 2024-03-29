/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cadastros;

import javax.swing.JOptionPane;
import controller.CtrlProduto;
import controller.CtrlUsuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Usuario;

/**
 *
 * @author gabriel
 */
public class FrmCadastroUsuario extends javax.swing.JFrame {

    /**
     * Creates new form frmCadastroUsuario
     */
//CONSTRUTOR
    public FrmCadastroUsuario() {
        initComponents();
        ordenarTabela();
        listarTabela();

    }

//MÉTODOS FUNCIONAIS E ESTÉTICOS
    private void desabilitarCampos() {
        txtCodUsuario.setText("");
        txtEmailUsuario.setText("");
        txtEmailUsuario.setEditable(false);
        txtEmailUsuario.setEnabled(false);
        txtNomeUsuario.setText("");
        txtNomeUsuario.setEditable(false);
        txtNomeUsuario.setEnabled(false);
        txtSenhaUsuario.setText("");
        txtSenhaUsuario.setEditable(false);
        txtSenhaUsuario.setEnabled(false);
        txtUsuario.setText("");
        txtUsuario.setEditable(false);
        txtUsuario.setEnabled(false);
    }

    private void habilitarCamposTexto() {
        txtEmailUsuario.setEditable(true);
        txtEmailUsuario.setEnabled(true);
        txtNomeUsuario.setEditable(true);
        txtNomeUsuario.setEnabled(true);
        txtSenhaUsuario.setEditable(true);
        txtSenhaUsuario.setEnabled(true);
        txtUsuario.setEditable(true);
        txtUsuario.setEnabled(true);
    }

    private void ordenarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbUsuario.getModel();
        tbUsuario.setRowSorter(new TableRowSorter(modelo));
    }

//MÉTODOS DE ACESSO AO BANCO
    private void SalvarUsuario() {
        Usuario u = new Usuario();
        u.setEmail(txtEmailUsuario.getText());
        u.setLogin(txtUsuario.getText());
        u.setNome(txtNomeUsuario.getText());
        u.setSenha(txtSenhaUsuario.getText());
        CtrlUsuario.salvar(u);
    }

    private void editarUsuario() {
        Usuario u = new Usuario();
        u.setCod((int) tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 0));
        u.setEmail(txtEmailUsuario.getText());
        u.setLogin(txtUsuario.getText());
        u.setNome(txtNomeUsuario.getText());
        u.setSenha(txtSenhaUsuario.getText());
        CtrlUsuario.editar(u);
    }

    private void excluirUsuario() {
        Usuario u = new Usuario();

        u.setCod((int) tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 0));

        CtrlUsuario.excluir(u);
    }

    private void listarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbUsuario.getModel();
        modelo.setNumRows(0);

        for (Usuario u : CtrlUsuario.listar()) {
            modelo.addRow(new Object[]{
                u.getCod(),
                u.getNome(),
                u.getEmail(),
                u.getLogin(),
                u.getSenha()
            });
        }

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodUsuario = new javax.swing.JTextField();
        txtNomeUsuario = new javax.swing.JTextField();
        txtEmailUsuario = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtSenhaUsuario = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendas Tech");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("Código");

        jLabel2.setText("Nome");

        jLabel3.setText("Email");

        jLabel4.setText("Usuário");
        jLabel4.setToolTipText("");

        jLabel5.setText("Senha");

        txtCodUsuario.setEditable(false);
        txtCodUsuario.setEnabled(false);

        txtNomeUsuario.setEditable(false);
        txtNomeUsuario.setEnabled(false);

        txtEmailUsuario.setEditable(false);
        txtEmailUsuario.setEnabled(false);

        txtUsuario.setEditable(false);
        txtUsuario.setEnabled(false);

        txtSenhaUsuario.setEditable(false);
        txtSenhaUsuario.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addComponent(txtNomeUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmailUsuario, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(txtSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3))
                    .addComponent(txtEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconsPng/user_add.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconsPng/accept.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconsPng/user_edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconsPng/user_delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconsPng/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Email", "Usuario", "Senha"
            }
        ));
        tbUsuario.getTableHeader().setReorderingAllowed(false);
        tbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuarioMouseClicked(evt);
            }
        });
        tbUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbUsuarioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        btnExcluir.setEnabled(false);
        btnEditar.setEnabled(false);
        desabilitarCampos();
        habilitarCamposTexto();
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if ((txtNomeUsuario.getText() == "") || (txtNomeUsuario == null)) {
            JOptionPane.showMessageDialog(null, "Insira unome para o usuário! ");

        } else if ((txtSenhaUsuario.getText() == "") || (txtSenhaUsuario == null)) {
            JOptionPane.showMessageDialog(null, "Insira uam senha! ");

        } else if ((txtUsuario.getText() == "") || (txtUsuario == null)) {
            JOptionPane.showMessageDialog(null, "Usuário invalido! ");

        } else if ((txtEmailUsuario.getText() == "") || (txtEmailUsuario == null)) {
            JOptionPane.showMessageDialog(null, "Usuário invalido! ");

        } else {
            SalvarUsuario();
            listarTabela();
            desabilitarCampos();
            btnSalvar.setEnabled(false);
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        if (tbUsuario.getSelectedRow() != -1) {

            excluirUsuario();
            desabilitarCampos();
            listarTabela();
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um fornecedor a ser excluído");
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (tbUsuario.getSelectedRow() != -1) {
            if ((txtEmailUsuario.getText() == "") || (txtEmailUsuario == null)) {
                JOptionPane.showMessageDialog(null, "Insira uma descrição para o produto! ");
            } else if ((txtNomeUsuario.getText() == "") || (txtNomeUsuario == null)) {
                JOptionPane.showMessageDialog(null, "Insira um valor para o produto! ");
            } else {
                editarUsuario();
                desabilitarCampos();
                listarTabela();
                btnEditar.setEnabled(false);
                btnExcluir.setEnabled(false);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um fornecedor a ser excluído");
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void tbUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbUsuarioKeyReleased
        if (tbUsuario.getSelectedRow() != -1) {
            habilitarCamposTexto();
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            txtCodUsuario.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 0).toString());
            txtEmailUsuario.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 2).toString());
            txtNomeUsuario.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 1).toString());
            txtUsuario.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 3).toString());
            txtSenhaUsuario.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 4).toString());
        }

    }//GEN-LAST:event_tbUsuarioKeyReleased

    private void tbUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuarioMouseClicked
        // TODO add your handling code here:
        if (tbUsuario.getSelectedRow() != -1) {
            habilitarCamposTexto();
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            txtCodUsuario.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 0).toString());
            txtEmailUsuario.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 2).toString());
            txtNomeUsuario.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 1).toString());
            txtUsuario.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 3).toString());
            txtSenhaUsuario.setText(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 4).toString());
        }

    }//GEN-LAST:event_tbUsuarioMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JTextField txtCodUsuario;
    private javax.swing.JTextField txtEmailUsuario;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JPasswordField txtSenhaUsuario;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
