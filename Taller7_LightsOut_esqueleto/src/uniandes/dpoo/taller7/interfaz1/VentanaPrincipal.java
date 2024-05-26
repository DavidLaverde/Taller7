package uniandes.dpoo.taller7.interfaz1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private PanelSuperior panelSuperior;
    private PanelDerecho panelDerecho;
    private PanelInferior panelInferior;
    private PanelTablero panelTablero;

    public VentanaPrincipal() {
        setTitle("Lights Out");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelSuperior = new PanelSuperior();
        panelDerecho = new PanelDerecho(this);
        panelInferior = new PanelInferior();
        panelTablero = new PanelTablero(5); // Tamaño por defecto

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecho, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
        add(panelTablero, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "NUEVO":
                nuevoJuego();
                break;
            case "REINICIAR":
                reiniciarJuego();
                break;
            case "TOP10":
                mostrarTop10();
                break;
            case "CAMBIAR_JUGADOR":
                cambiarJugador();
                break;
        }
    }

    private void nuevoJuego() {
        int tamano = panelSuperior.getSelectedSize();
        remove(panelTablero);
        panelTablero = new PanelTablero(tamano);
        add(panelTablero, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void reiniciarJuego() {
        panelTablero.reiniciar();
    }

    private void mostrarTop10() {
        // Implementación para mostrar el top 10 (simulada aquí)
        JOptionPane.showMessageDialog(this, "Aquí va el Top-10", "Top-10", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cambiarJugador() {
        String nuevoJugador = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo jugador:", "Cambiar Jugador", JOptionPane.PLAIN_MESSAGE);
        if (nuevoJugador != null && !nuevoJugador.trim().isEmpty()) {
            panelInferior.actualizarJugador(nuevoJugador);
        }
    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}