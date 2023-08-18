package models;

public class Professores extends Funcionarios{
    private int nif;
    private String diciplina;
    public Professores(String nome, String cpf, int data, double salario,int nif,String diciplina) {
        super(nome, cpf, data, salario);
        this.nif=nif;
        this.diciplina=diciplina;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getDiciplina() {
        return diciplina;
    }

    public void setDiciplina(String diciplina) {
        this.diciplina = diciplina;
    }
}
