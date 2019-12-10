/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.glass.events.KeyEvent;
import controller.CtrlClienteFisico;
import controller.CtrlClienteJuridico;
import controller.CtrlItensVenda;
import controller.CtrlProduto;
import controller.CtrlVenda;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.ClienteFisico;
import model.bean.ClienteJuridico;
import model.bean.ItensVenda;
import model.bean.Produto;
import model.bean.Venda;

/**
 *
 * @author gabriel
 */
public class FrmVendas extends javax.swing.JFrame {

    /**
     * Creates new form frmVendas
     */
//ATRIBUTOS
    //private List<ItensVenda> listaDeItens = new ArrayList<>();
//CONSTRUTORES
    public FrmVendas() {
        initComponents();
        limparTabela();
    }

//MÉTODOS ESTÉTICOS
    private void habilitarCamposTexto() {
        txtClienteJuridico.setText("");
        txtClienteJuridico.setText("");
        txtClienteFisico.setText("");
        txtCodClienteFisico.setText("");
        txtNomeProduto.setText("");
        txtCodProd.setText("");
        txtCodProd.setEnabled(true);
        txtDataVenda.setText("");
        txtDescontoProduto.setText("");
        txtDescontoProduto.setEnabled(true);
        txtQuantidade.setText("");
        txtQuantidade.setEnabled(true);
        txtTotalComDesconto.setText("");
        txtTotalComDesconto.setEnabled(true);
        txtNomeProduto.setText("");
        txtValorProduto.setText("");
        rbFisico.setEnabled(true);
        rbJuridico.setEnabled(true);
        txtDescontoProduto.setEnabled(true);
    }

    private void limparTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbVendas.getModel();
        modelo.setNumRows(0);
    }

    private void somaPreco() {
        double preco = Double.parseDouble(txtValorProduto.getText());
        int quantidade = Integer.parseInt(txtQuantidade.getText());
        double total = 0;
        if (!txtTotalVenda.equals("")) {
            total = Double.parseDouble(txtTotalVenda.getText());
        }
        double novoTotal = total + (preco * quantidade);
        txtTotalVenda.setText(Double.toString(novoTotal));
    }

    private void somaTotal() {
        double totalSemDesconto = Double.parseDouble(txtTotalVenda.getText());
        double desconto = 0;
        double totalComDesconto;
        if (!txtDescontoProduto.getText().equals("")) {
            desconto = Double.parseDouble(txtDescontoProduto.getText());
        }
        totalComDesconto = totalSemDesconto - desconto;
        txtTotalComDesconto.setText(Double.toString(totalComDesconto));
    }

    private void limparTodosCampos() {
        txtCodProd.setText("");
        txtCodProd.setEnabled(false);
        txtQuantidade.setText("");
        txtQuantidade.setEnabled(false);
        txtDescontoProduto.setText("");
        txtDescontoProduto.setEnabled(false);
        txtTotalVenda.setText("");
        txtTotalVenda.setEnabled(false);
        txtTotalComDesconto.setText("");
        txtTotalComDesconto.setEnabled(false);
        txtDataVenda.setText("");
        txtValorProduto.setText("");
        txtClienteFisico.setText("");
        txtClienteFisico.setEnabled(false);
        txtCodClienteFisico.setEnabled(false);
        txtClienteJuridico.setText("");
        txtClienteJuridico.setEnabled(false);
        txtCodClienteJuridico.setEnabled(false);
        txtCodClienteFisico.setText("");
        txtCodClienteJuridico.setText("");
        txtCodVenda.setText("");
        txtNomeProduto.setText("");
        buttonGroup1.clearSelection();
        rbFisico.setEnabled(false);
        rbJuridico.setEnabled(false);
    }

    private void insereData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date data = new Date();
        txtDataVenda.setText(sdf.format(data));
    }

