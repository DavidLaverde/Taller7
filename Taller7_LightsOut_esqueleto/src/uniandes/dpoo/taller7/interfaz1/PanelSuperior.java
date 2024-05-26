package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;

public class PanelSuperior extends JPanel {

    private JComboBox<String> comboBoxTamano;
    private JRadioButton radioFacil;
    private JRadioButton radioDificil;

    public PanelSuperior() {
        setLayout(new GridLayout(2, 2));

        JLabel labelTamano = new JLabel("Tamaño del Tablero:");
        comboBoxTamano = new JComboBox<>(new String[] { "5x5", "7x7", "9x9" });

        JLabel labelDificultad = new JLabel("Dificultad:");
        radioFacil = new JRadioButton("Fácil");
        radioDificil = new JRadioButton("Difícil");
        ButtonGroup grupoDificultad = new ButtonGroup();
        grupoDificultad.add(radioFacil);
        grupoDificultad.add(radioDificil);
        radioFacil.setSelected(true);

        add(labelTamano);
        add(comboBoxTamano);
        add(labelDificultad);
        add(radioFacil);
        add(radioDificil);
    }

    public int getSelectedSize() {
        String selected = (String) comboBoxTamano.getSelectedItem();
        switch (selected) {
            case "7x7":
                return 7;
            case "9x9":
                return 9;
            default:
                return 5;
        }
    }
}
