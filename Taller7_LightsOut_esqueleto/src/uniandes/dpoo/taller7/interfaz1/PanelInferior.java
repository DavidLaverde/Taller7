package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class PanelInferior extends JPanel {

    private JTextField txtJugador;

    public PanelInferior() {
        setLayout(new GridLayout(1, 2));

        JLabel labelJugador = new JLabel("Jugador:");
        txtJugador = new JTextField();
        txtJugador.setEditable(false);

        add(labelJugador);
        add(txtJugador);
    }

    public void actualizarJugador(String nombre) {
        txtJugador.setText(nombre);
    }
}