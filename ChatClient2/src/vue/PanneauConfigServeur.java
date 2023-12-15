package vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;

    public PanneauConfigServeur(String adr, int port) {
        // Utilise BorderLayout pour le panneau principal
        setLayout(new BorderLayout());

        JPanel adrPanel = new JPanel();
        JPanel portPanel = new JPanel();

        // Utilise FlowLayout vers la position LEFT pour les panneaux "Adresse" et "Port"
        adrPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        portPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel lblAdresseServeur = new JLabel("Adresse IP : ");
        txtAdrServeur = new JTextField(adr);
        txtAdrServeur.setColumns(15);

        JLabel lblPort = new JLabel("Port : ");
        txtNumPort = new JTextField(port);
        txtNumPort.setColumns(15);

        adrPanel.add(lblAdresseServeur);
        adrPanel.add(txtAdrServeur);

        portPanel.add(lblPort);
        portPanel.add(txtNumPort);

        // Ajoute les panneaux "Adresse" et "Port" au panneau principal
        add(adrPanel, BorderLayout.NORTH);
        add(portPanel, BorderLayout.SOUTH);
    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
