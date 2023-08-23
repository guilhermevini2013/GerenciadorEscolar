package view.paineis;

import models.Professores;
import view.frame.AdicionarDiciplina;
import view.frame.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CadastroProfessor extends JPanel {

    private JTextField jtfNome , tsalario, jtfCpf, jtfData;
    private JButton jbCadastrar;
    private ImageIcon imagem;
    private JLabel limg;
    private JComboBox<String> combo = new JComboBox<>();
    public CadastroProfessor() {
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,17);
        imagem = new ImageIcon(getClass().getResource("/resurce/professor.png"));
        limg = new JLabel(imagem);
        for (String teste:AdicionarDiciplina.diciplinas) {
            combo.addItem(teste);
        }
        jtfCpf = new JTextField();
        add(jtfCpf);
        jtfData = new JTextField();
        add(jtfData);
        tsalario = new JTextField();
        add(tsalario);
        jtfNome = new JTextField();
        add(jtfNome);
        jbCadastrar = new JButton();
        jbCadastrar.setOpaque(false);
        jbCadastrar.setBackground(new Color(0,0,0,0));
        jbCadastrar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtfNome.setOpaque(false);
        jtfNome.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jtfNome.setFont(font);
        jtfData.setOpaque(false);
        jtfData.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jtfData.setFont(font);
        jtfCpf.setOpaque(false);
        jtfCpf.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jtfCpf.setFont(font);
        tsalario.setOpaque(false);
        tsalario.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(combo);
        add(jbCadastrar);
        add(limg);
        limg.setBounds(0,0,800,500);
        jtfNome.setBounds(190 , 142, 130 , 25);
        jtfCpf.setBounds(168, 173, 150, 25);
        tsalario.setBounds(210, 240, 100, 20);
        jtfData.setBounds(180, 205, 140, 25);
        jbCadastrar.setBounds(180, 345, 110, 30);
        combo.setBounds(215,271,100,20);
    }

    private void criarEventos() {

        jbCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = jtfNome.getText();
                String cpf = jtfCpf.getText();
                int data = Integer.parseInt(jtfData.getText());
                double salario = Double.parseDouble(tsalario.getText());
                Random random = new Random();
                int nif = random. nextInt(1000);
                try {
                    String itemSelecionado = combo.getSelectedItem().toString();
                    System.out.println(itemSelecionado);
                    Principal.professores.add(new Professores(nome,cpf,data,salario,nif,itemSelecionado));
                }catch (NullPointerException ex){

                }

            }
        });

    }

}
