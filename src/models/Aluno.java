package models;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aluno extends Escola implements AlunoUtil {
    private long matricula;
    private int anoEscolar;
    private  List<Double> nota;
    private String urlFoto;

    public Aluno(String nome, String cpf, int data,long matricula,int anoEscolar,String urlFoto) {
        super(nome, cpf, data);
        this.matricula=matricula;
        this.anoEscolar=anoEscolar;
        this.urlFoto=urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setNota(List<Double> nota) {
        this.nota = nota;
    }

    public List<Double> getNota() {
        return nota;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public int getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(int anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public double notasMedia(List<Double> notas) {
        double totalMedia=0;
        for (Double nota:notas) {
            totalMedia+=nota;
            System.out.println(totalMedia);
        }
        totalMedia=totalMedia/notas.size();
        return totalMedia;
    }

    @Override
    public boolean getaprovacao() {
        if (notasMedia(this.nota)>=6){
            return true;
        }
        return false;
    }
    public String mostrarDados(){
        return "\nNome: "+super.getNome()+
                "\nCPF: "+super.getCpf()+
                "\nSerie: "+this.anoEscolar+" ANO"+
                "\nData de Matricula: "+super.getData()+
                "\nNumero: "+this.matricula;
    }
}
