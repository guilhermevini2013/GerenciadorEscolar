package paineis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroFuncionario extends JPanel {

    JLabel jlNome, jlTelefone, jlCpf, jlData, jlSalario;
    JTextField jtfNome , jtfTelefone, jtfCpf, jtfData, jtfSalario;
    JButton jbCadastrar;

    public CadastroFuncionario() {
        setSize(500,650);
        setLayout(null);
        Color minhaCor = new Color(135,206,250);
        setBackground(minhaCor);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jlCpf = new JLabel("CPF do Funcinário");
        add(jlCpf);

        jtfCpf = new JTextField();
        add(jtfCpf);

        jlData = new JLabel("Data de matrícula");
        add(jlData);

        jtfData = new JTextField();
        add(jtfData);

        jlTelefone = new JLabel("Telefone");
        add(jlTelefone);

        jtfTelefone = new JTextField();
        add(jtfTelefone);

        jlNome = new JLabel("Nome do Funcionário");
        add(jlNome);

        jtfNome = new JTextField();
        add(jtfNome);

        jlSalario = new JLabel("Salário");
        add(jlSalario);

        jtfSalario = new JTextField();
        add(jtfSalario);

        jbCadastrar = new JButton("CADASTRAR");
        add(jbCadastrar);

        jlNome.setBounds(20, 40, 150, 20);
        jtfNome.setBounds(20 , 80, 150 , 20);

        jlCpf.setBounds(20, 120 , 150, 20);
        jtfCpf.setBounds(20, 160, 150, 20);

        jlTelefone.setBounds( 20, 200, 150,20);
        jtfTelefone.setBounds(20, 240, 150, 20);

        jlData.setBounds(200, 40, 150, 20);
        jtfData.setBounds(200, 80, 150, 20);

        jlSalario.setBounds(200, 120, 150, 20);
        jtfSalario.setBounds(200, 160, 150, 20);


        jbCadastrar.setBounds(100, 280, 140, 30);

    }

    private void criarEventos() {

        jbCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

}
