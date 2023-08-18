package paineis;

import models.Aluno;
import view.TelaAluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AdicionarNotas extends JPanel {

    JButton bsalvar;
    private ImageIcon imagem;
    private JTextField tn1,tn2,tn3;
    JLabel limg;
    Aluno aluno;

    public AdicionarNotas(Aluno aluno) {
        setSize(500,650);
        this.aluno=aluno;
        setLayout(null);
        Color minhaCor = new Color(135,206,250);
        setBackground(minhaCor);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,13);
        imagem = new ImageIcon(getClass().getResource("/resurce/adcNotas.png"));
        limg = new JLabel(imagem);
        tn1=new JTextField();
        tn1.setOpaque(false);
        tn1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tn1.setFont(font);
        tn2=new JTextField();
        tn2.setOpaque(false);
        tn2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tn2.setFont(font);
        tn3=new JTextField();
        tn3.setOpaque(false);
        tn3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tn3.setFont(font);
        bsalvar = new JButton("");
        bsalvar.setOpaque(false);
        bsalvar.setBackground(new Color(0,0,0,0));
        bsalvar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bsalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(tn1);
        add(tn2);
        add(tn3);
        add(bsalvar);
        add(limg);
        tn1.setBounds(550,158,30,25);
        tn2.setBounds(550,203,30,25);
        tn3.setBounds(550,248,30,25);
        bsalvar.setBounds(490,315,150,30);
        limg.setBounds(0,0,800,500);
    }

    private void criarEventos() {

        bsalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Double> notas = new ArrayList<>();
                notas.add(Double.parseDouble(tn1.getText()));
                notas.add(Double.parseDouble(tn2.getText()));
                notas.add(Double.parseDouble(tn3.getText()));
                aluno.setNota(notas);
            }
        });

    }

}
