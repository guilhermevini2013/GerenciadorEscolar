package models;

public abstract class Funcionarios extends Gerenciaveis {
    private double salario;

    public Funcionarios(String nome, String cpf, int data,double salario) {
        super(nome, cpf, data);
        this.salario=salario;
    }
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
