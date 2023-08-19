package paineis;

import models.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarAluno extends JPanel {

    JLabel limg;
    JTextField jtfNome , jtfMatricula, jtfCpf, jtfData, url, jtfSerie;
    JButton batt;

    private ImageIcon imagem;

    Aluno aluno;

    public AtualizarAluno(Aluno aluno) {
        setLayout(null);
        this.aluno=aluno;
        Color minhaCor = new Color(135,206,250);
        setBackground(minhaCor);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,17);
        imagem = new ImageIcon(getClass().getResource("/resurce/aluno.png"));
        limg = new JLabel(imagem);
        jtfSerie = new JTextField(String.valueOf(aluno.getAnoEscolar()));
        add(jtfSerie);

        jtfCpf = new JTextField(aluno.getCpf());
        add(jtfCpf);

        jtfData = new JTextField(String.valueOf(aluno.getMatricula()));
        add(jtfData);
        jtfMatricula = new JTextField(String.valueOf(aluno.getData()));
        add(jtfMatricula);

        jtfNome = new JTextField(aluno.getNome());
        add(jtfNome);

        url = new JTextField(aluno.getUrlFoto());
        add(url);

        batt = new JButton("");
        add(batt);
        add(limg);
        batt.setOpaque(false);
        batt.setBackground(new Color(0,0,0,0));
        batt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        batt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtfCpf.setOpaque(false);
        jtfCpf.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jtfCpf.setFont(font);
        jtfData.setOpaque(false);
        jtfData.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jtfData.setFont(font);
        jtfNome.setOpaque(false);
        jtfNome.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jtfNome.setFont(font);
        jtfMatricula.setOpaque(false);
        jtfMatricula.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jtfMatricula.setFont(font);
        jtfSerie.setOpaque(false);
        jtfSerie.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jtfSerie.setFont(font);
        url.setOpaque(false);
        url.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        url.setFont(font);

        jtfNome.setBounds(190 , 125, 180 , 30);
        jtfCpf.setBounds(180, 167, 170, 30);
        jtfMatricula.setBounds(275, 250, 90, 30);
        jtfSerie.setBounds(185, 210, 45, 30);
        jtfData.setBounds(281, 295, 90, 30);
        url.setBounds(220, 333, 150, 30);
        batt.setBounds(170, 385, 180, 40);
        limg.setBounds(0,0,800,500);
    }

    private void criarEventos() {

        batt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ALTERAR INFORMACAO DO ALUNO
                aluno.setNome(jtfNome.getText());
                aluno.setCpf(jtfCpf.getText());
                aluno.setData(Integer.parseInt(jtfData.getText()));
                aluno.setMatricula(Long.parseLong(jtfMatricula.getText()));
                aluno.setAnoEscolar(Integer.parseInt(jtfSerie.getText()));
                aluno.setUrlFoto(url.getText());
                JOptionPane.showMessageDialog(null,"ALTERADO COM SUCESSO");
            }
        });

    }

}
