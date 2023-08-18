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
    private JMenu jmAluno,jmOpcoes;
    private ImageIcon imagem;
    JLabel limg;
    private JMenuItem jmiCadastroAluno, jmiMostrarAluno, jmiAtualizarAluno,jmiSair;
    public static List<Aluno> alunoList= new ArrayList<>();
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
        imagem = new ImageIcon(getClass().getResource("/resurce/logo.png"));
        limg = new JLabel(imagem);
        jmbBarra = new JMenuBar();
        setJMenuBar(jmbBarra);
        jmAluno = new JMenu("Aluno");
        jmOpcoes = new JMenu("Opções");
        jmbBarra.add(jmAluno);
        jmbBarra.add(jmOpcoes);

        jmiAtualizarAluno = new JMenuItem("Atualizar"); //
        jmiCadastroAluno = new JMenuItem("Cadastrar");//
        jmiMostrarAluno = new JMenuItem("Mostrar");//
        jmiSair = new JMenuItem("Sair");
        add(limg);
        jmAluno.add(jmiCadastroAluno);
        jmAluno.add(jmiMostrarAluno);//
        jmAluno.add(jmiAtualizarAluno);
        jmAluno.add(jmiMostrarAluno);
        jmOpcoes.add(jmiSair);
        limg.setBounds(0,0,800,500);

    }

    private void criarEventos() {
        jmiAtualizarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
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
                }catch (Exception a){
                }
            }
        });
        jmiCadastroAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroAluno cadastro_aluno = new CadastroAluno();
                getContentPane().removeAll();
                getContentPane().add(cadastro_aluno);
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

    }

    public static void main(String[] args) {
        TelaAluno tela = new TelaAluno("ESCOLA",alunoList);
        tela.setVisible(true);
    }

}
