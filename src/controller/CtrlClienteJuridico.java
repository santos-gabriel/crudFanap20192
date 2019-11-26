package controller;

import java.util.ArrayList;
import java.util.List;
import model.bean.ClienteJuridico;
import model.dao.ClienteJuridicoDAO;

public class CtrlClienteJuridico {

    public static void salvar(ClienteJuridico cliente) {
        ClienteJuridicoDAO cliDao = new ClienteJuridicoDAO();
        cliDao.salvar(cliente);
    }

    public static void editar(ClienteJuridico cliente) {
        ClienteJuridicoDAO cliDao = new ClienteJuridicoDAO();
        cliDao.editar(cliente);
    }

    public static void excluir(ClienteJuridico cliente) {
        ClienteJuridicoDAO cliDao = new ClienteJuridicoDAO();
        cliDao.Excluir(cliente);
    }

    public static List<ClienteJuridico> listar() {
        ClienteJuridicoDAO cliDao = new ClienteJuridicoDAO();
        List<ClienteJuridico> lista = new ArrayList<>();

        for (ClienteJuridico cli : cliDao.listar()) {
            lista.add(cli);
        }

        return lista;

    }

}
