package br.model.entity;

public class Administrador {
    private int id;
    private String nome;
    private String loggin;
    private String senha;

    public Administrador(String loggin,String nome,String senha) {

        this.nome = nome;
        this.loggin = loggin;
        this.senha = senha;
        
    }

     public Administrador(int idr,String nome,String loggin,String senha) {
        this.id = idr;
        this.nome = nome;
        this.loggin = loggin;
        this.senha = senha;
        
    }

    public Administrador(int id) {
        this.id = id;
    }

    public Administrador() {
        this.loggin = "";
        this.nome = "";
        this.senha="";
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLoggin() {
        return loggin;
    }

    public void setLoggin(String loggin) {
        this.loggin = loggin;
    }
    
     public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
    

