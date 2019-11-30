package controller;

import java.util.ArrayList;
import java.util.List;
import model.bean.Venda;
import model.dao.VendaDAO;

public class CtrlVenda {

    public static void salvar(Venda v) {
        VendaDAO vDao = new VendaDAO();
        vDao.salvar(v);
    }

    public static List<Venda> listar() {
        VendaDAO vDao = new VendaDAO();
        List<Venda> lista = new ArrayList<>();

        for (Venda v : vDao.listar()) {
            lista.add(v);
        }
        return lista;
    }

    public static Integer buscaUltimoCodigo() {
        VendaDAO vDao = new VendaDAO();
        return vDao.consultarProximoCodigo();
    }

    public static void deletarTodasColunas() {
        VendaDAO vDao = new VendaDAO();
        vDao.deletarTodasColunas();
    }

}
