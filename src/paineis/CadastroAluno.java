package paineis;

import models.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CadastroAluno extends JPanel {

    JLabel limg;
    JTextField jtfNome , dataMatricula, jtfCpf, numeroMatricula, url, jtfSerie;
    JButton jbCadastrar;

    private ImageIcon imagem;

    List<Aluno> alunoList;

    public CadastroAluno(List<Aluno> alunoList) {
        setLayout(null);
        this.alunoList=alunoList;
        Color minhaCor = new Color(135,206,250);
        setBackground(minhaCor);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,17);
        imagem = new ImageIcon(getClass().getResource("/resurce/aluno.png"));
        limg = new JLabel(imagem);


        jtfCpf = new JTextField();
        add(jtfCpf);

        numeroMatricula = new JTextField();
        add(numeroMatricula);
        dataMatricula = new JTextField();
        add(dataMatricula);

        jtfNome = new JTextField();
        add(jtfNome);

        url = new JTextField();
        add(url);

        jtfSerie = new JTextField();
        add(jtfSerie);

        jbCadastrar = new JButton("");
        add(jbCadastrar);
        add(limg);
        jbCadastrar.setOpaque(false);
        jbCadastrar.setBackground(new Color(0,0,0,0));
        jbCadastrar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtfCpf.setOpaque(false);
        jtfCpf.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jtfCpf.setFont(font);
        numeroMatricula.setOpaque(false);
        numeroMatricula.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        numeroMatricula.setFont(font);
        jtfNome.setOpaque(false);
        jtfNome.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jtfNome.setFont(font);
        dataMatricula.setOpaque(false);
        dataMatricula.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        dataMatricula.setFont(font);
        jtfSerie.setOpaque(false);
        jtfSerie.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jtfSerie.setFont(font);
        url.setOpaque(false);
        url.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        url.setFont(font);

        jtfNome.setBounds(190 , 125, 180 , 30);
        jtfCpf.setBounds(180, 167, 170, 30);
        dataMatricula.setBounds(275, 250, 90, 30);
        jtfSerie.setBounds(185, 210, 45, 30);
        numeroMatricula.setBounds(281, 295, 90, 30);
        url.setBounds(220, 333, 150, 30);
        jbCadastrar.setBounds(170, 385, 180, 40);
        limg.setBounds(0,0,800,500);
    }

    private void criarEventos() {

        jbCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = jtfNome.getText();
                String cpf=jtfCpf.getText();
                int data=Integer.parseInt(dataMatricula.getText());
                long matricula=Long.parseLong(numeroMatricula.getText());
                int anoEscolar=Integer.parseInt(jtfSerie.getText());
                String urlFoto=url.getText();
                alunoList.add(new Aluno(nome,cpf,data,matricula,anoEscolar,urlFoto));
            }
        });

    }

}
