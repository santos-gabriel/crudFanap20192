package model.bean;

import java.util.Date;

public class Venda {

//ATRIBUTOS
    private int cod;
    private int codCliente;
    private int codProduto;
    private Date dtVenda;
    private double valorDesconto;
    private double valorBruto;
    private double valorLiquido;
    private int quantidade;

//CONSTRUTORES
    public Venda() {
    }

    public Venda(int codCliente, int codProduto, Date dtVenda, double valorDesconto, double valorBruto, double valorLiquido, int quantidade) {
        setCodCliente(codCliente);
        setCodProduto(codProduto);
        setDtVenda(dtVenda);
        setValorDesconto(valorDesconto);
        setValorBruto(valorBruto);
        setValorLiquido(valorLiquido);
        setQuantidade(quantidade);
    }

    public Venda(int cod, int codCliente, int codProduto, Date dtVenda, double valorDesconto, double valorBruto, double valorLiquido, int quantidade) {
        setCod(cod);
        setCodCliente(codCliente);
        setCodProduto(codProduto);
        setDtVenda(dtVenda);
        setValorDesconto(valorDesconto);
        setValorBruto(valorBruto);
        setValorLiquido(valorLiquido);
        setQuantidade(quantidade);
    }

//GETERS E SETERS
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public Date getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