//MÉTODOS DE ACESSO AO BANCO
    private void salvarItem() {
        ItensVenda iv = new ItensVenda();
        iv.setCodVenda(Integer.parseInt(txtCodVenda.getText()));
        iv.setCodigoProduto(Integer.parseInt(txtCodProd.getText()));
        iv.setQtdItensVenda(Integer.parseInt(txtQuantidade.getText()));
        iv.setTotalItensVenda((Double.parseDouble(txtValorProduto.getText())) * (Double.parseDouble(txtQuantidade.getText())));

        CtrlItensVenda.salvar(iv);
    }

    private void salvarVenda() {
        Venda v = new Venda();
        v.setCodigo(Integer.parseInt(txtCodVenda.getText()));
        CtrlVenda.salvar(v);
    }

    private void listarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbVendas.getModel();
        modelo.setNumRows(0);

        for (ItensVenda iv : CtrlItensVenda.listar()) {
            modelo.addRow(new Object[]{
                iv.getCodVenda(),
                iv.getCodigoProduto(),
                iv.getQtdItensVenda(),
                iv.getTotalItensVenda()
            });
        }
    }

    /*
    private void teste() {
        DefaultTableModel modelo = (DefaultTableModel) tbVendas.getModel();
        modelo.setNumRows(0);

        for (ItensVenda iv : listaDeItens) {
            modelo.addRow(new Object[]{
                iv.getCodVenda(),
                iv.getCodigoProduto(),
                iv.getQtdItensVenda(),
                iv.getTotalItensVenda()
            });
        }
    }
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodVenda = new javax.swing.JTextField();
        txtDataVenda = new javax.swing.JTextField();
        txtClienteJuridico = new javax.swing.JTextField();
        txtNomeProduto = new javax.swing.JTextField();
        btnInserirProduto = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        txtCodClienteJuridico = new javax.swing.JTextField();
        txtCodProd = new javax.swing.JTextField();
        txtValorProduto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCodClienteFisico = new javax.swing.JTextField();
        txtClienteFisico = new javax.swing.JTextField();
        rbFisico = new javax.swing.JRadioButton();
        rbJuridico = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        btnNovaVenda = new javax.swing.JButton();
        btnFinalizarVenda = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalVenda = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDescontoProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotalComDesconto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVendas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendas Tech");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vendas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("Código");

        jLabel3.setText("Cliente");

        jLabel4.setText("Produto");
        jLabel4.setToolTipText("");

        jLabel5.setText("Valor");

        txtCodVenda.setEnabled(false);

        txtDataVenda.setEnabled(false);
        txtDataVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataVendaActionPerformed(evt);
            }
        });

        txtClienteJuridico.setEnabled(false);

        txtNomeProduto.setEnabled(false);

        btnInserirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconsPng/cart_put.png"))); // NOI18N
        btnInserirProduto.setText("Inserir Produto");
        btnInserirProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInserirProduto.setEnabled(false);
        btnInserirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirProdutoActionPerformed(evt);
            }
        });

        jLabel9.setText("Quantidade");

        txtQuantidade.setEnabled(false);

        txtCodClienteJuridico.setEnabled(false);
        txtCodClienteJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodClienteJuridicoActionPerformed(evt);
            }
        });
        txtCodClienteJuridico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodClienteJuridicoKeyPressed(evt);
            }
        });

        txtCodProd.setEnabled(false);
        txtCodProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodProdActionPerformed(evt);
            }
        });
        txtCodProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodProdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodProdKeyReleased(evt);
            }
        });

        txtValorProduto.setEnabled(false);

        jLabel10.setText("Cliente");

        txtCodClienteFisico.setEnabled(false);
        txtCodClienteFisico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodClienteFisicoKeyPressed(evt);
            }
        });

        txtClienteFisico.setEnabled(false);

        buttonGroup1.add(rbFisico);
        rbFisico.setText("Físico");
        rbFisico.setEnabled(false);
        rbFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFisicoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbJuridico);
        rbJuridico.setText("Jurídico");
        rbJuridico.setEnabled(false);
        rbJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbJuridicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(rbFisico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbJuridico)
                        .addGap(41, 41, 41)
                        .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodClienteFisico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodClienteJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnInserirProduto)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtClienteJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtClienteFisico, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(111, 111, 111)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel5))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbFisico)
                        .addComponent(rbJuridico)
                        .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodClienteFisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodClienteJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtClienteFisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtClienteJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addComponent(btnInserirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("  "));

        btnNovaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconsPng/cart_add.png"))); // NOI18N
        btnNovaVenda.setText("Nova Venda");
        btnNovaVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaVendaActionPerformed(evt);
            }
        });

        btnFinalizarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconsPng/cart_go.png"))); // NOI18N
        btnFinalizarVenda.setText("Finalizar Venda");
        btnFinalizarVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizarVenda.setEnabled(false);
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
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
                    .addComponent(btnFinalizarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovaVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnNovaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        jLabel7.setText("Total sem Desconto");

        txtTotalVenda.setEnabled(false);

        jLabel8.setText("Total");

        txtDescontoProduto.setEnabled(false);
        txtDescontoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescontoProdutoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescontoProdutoKeyReleased(evt);
            }
        });

        jLabel6.setText("Desconto");

        txtTotalComDesconto.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalVenda)
                    .addComponent(txtDescontoProduto)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(txtTotalComDesconto))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescontoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalComDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Itens da Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        tbVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Quantidade", "Preço Unitário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVendas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbVendas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaVendaActionPerformed
        habilitarCamposTexto();
        txtCodVenda.setText(Integer.toString(CtrlVenda.buscaUltimoCodigo()));
        txtTotalVenda.setText("0");
        txtDescontoProduto.setText("0");
        salvarVenda();
        CtrlItensVenda.deletarTodasColunas();
        limparTabela();
        btnFinalizarVenda.setEnabled(true);
        btnInserirProduto.setEnabled(true);
        somaTotal();
        insereData();
    }//GEN-LAST:event_btnNovaVendaActionPerformed

    private void txtDataVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataVendaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnInserirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirProdutoActionPerformed
        if (!txtQuantidade.getText().equals("")) {
            salvarItem();
            listarTabela();
            somaPreco();
            somaTotal();
        } else {
            JOptionPane.showMessageDialog(null, "Insira a quantidade!");
        }
    }//GEN-LAST:event_btnInserirProdutoActionPerformed

    private void txtCodProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodProdActionPerformed

    private void txtCodProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProdKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)) {
            Produto p = new Produto();
            p.setCod(Integer.parseInt(txtCodProd.getText()));
            Produto prod = CtrlProduto.buscaProduto(p);
            txtNomeProduto.setText(prod.getDesc());
            txtValorProduto.setText(Double.toString(prod.getPreco()));
            if ((txtQuantidade.getText().equals("") || txtQuantidade.getText().equals(null))) {
                txtQuantidade.setText("1");
            }

        }
    }//GEN-LAST:event_txtCodProdKeyPressed

    private void txtCodClienteJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodClienteJuridicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodClienteJuridicoActionPerformed

    private void txtCodProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProdKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            Produto p = new Produto();
            p.setCod(Integer.parseInt(txtCodProd.getText()));
            Produto prod = CtrlProduto.buscaProduto(p);
            txtNomeProduto.setText(prod.getDesc());
            txtValorProduto.setText(Double.toString(prod.getPreco()));
            if ((txtQuantidade.getText().equals("") || txtQuantidade.getText().equals(null))) {
                txtQuantidade.setText("1");
            }
        }
    }//GEN-LAST:event_txtCodProdKeyReleased

    private void rbFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFisicoActionPerformed
        txtClienteFisico.setText("");
        txtCodClienteFisico.setText("");
        txtCodClienteFisico.setEnabled(true);
        txtClienteJuridico.setText("");
        txtCodClienteJuridico.setText("");
        txtCodClienteJuridico.setEnabled(false);
    }//GEN-LAST:event_rbFisicoActionPerformed

    private void rbJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbJuridicoActionPerformed
        txtClienteJuridico.setText("");
        txtCodClienteJuridico.setText("");
        txtCodClienteJuridico.setEnabled(true);
        txtCodClienteFisico.setText("");
        txtCodClienteFisico.setEnabled(false);
        txtClienteFisico.setText("");
        txtClienteFisico.setEnabled(false);
    }//GEN-LAST:event_rbJuridicoActionPerformed

    private void txtCodClienteFisicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteFisicoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ClienteFisico clif = new ClienteFisico();
            clif.setCod(Integer.parseInt(txtCodClienteFisico.getText()));
            txtClienteFisico.setText(CtrlClienteFisico.buscaNome(clif));
        }
    }//GEN-LAST:event_txtCodClienteFisicoKeyPressed

    private void txtCodClienteJuridicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteJuridicoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ClienteJuridico clij = new ClienteJuridico();
            clij.setCod(Integer.parseInt(txtCodClienteJuridico.getText()));
            txtClienteJuridico.setText(CtrlClienteJuridico.buscaNome(clij));
        }
    }//GEN-LAST:event_txtCodClienteJuridicoKeyPressed

    private void txtDescontoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescontoProdutoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            somaTotal();
        }
    }//GEN-LAST:event_txtDescontoProdutoKeyPressed

    private void txtDescontoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescontoProdutoKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            somaTotal();
        }
    }//GEN-LAST:event_txtDescontoProdutoKeyReleased

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        limparTabela();
        limparTodosCampos();
        btnFinalizarVenda.setEnabled(false);
        btnInserirProduto.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Venda finalizada");
    }//GEN-LAST:event_btnFinalizarVendaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizarVenda;
    private javax.swing.JButton btnInserirProduto;
    private javax.swing.JButton btnNovaVenda;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbFisico;
    private javax.swing.JRadioButton rbJuridico;
    private javax.swing.JTable tbVendas;
    private javax.swing.JTextField txtClienteFisico;
    private javax.swing.JTextField txtClienteJuridico;
    private javax.swing.JTextField txtCodClienteFisico;
    private javax.swing.JTextField txtCodClienteJuridico;
    private javax.swing.JTextField txtCodProd;
    private javax.swing.JTextField txtCodVenda;
    private javax.swing.JTextField txtDataVenda;
    private javax.swing.JTextField txtDescontoProduto;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTotalComDesconto;
    private javax.swing.JTextField txtTotalVenda;
    private javax.swing.JTextField txtValorProduto;
    // End of variables declaration//GEN-END:variables
}
