package view;

import models.Aluno;
import paineis.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaAluno extends JFrame {

    private JMenuBar jmbBarra;
    private JMenu jmAluno, jmFuncionario, jmMostrar, jmPesquisar, jmOpcoes;
    private JMenuItem jmiCadastroAluno, jmiMostrarAluno, jmiAtualizarAluno,
            jmiRemoverAluno, jmiCadastrarFuncionario,
            jmiMostrarFuncionario, jmiAtualizarFuncionario, jmiRemoverFuncionario, jmiPesquisarAluno,
            jmiPesquisarFuncionario, jmiSair;
    static List<Aluno> alunoList= new ArrayList<>();
    public TelaAluno(String title, List<Aluno> alunoList) throws HeadlessException {
        super(title);
        setSize(800, 500);
        setResizable(false); // Desabilitar redimensionamento
        Color minhaCor = new Color(135, 206, 250);
        getContentPane().setBackground(minhaCor);
        setLocationRelativeTo(getContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jmbBarra = new JMenuBar();
        setJMenuBar(jmbBarra);
        jmAluno = new JMenu("Aluno");
        jmFuncionario = new JMenu("Funcionário");
        jmMostrar = new JMenu("Mostrar");
        jmPesquisar = new JMenu("Pesquisar");
        jmOpcoes = new JMenu("Opções");

        jmbBarra.add(jmAluno);
        jmbBarra.add(jmFuncionario);
        jmbBarra.add(jmMostrar);
        jmbBarra.add(jmPesquisar);
        jmbBarra.add(jmOpcoes);

        jmiAtualizarAluno = new JMenuItem("Atualizar"); //
        jmiPesquisarAluno = new JMenuItem("Aluno");
        jmiPesquisarFuncionario = new JMenuItem("Funcionário");
        jmiAtualizarFuncionario = new JMenuItem("Atualizar");
        jmiRemoverAluno = new JMenuItem("Remover");//
        jmiRemoverFuncionario = new JMenuItem("Remover");
        jmiCadastroAluno = new JMenuItem("Cadastrar");//
        jmiCadastrarFuncionario = new JMenuItem("Cadastrar");
        jmiMostrarAluno = new JMenuItem("Aluno");//
        jmiMostrarFuncionario = new JMenuItem("Funcionário");
        jmiSair = new JMenuItem("Sair");

        jmAluno.add(jmiCadastroAluno);
        jmAluno.add(jmiMostrarAluno);//
        jmAluno.add(jmiAtualizarAluno);
        jmAluno.add(jmiRemoverAluno);

        jmFuncionario.add(jmiCadastrarFuncionario);
        jmFuncionario.add(jmiAtualizarFuncionario);
        jmFuncionario.add(jmiRemoverFuncionario);

        jmMostrar.add(jmiMostrarAluno);
        jmMostrar.add(jmiMostrarFuncionario);

        jmPesquisar.add(jmiPesquisarAluno);
        jmPesquisar.add(jmiPesquisarFuncionario);

        jmOpcoes.add(jmiSair);

    }

    private void criarEventos() {
        jmiAtualizarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long numeroMatricula = Long.parseLong(JOptionPane.showInputDialog("ESCREVA O NUMERO DA MATRICULA DO ALUNO"));
                boolean achou=false;
                for (Aluno aluno:alunoList) {
                    if (aluno.getMatricula()==numeroMatricula){
                        AtualizarAluno atualizarAluno_aluno = new AtualizarAluno(aluno);
                        getContentPane().removeAll();
                        getContentPane().add(atualizarAluno_aluno);
                        getContentPane().validate();
                        repaint();
                        achou=true;
                        break;
                    }
                }
                if (achou==false){
                    JOptionPane.showMessageDialog(null,"ALUNO NAO ENCONTRADO");
                }

            }
        });
        jmiCadastroAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroAluno cadastro_aluno = new CadastroAluno(alunoList);
                getContentPane().removeAll();
                getContentPane().add(cadastro_aluno);
                getContentPane().validate();
                repaint();

            }
        });

        jmiCadastrarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroFuncionario cadastro_funcionario = new CadastroFuncionario();
                getContentPane().removeAll();
                getContentPane().add(cadastro_funcionario);
                getContentPane().validate();
                repaint();
            }
        });

        jmiMostrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarAlunos mostrar_alunos = new MostrarAlunos();
                getContentPane().removeAll();
                getContentPane().add(mostrar_alunos);
                getContentPane().validate();
                repaint();
            }
        });

        jmiMostrarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarFuncionarios mostrar_funcionarios = new MostrarFuncionarios();
                getContentPane().removeAll();
                getContentPane().add(mostrar_funcionarios);
                getContentPane().validate();
                repaint();
            }
        });

    }

    public static void main(String[] args) {
        TelaAluno tela = new TelaAluno("ESCOLA",alunoList);
        tela.setVisible(true);
    }

}
