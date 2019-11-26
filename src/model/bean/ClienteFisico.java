package model.bean;

public class ClienteFisico extends Cliente {

//ATRIBUTOS
    private String sobrenome;
    private String cpf;

//CONSTRUTORES
    public ClienteFisico() {
    }

    public ClienteFisico(String nome, String sobrenome, String cpf) {
        super(nome);
        setSobrenome(sobrenome);
        setCpf(cpf);
    }

    public ClienteFisico(int cod, String nome, String sobrenome, String cpf) {
        super(cod, nome);
        setSobrenome(sobrenome);
        setCpf(cpf);
    }
//GETERS E SETERS

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
