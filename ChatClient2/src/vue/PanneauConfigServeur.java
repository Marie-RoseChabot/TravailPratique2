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
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,1));
        JLabel adresse = new JLabel("Adresse IP: ");
        txtAdrServeur = new JTextField(adr,20);

        JLabel portServeur = new JLabel("Port: ");
        txtNumPort = new JTextField(Integer.toString(port),20);

        p.add(adresse);
        p.add(txtAdrServeur);
        p.add(portServeur);
        p.add(txtNumPort);
        this.add(p,BorderLayout.NORTH);


        setSize(400,400);
        setLocation(200,200);
        setVisible(true);
    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
