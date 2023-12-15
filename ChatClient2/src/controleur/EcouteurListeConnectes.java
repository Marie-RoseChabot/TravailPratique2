package controleur;

import com.chat.client.ClientChat;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurListeConnectes extends MouseAdapter implements ActionListener {

    private ClientChat clientChat;
    public EcouteurListeConnectes(ClientChat clientChat) {
        this.clientChat = clientChat;
    }

    @Override
    public void mouseClicked(MouseEvent evt)
    {
        // Verifie le double-clic
        if(evt.getClickCount() == 2)
        {
            JList<String> listeConnectes = (JList<String>) evt.getSource();
            String aliasSelectionne = (String) listeConnectes.getSelectedValue();

            if(aliasSelectionne != null) {
                clientChat.envoyer("JOIN " + aliasSelectionne);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
