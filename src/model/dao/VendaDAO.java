package model.dao;

import model.bean.Venda;
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

public class VendaDAO {

    //ATRIBUTOS
    private Connection conexao = null;

//CONSTRUTOR
    public VendaDAO() {
        conexao = ConexaoMySql.conectar();
    }

//MÉTODOS
    public void salvar(Venda v) {

        PreparedStatement stmt = null;
        String sql = "INSERT INTO tb_venda (cod_venda) VALUES (?);";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, v.getCodigo());

            stmt.executeUpdate();
            // JOptionPane.showMessageDialog(null, "Salvo com sucesso! ");
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

    public List<Venda> listar() {
        Connection conexao = ConexaoMySql.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> listaItens = new ArrayList<>();
        try {

            stmt = conexao.prepareStatement("SELECT cod_venda FROM tb_venda;");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Venda v = new Venda();
                v.setCodigo(rs.getInt("cod_venda"));

                listaItens.add(v);
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

    public Integer consultarProximoCodigo() {
        Connection conexao = ConexaoMySql.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int codigo = 1;
        try {
            stmt = conexao.prepareStatement("SELECT cod_venda FROM tb_venda;");
            rs = stmt.executeQuery();

            while (rs.next()) {
                codigo++;
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
        return codigo;
    }

    public void deletarTodasColunas() {
        Connection conexao = ConexaoMySql.conectar();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("DELETE FROM tb_venda");
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
