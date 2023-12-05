package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauChat extends JPanel {
    protected JTextArea zoneChat;
    protected JTextField champDeSaisie;

    public PanneauChat() {
        JPanel panneauChat = new JPanel();


        panneauChat.setLayout(new BorderLayout());

        champDeSaisie = new JTextField(30);
        panneauChat.add(champDeSaisie, BorderLayout.SOUTH);

        zoneChat = new JTextArea(15, 30);

        zoneChat.setEditable(false);
        JScrollPane zoneDefilante = new JScrollPane(zoneChat);


        panneauChat.add(zoneDefilante, BorderLayout.CENTER);

        this.add(panneauChat);
        setSize(400, 400);
        setLocation(200, 200);
        setVisible(true);
    }

    public void ajouter(String msg) {
        zoneChat.append("\n" + msg);
    }

    public void setEcouteur(ActionListener ecouteur) {
        //Enregistrer l'écouteur auprès du champ de saisie

        champDeSaisie.addActionListener(ecouteur);


    }

    public void vider() {
        this.zoneChat.setText("");
    }

    public void viderChampSaisie() {
        this.champDeSaisie.setText("");
    }
}