package model.bean;

public class Cliente {

//ATRIBUTOS
    private int cod;
    private String nome;

//CONSTRUTORES
    public Cliente() {
    }

    public Cliente(String nome) {
        setNome(nome);
    }

    public Cliente(int cod, String nome) {
        setCod(cod);
        setNome(nome);
    }

//GETERS E SETERS
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
