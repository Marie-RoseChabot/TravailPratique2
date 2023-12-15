package controleur;

import com.chat.client.ClientChat;
import vue.PanneauInvitations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EcouteInvitations implements ActionListener {
    private ClientChat clientChat;
    private PanneauInvitations panneauInvitations;
    public EcouteInvitations(ClientChat clientChat, PanneauInvitations panneauInvitations)
    {
        this.clientChat = clientChat;
        this.panneauInvitations = panneauInvitations;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        Thread actionThread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                if(source instanceof JButton) {
                    JButton btn = (JButton) e.getSource();

                    switch (btn.getActionCommand())
                    {
                        case "ACCEPTER":
                            for (String alias : panneauInvitations.getElementsSelectionnes())
                            {
                                try
                                {
                                    clientChat.envoyer("JOIN "+ alias);
                                    // Pause de 100 millisecondes entre chaque requette
                                    Thread.sleep(100);
                                }
                                catch (InterruptedException ex)
                                {
                                    throw new RuntimeException(ex);
                                }
                            }
                            break;

                        case "REFUSER":
                            for (String alias : panneauInvitations.getElementsSelectionnes())
                            {
                                try
                                {
                                    clientChat.envoyer("DECLINE "+ alias);
                                    panneauInvitations.retirerInvitationRecue(alias);
                                    // Pause de 100 millisecondes entre chaque requette
                                    Thread.sleep(100);
                                }
                                catch (InterruptedException ex)
                                {
                                    throw new RuntimeException(ex);
                                }
                            }
                            break;

                        default:
                            System.out.print("Action inconnue !");
                    }
                }
            }
        });
        actionThread.start();
    }
}
