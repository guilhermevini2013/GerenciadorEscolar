package paineis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelPesquisarAluno extends JPanel {
    private JButton jbPesquisar;
    private JTextField jtfCampoPesquisa;
    public PainelPesquisarAluno() {
        super();
        setSize(500, 650);
        setLayout(null);
        Color minhaCor = new Color(135, 206, 250);
        setBackground(minhaCor);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jbPesquisar = new JButton("Pesquisar");
        jtfCampoPesquisa = new JTextField();

        add(jbPesquisar);
        add(jtfCampoPesquisa);

        jtfCampoPesquisa.setBounds(20, 20, 250, 50);
        jbPesquisar.setBounds(290, 20, 130, 20);
    }

    private void criarEventos() {
        jbPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                jtaMostrar.setText("Cadastros de Alunos\n\n");
//                for (Conta conta : contas) {
//                    jtaMostrar.append(conta.mostrarDados() + "\n\n");
//                }
            }
        });
    }
}




