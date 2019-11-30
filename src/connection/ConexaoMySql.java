package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoMySql {

    private static final String URL_BANCO = "jdbc:mysql://localhost:3306/vendastech";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection conectar() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL_BANCO, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão! ");
            System.out.println(ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado! ");
            System.out.println(e);
        }
        return null;
    }

    public static void fecharConexao(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão! ");
                System.out.println(ex);
            }
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement ps) {
        ConexaoMySql.fecharConexao(con);
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão! ");
                System.out.println(ex);
            }
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement ps, ResultSet rs) {
        fecharConexao(con, ps);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão! ");
                System.out.println(ex);
            }
        }
    }

}
