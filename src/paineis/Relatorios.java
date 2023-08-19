package paineis;

import models.Aluno;
import view.TelaAluno;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Relatorios extends JPanel {
    private JTextArea taRelatorio1,taRelatorio2;
    private ImageIcon imagem;
    JLabel limg;
    public Relatorios() {
        super();
        setSize(500, 650);
        setLayout(null);
        Color minhaCor = new Color(135, 206, 250);
        setBackground(minhaCor);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        imagem = new ImageIcon(getClass().getResource("/resurce/rela.png"));
        limg = new JLabel(imagem);
        taRelatorio1 = new JTextArea();
        taRelatorio1.setOpaque(false);
        taRelatorio1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        taRelatorio2 = new JTextArea();
        taRelatorio2.setOpaque(false);
        taRelatorio2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        taRelatorio2.setLineWrap(true);
        taRelatorio1.setLineWrap(true);
        add(taRelatorio2);
        add(taRelatorio1);
        add(limg);
        taRelatorio1.setBounds(60, 160, 205, 200);
        taRelatorio2.setBounds(535, 160, 205, 200);
        limg.setBounds(0,0,800,500);
    }
    private void criarEventos() {
        //GERA RELATORIOS AUTOMATICAMENTE
        //EXIBIR NOTAS
        for (Aluno aluno:TelaAluno.alunoList) {
            try {
                taRelatorio1.append("ALUNO "+aluno.getNome()+" "+aluno.getaprovacao()+ "\nNOTAS: "+aluno.getNota().stream().sorted().collect(Collectors.toList())+"\n\n");
            }catch (Exception a){
            }
        }
        //EXIBIR MEDIAS
        List<Double> mediasTodas = new ArrayList<>();
        for (Aluno aluno:TelaAluno.alunoList) {

            try {
                mediasTodas.add(aluno.notasMedia(aluno.getNota()));
            }catch (Exception a){
            }
        }
        mediasTodas.stream().sorted().collect(Collectors.toList());
        taRelatorio2.append(mediasTodas.stream().sorted().collect(Collectors.toList()).toString());
    }
}




