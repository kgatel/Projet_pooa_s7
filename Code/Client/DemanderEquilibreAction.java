import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

public class DemanderEquilibreAction extends AbstractAction {
	
	private FenetrePrincipale fenetre;
	private ArrayList<Personne> participant;
	
	public DemanderEquilibreAction(ArrayList<Personne> participant,FenetrePrincipale fenetre, String texte){
		super(texte);
		this.participant=participant;
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		
		//Demander au serveur le solde de chaque personne ou bien l'ensemble des dépenses
		
		//pour rafraichir la page je ne sais pas faire autrement que fermer puis réouvrir un nouveau tricount avec la misé à jour des équilibres
		this.fenetre.dispose();
		
		try {
			this.fenetre.rebuild();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		fenetre.setVisible(true);//On la rend visible
		
	} 
}