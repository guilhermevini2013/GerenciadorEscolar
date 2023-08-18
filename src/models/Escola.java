package models;

public abstract class Escola {
    private String nome;
    private String cpf;
    private int data;

    public Escola(String nome, String cpf, int data) {
        this.nome = nome;
        this.cpf = cpf;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
