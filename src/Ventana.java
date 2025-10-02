import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends javax.swing.JFrame implements ActionListener {
    JTextArea textArea;
    JButton[] botones;
    int aristas =0, escenarios =0;
    Nodo nodo;
    String nombre;

    public Ventana(String nombre) {
        this.nombre = nombre;
        getContentPane().setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(400, 400));
        textArea.setFocusable(false);
        getContentPane().add(textArea, BorderLayout.CENTER);

        botones = new JButton[]{new JButton(), new JButton(), new JButton(), new JButton()};
        botones[0].setText("Ascender");
        botones[0].setPreferredSize(new Dimension(150, 50));
        botones[0].setFocusable(false);
        botones[0].setVisible(true);
        botones[0].addActionListener(this);
        getContentPane().add(botones[0], BorderLayout.NORTH);
        botones[1].setText("Derecha");
        botones[1].setPreferredSize(new Dimension(150, 50));
        botones[1].setFocusable(false);
        botones[1].setVisible(true);
        botones[1].addActionListener(this);
        getContentPane().add(botones[1], BorderLayout.EAST);
        botones[2].setText("Descender");
        botones[2].setPreferredSize(new Dimension(150, 50));
        botones[2].setFocusable(false);
        botones[2].setVisible(true);
        botones[2].addActionListener(this);
        getContentPane().add(botones[2], BorderLayout.SOUTH);
        botones[3].setText("Izquierda");
        botones[3].setPreferredSize(new Dimension(150, 50));
        botones[3].setFocusable(false);
        botones[3].setVisible(true);
        botones[3].addActionListener(this);
        getContentPane().add(botones[3], BorderLayout.WEST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }


    void setNewStage(Nodo nodo, String texto) {
        this.nodo = nodo;
        if(!this.nodo.visitado){
            escenarios++;
            this.nodo.visitado = true;
        }
        if (texto == null)
            textArea.setText(Nodo.formatearString(nodo.contexto));
        else
            textArea.setText(Nodo.formatearString(texto) + Nodo.formatearString(nodo.contexto));
/*
        botones[0].addActionListener(e -> setNewScenario(caminos[0].contexto,caminos[0].ramas,caminos[0].nodos));
        botones[1].addActionListener(e -> setNewScenario(caminos[1].contexto,caminos[1].ramas,caminos[1].nodos));
        botones[2].addActionListener(e -> setNewScenario(caminos[2].contexto,caminos[2].ramas,caminos[2].nodos));
        botones[3].addActionListener(e -> setNewScenario(caminos[3].contexto,caminos[3].ramas,caminos[3].nodos));
*/
        if (nodo.ramas == null) {
//            System.out.println("Game Over");
            for (JButton botone : botones) {
                botone.setText("");
                botone.setEnabled(false);
            }
            textArea.setText(textArea.getText()+"\n\n\n\tNombre: "+nombre+"\n\tEscenarios visitados: "+escenarios+"\n\tAristas recorridas: "+aristas);
            stats(nombre,escenarios,aristas);

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
        if (e.getSource() == botones[0]) {
            System.out.println("0");
            setNewStage(nodo.nodos[0], null);
        } else if (e.getSource() == botones[1]) {
            System.out.println("1");
            if (botones[1].getText().equals("Huir"))
                setNewStage(nodo.nodos[1], huida);
            else
                setNewStage(nodo.nodos[1], null);
        } else if (e.getSource() == botones[2]) {
            System.out.println("2");
            if (botones[2].getText().equals("Descender"))
                setNewStage(nodo.nodos[2], descenso);
            else
                setNewStage(nodo.nodos[2], null);
        } else {
            System.out.println("3");
            setNewStage(nodo.nodos[3], null);
        }

    }
    private static void stats(String nombre,int escenarios,int aristas) {
        System.out.println("\n\tNombre: "+nombre+"\n\tEscenarios visitados: "+escenarios+"\n\tAristas recorridas: "+aristas);
    }


    /*
        class Boton extends JButton implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == botones[0]) {
                    System.out.println("0");
                    setNewScenario(nodo.nodos[0]);
                } else if (e.getSource() == botones[1]) {
                    System.out.println("1");
                    setNewScenario(nodo.nodos[1]);
                } else if (e.getSource() == botones[2]) {
                    System.out.println("2");
                    setNewScenario(nodo.nodos[2]);
                } else {
                    System.out.println("3");
                    setNewScenario(nodo.nodos[3]);
                }
            }
        }
    */
    private static final String descenso = "\nComienzas a segregar seda líquida mientras te cuelgas de ella. Es un hilo de gran resistencia, aunque insuficiente para soportar el peso de un elefante balanceándose (ya no digamos el de varios). ";
    private static final String huida = "\nHuyes despavorida cual diva pillada in fraganti por los paparazzis.";

}
