package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelTablero extends JPanel {

    private int tamanoTablero;
    private boolean[][] lucesEncendidas;

    public PanelTablero(int tamano) {
        this.tamanoTablero = tamano;
        this.lucesEncendidas = new boolean[tamano][tamano];
        inicializarTablero();

        setPreferredSize(new Dimension(500, 500));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int width = getWidth() / tamanoTablero;
                int height = getHeight() / tamanoTablero;
                int fila = e.getY() / height;
                int columna = e.getX() / width;
                cambiarLuz(fila, columna);
                repaint();
                verificarVictoria();
            }
        });
    }

    private void inicializarTablero() {
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                lucesEncendidas[i][j] = Math.random() < 0.5;
            }
        }
    }

    private void cambiarLuz(int fila, int columna) {
        lucesEncendidas[fila][columna] = !lucesEncendidas[fila][columna];
        if (fila > 0) {
            lucesEncendidas[fila - 1][columna] = !lucesEncendidas[fila - 1][columna];
        }
        if (fila < tamanoTablero - 1) {
            lucesEncendidas[fila + 1][columna] = !lucesEncendidas[fila + 1][columna];
        }
        if (columna > 0) {
            lucesEncendidas[fila][columna - 1] = !lucesEncendidas[fila][columna - 1];
        }
        if (columna < tamanoTablero - 1) {
            lucesEncendidas[fila][columna + 1] = !lucesEncendidas[fila][columna + 1];
        }
    }

    private void verificarVictoria() {
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                if (lucesEncendidas[i][j]) {
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "¡Felicidades! Has apagado todas las luces.");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth() / tamanoTablero;
        int height = getHeight() / tamanoTablero;

        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                if (lucesEncendidas[i][j]) {
                    g2.setColor(Color.YELLOW);
                } else {
                    g2.setColor(Color.GRAY);
                }
                g2.fillRect(i * width, j * height, width, height);
                g2.setColor(Color.BLACK);
                g2.drawRect(i * width, j * height, width, height);
            }
        }
    }

    public void reiniciar() {
        inicializarTablero();
        repaint();
    }
}