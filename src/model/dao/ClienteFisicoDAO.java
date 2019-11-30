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
import model.bean.ClienteFisico;

public class ClienteFisicoDAO {

//ATRIBUTOS
    private Connection conexao = null;

//CONSTRUTOR
    public ClienteFisicoDAO() {
        conexao = ConexaoMySql.conectar();
    }

//MÉTODOS
    public void salvar(ClienteFisico cliente) {

        PreparedStatement stmt = null;
        String sql = "INSERT INTO tb_clientes_fisico(nome_cliente, sobrenome_cliente, cpf) VALUES (?, ?, ?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getCpf());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso! ");
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

    public void editar(ClienteFisico cliente) {
        String sql = "UPDATE tb_clientes_fisico SET nome_cliente = ?, sobrenome_cliente = ?, cpf = ? WHERE cod_cliente = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getCpf());
            stmt.setInt(4, cliente.getCod());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! ");
            System.out.println(ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado! ");
            System.out.println(e);
        } finally {
            ConexaoMySql.fecharConexao(conexao, stmt);
        }
    }

    public void Excluir(ClienteFisico cliente) {

        String sql = "DELETE FROM tb_clientes_fisico WHERE cod_cliente = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cliente.getCod());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! ");
            System.out.println(ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado! ");
            System.out.println(e);
        } finally {
            ConexaoMySql.fecharConexao(conexao, stmt);
        }

    }

    public List<ClienteFisico> listar() {
        Connection conexao = ConexaoMySql.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ClienteFisico> listaCliente = new ArrayList<>();
        try {

            stmt = conexao.prepareStatement("SELECT cod_cliente, nome_cliente, sobrenome_cliente, cpf FROM tb_clientes_fisico");
            rs = stmt.executeQuery();

            while (rs.next()) {

                ClienteFisico cliente = new ClienteFisico();
                cliente.setCod(rs.getInt("cod_cliente"));
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setSobrenome(rs.getString("sobrenome_cliente"));
                cliente.setCpf(rs.getString("cpf"));

                listaCliente.add(cliente);
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
        return listaCliente;
    }

    public String buscaNome(ClienteFisico clif) {
        Connection conexao = ConexaoMySql.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String nome = null;
        String sql = "SELECT (nome_cliente) FROM tb_clientes_fisico WHERE cod_cliente = ?;";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, clif.getCod());
            rs = stmt.executeQuery();

            while (rs.next()) {
                nome = rs.getString("nome_cliente");
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
        return nome;
    }

}
