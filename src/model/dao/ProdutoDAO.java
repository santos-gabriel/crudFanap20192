package model.dao;

import connection.ConexaoMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Produto;

public class ProdutoDAO {

//ATRIBUTOS
    private Connection conexao = null;

//CONSTRUTOR
    public ProdutoDAO() {
        conexao = ConexaoMySql.conectar();
    }

//MÉTODOS
    public void salvar(Produto produto) {

        PreparedStatement stmt = null;
        String sql = "INSERT INTO tb_produtos (desc_produto, preco_produto, qtde_produto) VALUES (?, ?, ?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getDesc());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso! ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! ");
            System.out.println(ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado! ");
            System.out.println(e);
        } finally {
            ConexaoMySql.fecharConexao(conexao);
        }

    }

    public void editar(Produto produto) {
        String sql = "UPDATE tb_produtos SET desc_produto = ?, preco_produto = ?, qtde_produto = ? WHERE cod_produto = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getDesc());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getCod());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! ");
            System.out.println(ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado! ");
            System.out.println(e);
        } finally {
            ConexaoMySql.fecharCoexao(conexao, stmt);
        }
    }

    public void Excluir(Produto produto) {

        String sql = "DELETE FROM tb_produtos WHERE cod_produto = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, produto.getCod());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! ");
            System.out.println(ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado! ");
            System.out.println(e);
        } finally {
            ConexaoMySql.fecharCoexao(conexao, stmt);
        }

    }

    public List<Produto> listar() {
        Connection conexao = ConexaoMySql.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> listaProduto = new ArrayList<>();
        try {

            stmt = conexao.prepareStatement("SELECT * FROM tb_produtos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();
                produto.setCod(rs.getInt("cod_produto"));
                produto.setDesc(rs.getString("desc_produto"));
                produto.setPreco(rs.getDouble("preco_produto"));
                produto.setQuantidade(rs.getInt("qtde_produto"));

                listaProduto.add(produto);
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
        return listaProduto;
    }

}
