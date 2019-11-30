package model.bean;

public class ItensVenda {

    //ATRIBUTOS
    private int codigo;
    private int codigoProduto;
    private int codVenda;
    private int QtdItensVenda;
    private double totalItensVenda;

    //CONSTRUTORES
    public ItensVenda() {
    }

    public ItensVenda(int codigo, int codigoProduto, int codVenda, int QtdItensVenda, double totalItensVenda) {
        this.codigo = codigo;
        this.codigoProduto = codigoProduto;
        this.codVenda = codVenda;
        this.QtdItensVenda = QtdItensVenda;
        this.totalItensVenda = totalItensVenda;
    }

    //GETERS E SETERS
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getQtdItensVenda() {
        return QtdItensVenda;
    }

    public void setQtdItensVenda(int QtdItensVenda) {
        this.QtdItensVenda = QtdItensVenda;
    }

    public double getTotalItensVenda() {
        return totalItensVenda;
    }

    public void setTotalItensVenda(double totalItensVenda) {
        this.totalItensVenda = totalItensVenda;
    }

}
