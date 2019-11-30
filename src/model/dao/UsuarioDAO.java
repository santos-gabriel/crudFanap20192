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
import model.bean.Usuario;

public class UsuarioDAO {

//ATRIBUTOS
    private Connection conexao = null;

//CONSTRUTOR
    public UsuarioDAO() {
        conexao = ConexaoMySql.conectar();
    }

//MÉTODOS
    public void salvar(Usuario usuario) {

        PreparedStatement stmt = null;
        String sql = "INSERT INTO tb_usuarios (nome_usuario, login_usuario, email_usuario, senha_usuario) VALUES (?, ?, ?, ?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());

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

    public void editar(Usuario usuario) {
        String sql = "UPDATE tb_usuarios SET nome_usuario = ?, login_usuario = ?, email_usuario = ?, senha_usuario = ? WHERE cod_usuario = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.setInt(5, usuario.getCod());

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

    public void Excluir(Usuario usuario) {

        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("DELETE FROM tb_usuarios WHERE cod_usuario = ?");
            stmt.setInt(1, usuario.getCod());

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

    public List<Usuario> listar() {
        Connection conexao = ConexaoMySql.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> listaUsuario = new ArrayList<>();
        try {

            stmt = conexao.prepareStatement("SELECT * FROM tb_usuarios");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setCod(rs.getInt("cod_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setLogin(rs.getString("login_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));

                listaUsuario.add(usuario);
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
        return listaUsuario;
    }

}
