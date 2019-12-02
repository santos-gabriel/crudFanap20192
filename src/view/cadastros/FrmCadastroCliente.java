/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cadastros;

import controller.CtrlClienteFisico;
import controller.CtrlClienteJuridico;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.ClienteFisico;
import model.bean.ClienteJuridico;

/**
 *
 * @author gabriel
 */
public class FrmCadastroCliente extends javax.swing.JFrame {

    /**
     * Creates new form frmCadastroCliente
     */
//ATRIBUTOS
    private boolean novoRegistro = false;
    private boolean editarFisico = false;

//CONSTRUTOR
    public FrmCadastroCliente() {
        initComponents();
        ordenarTabela();
        listarTabela();
    }

//MÉTODOS FUNCIONAIS E ESTÉTICOS
    private void desabilitarCampos() {
        txtCnpj.setText("");
        txtCnpj.setEnabled(false);
        txtCnpj.setEditable(false);
        txtCodCliente.setText("");
        txtCodCliente.setEnabled(false);
        txtCodCliente.setEditable(false);
        txtCpf.setText("");
        txtCpf.setEnabled(false);
        txtCpf.setEditable(false);
        txtNomeCliente.setText("");
        txtNomeCliente.setEnabled(false);
        txtNomeCliente.setEditable(false);
        txtNomeFantasiaCliente.setText("");
        txtNomeFantasiaCliente.setEnabled(false);
        txtNomeFantasiaCliente.setEditable(false);
        txtRazaoSocialCliente.setText("");
        txtRazaoSocialCliente.setEnabled(false);
        txtRazaoSocialCliente.setEditable(false);
        txtSobrenomeCliente.setText("");
        txtSobrenomeCliente.setEnabled(false);
        txtSobrenomeCliente.setEditable(false);
        rbFisico.setEnabled(false);
        rbJuridico.setEnabled(false);
        rbFisico.setSelected(false);
        rbJuridico.setSelected(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnSalvar.setEnabled(false);
    }

    private void habilitarCampos() {
        rbFisico.setEnabled(true);
        rbJuridico.setEnabled(true);
    }

    private void habilitarTodosCamposTexto() {
        txtCnpj.setEnabled(true);
        txtCnpj.setEditable(true);
        txtCpf.setEnabled(true);
        txtCpf.setEditable(true);
        txtNomeCliente.setEnabled(true);
        txtNomeCliente.setEditable(true);
        txtNomeFantasiaCliente.setEnabled(true);
        txtNomeFantasiaCliente.setEditable(true);
        txtRazaoSocialCliente.setEnabled(true);
        txtRazaoSocialCliente.setEditable(true);
        txtSobrenomeCliente.setEnabled(true);
        txtSobrenomeCliente.setEditable(true);
    }

    private void habilitarCamposClienteJuridico() {
        txtCnpj.setEnabled(true);
        txtCnpj.setEditable(true);
        txtNomeFantasiaCliente.setEnabled(true);
        txtNomeFantasiaCliente.setEditable(true);
        txtRazaoSocialCliente.setEnabled(true);
        txtRazaoSocialCliente.setEditable(true);
    }

    private void desabilitarCamposClienteJuridico() {
        txtCnpj.setEnabled(false);
        txtCnpj.setEditable(false);
        txtCnpj.setText("");
        txtNomeFantasiaCliente.setEnabled(false);
        txtNomeFantasiaCliente.setEditable(false);
        txtNomeFantasiaCliente.setText("");
        txtRazaoSocialCliente.setEnabled(false);
        txtRazaoSocialCliente.setEditable(false);
        txtRazaoSocialCliente.setText("");
    }

    private void desabilitarCamposClienteFisico() {
        txtCpf.setEnabled(false);
        txtCpf.setEditable(false);
        txtCpf.setText("");
        txtNomeCliente.setEnabled(false);
        txtNomeCliente.setEditable(false);
        txtNomeCliente.setText("");
        txtSobrenomeCliente.setEnabled(false);
        txtSobrenomeCliente.setEditable(false);
        txtSobrenomeCliente.setText("");
    }

    private void habilitarCamposClienteFisico() {
        txtCpf.setEnabled(true);
        txtCpf.setEditable(true);
        txtNomeCliente.setEnabled(true);
        txtNomeCliente.setEditable(true);
        txtSobrenomeCliente.setEnabled(true);
        txtSobrenomeCliente.setEditable(true);
    }

    private void ordenarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbCliente.getModel();
        tbCliente.setRowSorter(new TableRowSorter(modelo));
    }

