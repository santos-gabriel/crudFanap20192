package controller;

import java.util.ArrayList;
import java.util.List;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

public class CtrlUsuario {

//MÉTODOS
    public static void salvar(Usuario usuario) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        usuarioDao.salvar(usuario);
    }

    public static void editar(Usuario usuario) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        usuarioDao.editar(usuario);
    }

    public static void excluir(Usuario usuario) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        usuarioDao.Excluir(usuario);
    }

    public static List<Usuario> listar() {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        List<Usuario> lista = new ArrayList<>();

        for (Usuario user : usuarioDao.listar()) {
            lista.add(user);
        }

        return lista;
    }

}
