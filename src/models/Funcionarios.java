package models;

public class Funcionarios extends Escola implements FuncionarioUtil{
    private double salario;
    private long telefone;

    public Funcionarios(String nome, String cpf, int data,double salario,long telefone) {
        super(nome, cpf, data);
        this.salario=salario;
        this.telefone=telefone;
    }
    public double getSalario() {
        return salario;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    @Override
    public double setSalario(double salario) {
        this.salario=salario;
        return this.salario;
    }
    @Override
    public double calculaBonificacao(Funcionarios funcionarioUtil) {
        double totalBonifica =  funcionarioUtil.getSalario();
       totalBonifica= totalBonifica+100;
        return totalBonifica;
    }
}
