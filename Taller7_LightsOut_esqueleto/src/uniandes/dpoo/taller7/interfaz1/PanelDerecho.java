package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class PanelDerecho extends JPanel {

    public PanelDerecho(ActionListener listener) {
        setLayout(new GridLayout(4, 1));

        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.setActionCommand("NUEVO");
        btnNuevo.addActionListener(listener);

        JButton btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setActionCommand("REINICIAR");
        btnReiniciar.addActionListener(listener);

        JButton btnTop10 = new JButton("Top-10");
        btnTop10.setActionCommand("TOP10");
        btnTop10.addActionListener(listener);

        JButton btnCambiarJugador = new JButton("Cambiar Jugador");
        btnCambiarJugador.setActionCommand("CAMBIAR_JUGADOR");
        btnCambiarJugador.addActionListener(listener);

        add(btnNuevo);
        add(btnReiniciar);
        add(btnTop10);
        add(btnCambiarJugador);
    }
}