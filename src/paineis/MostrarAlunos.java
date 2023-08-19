package paineis;

import models.Aluno;
import view.TelaAluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MostrarAlunos extends JPanel {
    JButton jbMostrar;
    JLabel limg,limg2,lnome,lcpf,lserie;

    private JTextField tprocurar;
    private ImageIcon imagem,imagem2;
    private JButton binf;

    public MostrarAlunos() {
        setSize(500,650);
        setLayout(null);
        Color minhaCor = new Color(135,206,250);
        setBackground(minhaCor);
        iniciarComponentes();
        criarEventos();
    }
    private void iniciarComponentes() {
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,17);
        imagem = new ImageIcon(getClass().getResource("/resurce/procurar.png"));
        limg = new JLabel(imagem);
        imagem2 = new ImageIcon(getClass().getResource("/resurce/inf.png"));
        limg2 = new JLabel(imagem2);
        jbMostrar = new JButton();
        jbMostrar.setOpaque(false);
        jbMostrar.setBackground(new Color(0,0,0,0));
        jbMostrar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbMostrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tprocurar= new JTextField();
        tprocurar.setOpaque(false);
        tprocurar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tprocurar.setFont(font);
        lnome = new JLabel();
        lcpf = new JLabel();
        lserie = new JLabel();
        binf = new JButton();
        binf.setOpaque(false);
        binf.setBackground(new Color(0,0,0,0));
        binf.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        binf.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(binf);
        add(lserie);
        add(lcpf);
        add(lnome);
        add(tprocurar);
        add(jbMostrar);
        add(limg2);
        add(limg);
        lserie.setBounds(383,245,100,30);
        lcpf.setBounds(375,213,200,30);
        lnome.setBounds(388,182,300,30);
        jbMostrar.setBounds(330, 115, 140, 25);
        limg.setBounds(0,-50,800,500);
        tprocurar.setBounds(320,77,160,30);
        for (Aluno aluno:TelaAluno.alunoList) {
            System.out.println(aluno.getNome());
        }
    }
    private void criarEventos() {

        jbMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //MOSTRA ALUNO
                if (!tprocurar.getText().isEmpty()){
                    long numeroAluno = Long.parseLong(tprocurar.getText());
                    boolean achou = false;
                    for (Aluno aluno:TelaAluno.alunoList) {
                        if (aluno.getMatricula()==numeroAluno){
                            lnome.setText(aluno.getNome());
                            lcpf.setText(aluno.getCpf());
                            lserie.setText(String.valueOf(aluno.getAnoEscolar())+" ANO");
                            lserie.setBounds(383,245,100,30);
                            lcpf.setBounds(375,213,200,30);
                            lnome.setBounds(388,182,300,30);
                            limg2.setBounds(180,140,450,160);
                            binf.setBounds(528,205,34,34);
                            achou=true;
                            break;
                        }
                    }
                    if (achou==false){
                        JOptionPane.showMessageDialog(null,"ALUNO NAO ENCONTRADO");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"PREENCHA TODOS OS CAMPOS");
                }
            }
        });
        binf.addActionListener(new ActionListener() {
            //MOSTRA A INFORMACAO DO ALUNO
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean achou = false;
                String nomeAluno = lnome.getText();
                for (Aluno aluno:TelaAluno.alunoList) {
                    if (aluno.getNome().contains(nomeAluno)){
                        JOptionPane.showMessageDialog(null,aluno.mostrarDados());
                        achou=true;
                        break;
                    }
                }
            }
        });

    }
}



