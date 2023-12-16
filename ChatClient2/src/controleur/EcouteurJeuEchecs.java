package controleur;

import com.chat.client.ClientChat;
import com.chat.commun.net.Connexion;

import javax.swing.*;
import javax.xml.transform.Source;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class EcouteurJeuEchecs implements ActionListener {

    private ClientChat clientChat;
    private String lastPosition=null;
    public EcouteurJeuEchecs(ClientChat clientChat) {
        this.clientChat = clientChat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source= e.getSource();
        String positionInit=(((JButton) source).getActionCommand());



        System.out.println(positionInit);
        if(this.lastPosition==null) {
            this.lastPosition = positionInit;
        }
        else {
            String positionFinale=(((JButton) source).getActionCommand());

            clientChat.envoyer("MOVE "+lastPosition+positionFinale);
            this.lastPosition=null;
        }




    }
}