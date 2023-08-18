package paineis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarAlunos extends JPanel {
    JButton jbMostrar;
    JTextArea jtaTelinhaMostrar;
    JScrollPane jspScrollTelinha;

    public MostrarAlunos() {
        setSize(500,650);
        setLayout(null);
        Color minhaCor = new Color(135,206,250);
        setBackground(minhaCor);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jbMostrar = new JButton("Mostrar");
        add(jbMostrar);

        jtaTelinhaMostrar = new JTextArea();
        add(jtaTelinhaMostrar);

        jspScrollTelinha = new JScrollPane(jtaTelinhaMostrar);
        add(jspScrollTelinha);

        jbMostrar.setBounds(200, 20, 100, 30);

        jspScrollTelinha.setBounds( 60, 60, 365, 365 );

    }

    private void criarEventos() {

        jbMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}



