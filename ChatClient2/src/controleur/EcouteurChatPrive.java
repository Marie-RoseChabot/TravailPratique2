package controleur;

import com.chat.client.ClientChat;
import vue.PanneauChat;
import vue.PanneauChatPrive;
import vue.PanneauPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurChatPrive extends EcouteurChatPublic implements ActionListener {
    private String alias;
    public EcouteurChatPrive(String alias, ClientChat clientChat, PanneauChat panneauChat) {
        super(clientChat, panneauChat);
        this.alias = alias;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source instanceof JButton) {

            JButton button = (JButton) source;

            if (button.getActionCommand().equals("ACCEPTER"))
            {
                clientChat.envoyer("CHESS " + alias);
            }
            else if (button.getActionCommand().equals("REFUSER"))
            {
                clientChat.envoyer("DECLINE " + alias);
            }
        }

        if (source instanceof JTextField) {
            JTextField textField = ((JTextField) source);
            String cmd = textField.getText().split(" ")[0]; //Premet de recuperer la commande, inutile actuellement , mais utile pour de futur changement

            if (cmd.equals("QUIT")) {
                clientChat.envoyer("QUIT " + alias);
            } else if (cmd.equals("ABANDON")) {
                clientChat.envoyer("ABANDON " + alias);
            } else {
                String msg = ((JTextField) source).getText().trim();

                panneauChat.ajouter("MOI >> " + msg);
                textField.setText("");

                clientChat.envoyer("PRV " + alias + " " + msg);
            }
        }
    }
}