    private void listarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbCliente.getModel();
        modelo.setNumRows(0);

        listarTabelaClienteJuridico(modelo);
        listarTabelaClienteFisico(modelo);

    }

    private void listarTabelaClienteFisico(DefaultTableModel modelo) {

        for (ClienteFisico cli : CtrlClienteFisico.listar()) {
            modelo.addRow(new Object[]{
                cli.getCod(),
                cli.getNome(),
                cli.getCpf(),
                cli.getSobrenome(),});
        }
    }

    private void listarTabelaClienteJuridico(DefaultTableModel modelo) {
        for (ClienteJuridico cli : CtrlClienteJuridico.listar()) {
            modelo.addRow(new Object[]{
                cli.getCod(),
                cli.getNome(),
                cli.getCnpj(),
                cli.getRazaoSocial()
            });
        }
    }

//MÉTODOS DE ACESSO AO BANCO
    private void salvarClienteFisico() {
        ClienteFisico clif = new ClienteFisico(txtNomeCliente.getText(), txtSobrenomeCliente.getText(), txtCpf.getText());
        CtrlClienteFisico.salvar(clif);
    }

    private void salvarClienteJuridico() {
        ClienteJuridico clij = new ClienteJuridico(txtNomeFantasiaCliente.getText(), txtRazaoSocialCliente.getText(), txtCnpj.getText());
        CtrlClienteJuridico.salvar(clij);
    }

    private void editarClienteFisico() {
        ClienteFisico clif = new ClienteFisico();
        clif.setCod(Integer.parseInt(txtCodCliente.getText()));
        clif.setCpf(txtCpf.getText());
        clif.setNome(txtNomeCliente.getText());
        clif.setSobrenome(txtSobrenomeCliente.getText());
        CtrlClienteFisico.editar(clif);
    }

    private void editarClienteJuridico() {
        ClienteJuridico clij = new ClienteJuridico();
        clij.setCnpj(txtCnpj.getText());
        clij.setCod(Integer.parseInt(txtCodCliente.getText()));
        clij.setNome(txtNomeFantasiaCliente.getText());
        clij.setRazaoSocial(txtRazaoSocialCliente.getText());
        CtrlClienteJuridico.editar(clij);
    }

    private void excluirClienteFisico() {
        ClienteFisico clif = new ClienteFisico();
        clif.setCod(Integer.parseInt(txtCodCliente.getText()));
        CtrlClienteFisico.excluir(clif);
    }

    private void excluirClienteJuridico() {
        ClienteJuridico clij = new ClienteJuridico();
        clij.setCod(Integer.parseInt(txtCodCliente.getText()));
        CtrlClienteJuridico.excluir(clij);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpCliente = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        txtNomeCliente = new javax.swing.JTextField();
        txtRazaoSocialCliente = new javax.swing.JTextField();
        rbFisico = new javax.swing.JRadioButton();
        rbJuridico = new javax.swing.JRadioButton();
        txtCpf = new javax.swing.JFormattedTextField();
        txtCnpj = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSobrenomeCliente = new javax.swing.JTextField();
        txtNomeFantasiaCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendas Tech");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));

        jLabel1.setText("Código");

        jLabel2.setText("Nome");

        jLabel3.setText("Razão Social");

        jLabel4.setText("CPF");
        jLabel4.setToolTipText("");

        jLabel5.setText("CNPJ");

        txtCodCliente.setEditable(false);
        txtCodCliente.setEnabled(false);

        txtNomeCliente.setEnabled(false);

        txtRazaoSocialCliente.setEnabled(false);

        grpCliente.add(rbFisico);
        rbFisico.setText("Físico");
        rbFisico.setEnabled(false);
        rbFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFisicoActionPerformed(evt);
            }
        });

        grpCliente.add(rbJuridico);
        rbJuridico.setText("Jurídico");
        rbJuridico.setEnabled(false);
        rbJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbJuridicoActionPerformed(evt);
            }
        });

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setEnabled(false);

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCnpj.setEnabled(false);

        jLabel6.setText("Sobrenome");

        jLabel7.setText("Nome Fantasia");

        txtSobrenomeCliente.setEnabled(false);

        txtNomeFantasiaCliente.setEnabled(false);
        txtNomeFantasiaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeFantasiaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(rbFisico)
                        .addGap(36, 36, 36)
                        .addComponent(rbJuridico)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addComponent(txtRazaoSocialCliente)
                                    .addComponent(txtSobrenomeCliente)
                                    .addComponent(txtNomeFantasiaCliente))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCpf))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbFisico)
                    .addComponent(rbJuridico))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRazaoSocialCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSobrenomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNomeFantasiaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jScrollPane1.setForeground(new java.awt.Color(240, 240, 240));

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome/Fantasia", "CPF/CNPJ", "Sobrenome/Razão Social"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCliente.getTableHeader().setReorderingAllowed(false);
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClienteMouseClicked(evt);
            }
        });
        tbCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbClienteKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbCliente);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setForeground(new java.awt.Color(240, 240, 240));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeFantasiaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeFantasiaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeFantasiaClienteActionPerformed

    private void rbFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFisicoActionPerformed
        if (this.novoRegistro) {
            desabilitarCamposClienteJuridico();
            habilitarCamposClienteFisico();
        }
    }//GEN-LAST:event_rbFisicoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.novoRegistro = true;
        habilitarCampos();
        btnSalvar.setEnabled(true);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void rbJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbJuridicoActionPerformed
        if (this.novoRegistro) {
            desabilitarCamposClienteFisico();
            habilitarCamposClienteJuridico();
        }
    }//GEN-LAST:event_rbJuridicoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (rbFisico.isSelected()) {
            salvarClienteFisico();
            listarTabela();
            desabilitarCampos();
        } else if (rbJuridico.isSelected()) {
            salvarClienteJuridico();
            listarTabela();
            desabilitarCampos();
        }
     }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (tbCliente.getSelectedRow() != -1) {

            if (editarFisico) {
                editarClienteFisico();
                desabilitarCampos();
                listarTabela();
                editarFisico = false;
            } else {
                editarClienteJuridico();
                desabilitarCampos();
                listarTabela();
                editarFisico = false;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um fornecedor a ser excluído");
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void tbClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbClienteKeyReleased
        if (tbCliente.getSelectedRow() != -1) {
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            String teste = tbCliente.getValueAt(tbCliente.getSelectedRow(), 2).toString();
            //TESTAR SE É UM CLIENTE FÍSICO OU JURÍDICO ATRAVES DO CPF OU CNPJ
            if (teste.length() <= 14) {
                txtCodCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 0).toString());
                desabilitarCamposClienteJuridico();
                habilitarCamposClienteFisico();
                txtCpf.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 2).toString());
                txtNomeCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 1).toString());
                txtSobrenomeCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 3).toString());
                editarFisico = true;
            } else {
                txtCodCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 0).toString());
                desabilitarCamposClienteFisico();
                habilitarCamposClienteJuridico();
                txtCnpj.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 2).toString());
                txtNomeFantasiaCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 1).toString());
                txtRazaoSocialCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 3).toString());
                editarFisico = false;
            }
        }
    }//GEN-LAST:event_tbClienteKeyReleased

    private void tbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMouseClicked
        if (tbCliente.getSelectedRow() != -1) {
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            String teste = tbCliente.getValueAt(tbCliente.getSelectedRow(), 2).toString();
            //TESTAR SE É UM CLIENTE FÍSICO OU JURÍDICO ATRAVES DO CPF OU CNPJ
            if (teste.length() <= 14) {
                txtCodCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 0).toString());
                desabilitarCamposClienteJuridico();
                habilitarCamposClienteFisico();
                txtCpf.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 2).toString());
                txtNomeCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 1).toString());
                txtSobrenomeCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 3).toString());
                editarFisico = true;
            } else {
                txtCodCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 0).toString());
                desabilitarCamposClienteFisico();
                habilitarCamposClienteJuridico();
                txtCnpj.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 2).toString());
                txtNomeFantasiaCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 1).toString());
                txtRazaoSocialCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 3).toString());
                editarFisico = false;
            }
        }
    }//GEN-LAST:event_tbClienteMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tbCliente.getSelectedRow() != -1) {

            if (editarFisico) {
                excluirClienteFisico();
                desabilitarCampos();
                listarTabela();
                editarFisico = false;
            } else {
                excluirClienteJuridico();
                desabilitarCampos();
                listarTabela();
                editarFisico = false;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um fornecedor a ser excluído");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup grpCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbFisico;
    private javax.swing.JRadioButton rbJuridico;
    private javax.swing.JTable tbCliente;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeFantasiaCliente;
    private javax.swing.JTextField txtRazaoSocialCliente;
    private javax.swing.JTextField txtSobrenomeCliente;
    // End of variables declaration//GEN-END:variables
}
