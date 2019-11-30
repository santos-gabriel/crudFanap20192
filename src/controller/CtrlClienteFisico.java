package controller;

import java.util.ArrayList;
import java.util.List;
import model.bean.ClienteFisico;
import model.dao.ClienteFisicoDAO;

public class CtrlClienteFisico {

    public static void salvar(ClienteFisico cliente) {
        ClienteFisicoDAO cliDao = new ClienteFisicoDAO();
        cliDao.salvar(cliente);
    }

    public static void editar(ClienteFisico cliente) {
        ClienteFisicoDAO cliDao = new ClienteFisicoDAO();
        cliDao.editar(cliente);
    }

    public static void excluir(ClienteFisico cliente) {
        ClienteFisicoDAO cliDao = new ClienteFisicoDAO();
        cliDao.Excluir(cliente);
    }

    public static List<ClienteFisico> listar() {
        ClienteFisicoDAO cliDao = new ClienteFisicoDAO();
        List<ClienteFisico> lista = new ArrayList<>();

        for (ClienteFisico cli : cliDao.listar()) {
            lista.add(cli);
        }

        return lista;

    }

    public static String buscaNome(ClienteFisico clif) {
        ClienteFisicoDAO cliDao = new ClienteFisicoDAO();
        return cliDao.buscaNome(clif);
    }

}
