package model.dao;

import connection.ConexaoMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.ItensVenda;

public class ItensVendaDAO {

//ATRIBUTOS
    private Connection conexao = null;

//CONSTRUTOR
    public ItensVendaDAO() {
        conexao = ConexaoMySql.conectar();
    }

//MÉTODOS
    public void salvar(ItensVenda iv) {

        PreparedStatement stmt = null;
        String sql = "INSERT INTO tb_itens_venda (cod_venda, qtd_itens_venda, cod_produto, total_itens_venda) VALUES (?, ?, ?, ?);";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, iv.getCodVenda());
            stmt.setInt(2, iv.getQtdItensVenda());
            stmt.setInt(3, iv.getCodigoProduto());
            stmt.setDouble(4, iv.getTotalItensVenda());

            stmt.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso! ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! ");
            System.out.println(ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado! ");
            System.out.println(e);
        } finally {
            ConexaoMySql.fecharConexao(conexao, stmt);
        }

    }

    public List<ItensVenda> listar() {
        Connection conexao = ConexaoMySql.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ItensVenda> listaItens = new ArrayList<>();
        try {

            stmt = conexao.prepareStatement("SELECT cod_venda, qtd_itens_venda, cod_produto, total_itens_venda FROM tb_itens_venda;");
            rs = stmt.executeQuery();

            while (rs.next()) {

                ItensVenda iv = new ItensVenda();
                iv.setCodVenda(rs.getInt("cod_venda"));
                iv.setQtdItensVenda(rs.getInt("qtd_itens_venda"));
                iv.setCodigoProduto(rs.getInt("cod_produto"));
                iv.setTotalItensVenda(rs.getDouble("total_itens_venda"));

                listaItens.add(iv);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar arquivos");
            System.out.println(ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado! ");
            System.out.println(e);
        } finally {
            ConexaoMySql.fecharConexao(conexao, stmt, rs);
        }
        return listaItens;
    }

    public void deletarTodasColunas() {
        Connection conexao = ConexaoMySql.conectar();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("DELETE FROM tb_itens_venda");
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar arquivos!");
            System.out.println(ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado!");
            System.out.println(e);
        } finally {
            ConexaoMySql.fecharConexao(conexao, stmt);
        }
    }

}
