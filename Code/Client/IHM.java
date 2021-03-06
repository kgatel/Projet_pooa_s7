
import java.awt.*;
import java.rmi.RemoteException;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;


public class IHM extends JFrame{
		
		//private ArrayList<Personne> participant;
		private Tricount tricount;
		private Personne utilisateur;
		
		public Personne getUtilisateur() {
			return this.utilisateur;
		}

		public void setUtilisateur(Personne utilisateur) {
			this.utilisateur = utilisateur;
		}

		public Tricount getTricount() {
			return tricount;
		}

		public void setTricount(Tricount tricount) {
			this.tricount = tricount;
		}

		public IHM(Tricount tri,Personne utilisateur) throws RemoteException{
			super();
			this.tricount=tri;
			this.utilisateur=utilisateur;
			build();//On initialise notre fenêtre
		}
		
		private void build() throws RemoteException{
			setTitle("Tricount : " + utilisateur.getName()); //On donne un titre à l'application
			setSize(820,540); //On donne une taille à notre fenêtre
			setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
			setResizable(false); //On interdit la redimensionnement de la fenêtre
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
			setContentPane(buildContentPane());
			
		}
		public void rebuild() throws RemoteException{
			setTitle("Tricount : " + utilisateur.getName()); //On donne un titre à l'application
			setSize(820,540); //On donne une taille à notre fenêtre
			//setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
			setResizable(false); //On interdit la redimensionnement de la fenêtre
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
			setContentPane(buildContentPane());
			
		}
		
		
		private JPanel buildContentPane() throws RemoteException{
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
			panel.setLayout(new BorderLayout(10,10));
			Border cadre = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			
			//Création Nord
			JPanel Nord = new JPanel();
			JLabel Titre = new JLabel("<html><h2>TRICOUNT</h2></html>" );
			
			Nord.setBackground(new Color(121,210,230));
			Nord.add(Titre);
			
			//Création Centre
			JPanel Centre = new JPanel();
			Centre.setLayout(new BorderLayout(10,10));
			Centre.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
				//Text Centre
				JLabel TitreCentre = new JLabel("<html><h3>3 Dernières dépenses:</h3></html>");
				TitreCentre.setBackground(new Color(121,210,230));
				TitreCentre.setBorder(cadre);
				TitreCentre.setHorizontalAlignment(SwingConstants.CENTER);
			
				
			Boutton BoutonDemanderEquilibre = new Boutton(new Actualiser(this.tricount.GetParticipants(),this, "<html><h4>Actualiser</h4></html>"),new Color(253,252,150));
			
			JLabel Depenses = new JLabel(this.tricount.affichage3Depenses());
			Depenses.setBackground(new Color(121,210,230));
			Depenses.setBorder(cadre);
			
			//Bouton Actualiser
			
	
			Centre.add(TitreCentre,BorderLayout.NORTH);
			Centre.add(Depenses,BorderLayout.CENTER);
			Centre.add(BoutonDemanderEquilibre,BorderLayout.SOUTH);
			Centre.setBackground(Color.WHITE);
			
			//Création Est
			JPanel Est = new JPanel();
			Est.setBackground(Color.WHITE);
			Est.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			Est.setLayout(new BorderLayout(10,10));
				//Text Centre
				JLabel TitreEst = new JLabel("<html><h3>Equilibre:</h3></html>");
				TitreEst.setBackground(new Color(121,210,230));
				TitreEst.setBorder(cadre);
				TitreEst.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel equilibre = new JLabel(this.tricount.affichageEquilibre());
				
				equilibre.setBackground(new Color(121,210,230));
				equilibre.setBorder(cadre);
				
				//Boutons
				JPanel BouttonSud = new JPanel();
				BouttonSud.setLayout(new BorderLayout());
				Boutton BoutonAjouterDepense = new Boutton(new AjouterDepenseAction(this, "<html><h4>Ajouter une dépense</h4></html>"),new Color(246,209,216));
				Boutton BoutonRembourser = new Boutton(new RembourserAction(this, "<html><h4>Rembourser</h4></html>"),new Color(176,242,182));
				
				BouttonSud.add(BoutonAjouterDepense,BorderLayout.NORTH);
				BouttonSud.add(BoutonRembourser,BorderLayout.SOUTH);
				
			Est.add(TitreEst,BorderLayout.NORTH);
			Est.add(equilibre,BorderLayout.CENTER);
			Est.add(BouttonSud,BorderLayout.SOUTH);
			
			//Ajout Panel Principal
			panel.setBackground(Color.gray);
			panel.add(Nord,BorderLayout.NORTH);
			panel.add(Centre,BorderLayout.CENTER);
			panel.add(Est,BorderLayout.EAST);
			
			
			return panel;
		}	
		
	}
