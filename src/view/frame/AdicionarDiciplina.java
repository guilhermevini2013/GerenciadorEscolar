package view.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AdicionarDiciplina extends JFrame {
    private ImageIcon imagem;
    private JButton benviar;
    private JTextField tnome;
    JLabel limg;
    public static List<String> diciplinas = new ArrayList<>();
    public AdicionarDiciplina(String title) throws HeadlessException {
        super(title);
        setSize(480, 330);
        setResizable(false); // Desabilitar redimensionamento
        setLocationRelativeTo(getContentPane());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,17);
        imagem = new ImageIcon(getClass().getResource("/resurce/dici.png"));
        limg = new JLabel(imagem);
        benviar = new JButton();
        benviar.setOpaque(false);
        benviar.setBackground(new Color(0,0,0,0));
        benviar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        benviar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tnome = new JTextField();
        tnome.setOpaque(false);
        tnome.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tnome.setFont(font);
        add(tnome);
        add(benviar);
        add(limg);
        limg.setBounds(0,0,800,500);
        benviar.setBounds(295,150,100,30);
        tnome.setBounds(285,114,130,25);
    }

    private void criarEventos() {
        benviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tnome.getText().isEmpty()){
                    String nomeDiciplina = tnome.getText();
                    diciplinas.add(nomeDiciplina);
                }else {
                    JOptionPane.showMessageDialog(null,"PREENCHA TODOS OS CAMPOS");
                }
            }
        });
    }
}
