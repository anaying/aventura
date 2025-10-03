import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    JTextArea textArea;
    JButton[] botones= new JButton[4];
    int aristas = 0, escenarios = 0;
    Nodo nodo;
    String nombre;

    public Ventana(String nombre) {
        this.nombre = nombre;
        getContentPane().setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(400, 400));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFocusable(false);
        getContentPane().add(textArea, BorderLayout.CENTER);

        for (int i = 0; i < 4; i++) {
            botones[i] = new JButton();
            botones[i].setPreferredSize(new Dimension(150, 50));
            botones[i].setFocusable(false);
            botones[i].setVisible(true);
            botones[i].addActionListener(this);
        }
        getContentPane().add(botones[0], BorderLayout.NORTH);
        getContentPane().add(botones[1], BorderLayout.EAST);
        getContentPane().add(botones[2], BorderLayout.SOUTH);
        getContentPane().add(botones[3], BorderLayout.WEST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }


    void setNewStage(Nodo nodo, String texto) {
        this.nodo = nodo;
        if (!this.nodo.visitado) {
            escenarios++;
            this.nodo.visitado = true;
        }
        if (texto == null)
            textArea.setText(nodo.contexto);
        else
            textArea.setText(texto + nodo.contexto);
        if (nodo.ramas == null) {
            for (JButton jButton : botones) {
                jButton.setText("");
                jButton.setEnabled(false);
            }
            textArea.setText(textArea.getText() + "\n\n\n\tNombre: " + nombre + "\n\tEscenarios visitados: " + escenarios + "\n\tAristas recorridas: " + aristas);
            stats(nombre, escenarios, aristas);

        } else {
            for (int i = 0; i < nodo.ramas.length; i++) {
                if (nodo.ramas[i] != null) {
                    botones[i].setText(nodo.ramas[i]);
                    botones[i].setEnabled(true);
                } else {
                    botones[i].setText("");
                    botones[i].setEnabled(false);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        aristas++;
        int button = -1;
        for (int i = 0; i < 4; i++) {
            if (e.getSource() == botones[i]) {
                button = i;
                break;
            }
        }
        switch (button) {
            case 0:
                setNewStage(nodo.nodos[0], null);
                break;
            case 1:
                if (botones[1].getText().equals("Huir"))
                    setNewStage(nodo.nodos[1], huida);
                else
                    setNewStage(nodo.nodos[1], null);
                break;
            case 2:
                if (botones[2].getText().equals("Descender"))
                    setNewStage(nodo.nodos[2], descenso);
                else
                    setNewStage(nodo.nodos[2], null);
                break;
            case 3:
                setNewStage(nodo.nodos[3], null);
        }
    }

    private static void stats(String nombre, int escenarios, int aristas) {
        System.out.println("\n\tNombre: " + nombre + "\n\tEscenarios visitados: " + escenarios + "\n\tAristas recorridas: " + aristas);
    }

    private static final String descenso = "\nComienzas a segregar seda líquida mientras te cuelgas de ella. Es un hilo de gran resistencia, aunque insuficiente para soportar el peso de un elefante balanceándose (ya no digamos el de varios).\n\n";
    private static final String huida = "\nHuyes despavorida cual diva pillada in fraganti por los paparazzis.\n\n";
}
