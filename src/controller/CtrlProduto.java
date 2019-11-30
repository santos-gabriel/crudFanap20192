package controller;

import java.util.ArrayList;
import java.util.List;
import model.bean.Produto;
import model.dao.ProdutoDAO;

public class CtrlProduto {

//MÉTODOS
    public static void salvar(Produto produto) {
        ProdutoDAO produtoDao = new ProdutoDAO();
        produtoDao.salvar(produto);
    }

    public static void editar(Produto produto) {
        ProdutoDAO produtoDao = new ProdutoDAO();
        produtoDao.editar(produto);
    }

    public static void excluir(Produto produto) {
        ProdutoDAO produtoDao = new ProdutoDAO();
        produtoDao.Excluir(produto);
    }

    public static List<Produto> listar() {
        ProdutoDAO produtoDao = new ProdutoDAO();
        List<Produto> lista = new ArrayList<>();

        for (Produto prod : produtoDao.listar()) {
            lista.add(prod);
        }

        return lista;
    }

    public static Produto buscaProduto(Produto p) {
        ProdutoDAO produtoDao = new ProdutoDAO();
        return produtoDao.consultaProduto(p);
    }

}
