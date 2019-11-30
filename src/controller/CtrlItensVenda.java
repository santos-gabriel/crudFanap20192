package controller;

import java.util.ArrayList;
import java.util.List;
import model.bean.ItensVenda;
import model.dao.ItensVendaDAO;

public class CtrlItensVenda {

    public static void salvar(ItensVenda iv) {
        ItensVendaDAO ivDao = new ItensVendaDAO();
        ivDao.salvar(iv);
    }

    public static List<ItensVenda> listar() {
        ItensVendaDAO ivDao = new ItensVendaDAO();
        List<ItensVenda> lista = new ArrayList<>();

        for (ItensVenda iv : ivDao.listar()) {
            lista.add(iv);
        }
        return lista;
    }

    public static void deletarTodasColunas() {
        ItensVendaDAO ivDao = new ItensVendaDAO();
        ivDao.deletarTodasColunas();
    }
}
