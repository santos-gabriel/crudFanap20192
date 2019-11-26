package model.bean;

public class Produto {

//ATRIBUTOS
    private int cod;
    private String desc;
    private double preco;
    private int quantidade;

//CONSTRUTORES
    public Produto() {
    }

    public Produto(String desc, double preco, int quantidade) {
        setDesc(desc);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public Produto(int cod, String desc, double preco, int quantidade) {
        setCod(cod);
        setDesc(desc);
        setPreco(preco);
        setQuantidade(quantidade);
    }

//GETERS E SETERS
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
