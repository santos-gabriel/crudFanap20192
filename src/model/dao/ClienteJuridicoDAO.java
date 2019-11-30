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
import model.bean.ClienteJuridico;

public class ClienteJuridicoDAO {

//ATRIBUTOS
    private Connection conexao = null;

//CONSTRUTOR
    public ClienteJuridicoDAO() {
        conexao = ConexaoMySql.conectar();
    }

//MÉTODOS
    public void salvar(ClienteJuridico cliente) {

        PreparedStatement stmt = null;
        String sql = "INSERT INTO tb_clientes_juridico(nome_fantazia_cliente, razao_social_cliente, cnpj) VALUES (?, ?, ?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getRazaoSocial());
            stmt.setString(3, cliente.getCnpj());

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

    public void editar(ClienteJuridico cliente) {
        String sql = "UPDATE tb_clientes_juridico SET nome_fantazia_cliente = ?, razao_social_cliente = ?, cnpj = ? WHERE cod_cliente = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getRazaoSocial());
            stmt.setString(3, cliente.getCnpj());
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

    public void Excluir(ClienteJuridico cliente) {

        String sql = "DELETE FROM tb_clientes_juridico WHERE cod_cliente = ?";
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

    public List<ClienteJuridico> listar() {
        Connection conexao = ConexaoMySql.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ClienteJuridico> listaCliente = new ArrayList<>();
        try {

            stmt = conexao.prepareStatement("SELECT cod_cliente, nome_fantazia_cliente, razao_social_cliente, cnpj FROM tb_clientes_juridico");
            rs = stmt.executeQuery();

            while (rs.next()) {

                ClienteJuridico cliente = new ClienteJuridico();
                cliente.setCod(rs.getInt("cod_cliente"));
                cliente.setNome(rs.getString("nome_fantazia_cliente"));
                cliente.setRazaoSocial(rs.getString("razao_social_cliente"));
                cliente.setCnpj(rs.getString("cnpj"));

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

    public String buscaNomeCliente(ClienteJuridico clij) {
        Connection conexao = ConexaoMySql.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String nome = null;
        String sql = "SELECT (nome_fantazia_cliente) FROM tb_clientes_juridico WHERE cod_cliente = ?;";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, clij.getCod());
            rs = stmt.executeQuery();

            while (rs.next()) {
                nome = rs.getString("nome_fantazia_cliente");
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
