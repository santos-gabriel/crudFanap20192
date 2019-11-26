package model.bean;

public class Usuario {

//ATRIBUTOS
    private int cod;
    private String nome;
    private String email;
    private String login;
    private String senha;

//CONSTRUTORES
    public Usuario() {
    }

    public Usuario(int cod, String nome, String usuario, String email, String login, String senha) {
        setCod(cod);
        setNome(nome);
        setEmail(email);
        setLogin(login);
        setSenha(senha);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
