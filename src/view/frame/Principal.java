package view.frame;

import models.Aluno;
import models.Professores;
import view.paineis.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Principal extends JFrame {

    private JMenuBar jmbBarra;
    private JMenu jmAluno,mRelatorios,mEnsino,mFuncionarios;
    private ImageIcon imagem;
    JLabel limg;
    private JMenuItem jmiCadastroAluno, jmiMostrarAluno, jmiAtualizarAluno,miGerarRelatorio,miAdcNotas,miadcDiciplinas,miProfessor,micadastrarProfessor;
    public static List<Aluno> alunoList= new ArrayList<>();
    public static List<Professores> professores= new ArrayList<>();
    public Principal(String title, List<Aluno> alunoList) throws HeadlessException {
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
        mEnsino = new JMenu("Ensino");
        mFuncionarios = new JMenu("Funcionarios");
        jmbBarra = new JMenuBar();
        setJMenuBar(jmbBarra);
        jmAluno = new JMenu("Aluno");
        mRelatorios = new JMenu("Relatorios");
        jmbBarra.add(jmAluno);
        jmbBarra.add(mEnsino);
        jmbBarra.add(mRelatorios);
        jmbBarra.add(mFuncionarios);
        jmiAtualizarAluno = new JMenuItem("Atualizar"); //
        jmiCadastroAluno = new JMenuItem("Cadastrar");//
        miAdcNotas = new JMenuItem("Adicionar Notas");
        jmiMostrarAluno = new JMenuItem("Mostrar");//
        miGerarRelatorio = new JMenuItem("Gerar Relatorios");
        miadcDiciplinas = new JMenuItem("Adicionar Diciplina");
        miProfessor = new JMenu("Professor");
        micadastrarProfessor = new JMenuItem("Cadastrar");
        mFuncionarios.add(miProfessor);
        miProfessor.add(micadastrarProfessor);
        mRelatorios.add(miGerarRelatorio);
        mEnsino.add(miadcDiciplinas);
        jmAluno.add(jmiCadastroAluno);
        jmAluno.add(jmiAtualizarAluno);
        jmAluno.add(jmiMostrarAluno);
        jmAluno.add(miAdcNotas);
        add(limg);
        limg.setBounds(0,0,800,500);

    }

    private void criarEventos() {
        micadastrarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroProfessor cadastroProfessor = new CadastroProfessor();
                getContentPane().removeAll();
                getContentPane().add(cadastroProfessor);
                getContentPane().validate();
                repaint();
            }
        });
        miadcDiciplinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarDiciplina tela = new AdicionarDiciplina("ADICIONAR DICIPLINAS");
                tela.setVisible(true);
            }
        });
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
        miGerarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Relatorios relatorio_aluno = new Relatorios();
                getContentPane().removeAll();
                getContentPane().add(relatorio_aluno);
                getContentPane().validate();
                repaint();
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
        miAdcNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long numeroMatricula = Long.parseLong(JOptionPane.showInputDialog("ESCREVA O NUMERO DA MATRICULA DO ALUNO"));
                    boolean achou=false;
                    for (Aluno aluno:alunoList) {
                        if (aluno.getMatricula()==numeroMatricula){
                            AdicionarNotas NotasAluno_aluno = new AdicionarNotas(aluno);
                            getContentPane().removeAll();
                            getContentPane().add(NotasAluno_aluno);
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
        Principal tela = new Principal("ESCOLA",alunoList);
        tela.setVisible(true);
    }

}
