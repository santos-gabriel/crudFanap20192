package model.bean;

public class ClienteJuridico extends Cliente {

//ATRIBUTOS
    private String razaoSocial;
    private String cnpj;

//CONSTRUTORES
    public ClienteJuridico() {
    }

    public ClienteJuridico(String nome, String razaoSocial, String cnpj) {
        super(nome);
        setRazaoSocial(razaoSocial);
        setCnpj(cnpj);
    }

    public ClienteJuridico(int cod, String nome, String razaoSocial, String cnpj) {
        super(cod, nome);
        setRazaoSocial(razaoSocial);
        setCnpj(cnpj);
    }
//GETERS E SETERS

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
