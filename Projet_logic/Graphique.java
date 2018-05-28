
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Graphique extends JFrame {	

	 
	//attribut
	private JPanel panel = new JPanel();
	private JPanel pan = new JPanel();
	private JPanel panneau = new JPanel();
	private JLabel label = new JLabel();
	private JLabel arbre = new JLabel();//
	private JTextField zoneTexte;// texte, une ligne
	private JButton boutonETd = new JButton("EtD");
	private JButton boutonAx = new JButton("Axiome");
	private JButton boutonCUT = new JButton("Cut");
	private JButton boutonETg = new JButton("EtG");
	private JButton boutonOUg = new JButton("OuG");
	private JButton boutonOUd = new JButton("OuD");
	private JButton boutonNONg = new JButton("NonG");
	private JButton boutonNONd = new JButton("NonD");
	private JButton boutonCONTg = new JButton("ContG");
	private JButton boutonCONTd = new JButton("ContD");
	private JButton boutonFAUXg = new JButton("FauxG");
	private JButton boutonVRAId = new JButton("VraiD");
	private JButton boutonIMPg = new JButton("ImpliqueG");
	private JButton boutonIMPd = new JButton("ImpliqueD");
	private JButton boutonEQUg1 = new JButton("EquivalentG1");
	private JButton boutonEQUg2 = new JButton("EquivalentG2");
	private JButton boutonEQUd = new JButton("EquivalentD");
	private JButton boutonOK = new JButton("OK");
	private JButton boutonRAC = new JButton("Retourner a la racine");
	private JButton boutonNG = new JButton("Aller sur le noeud de gauche");
	private JButton boutonND = new JButton("Aller sur le noeud de droite");
	private JButton boutonPN = new JButton("Faire une preuve sur ce noeud");
	private JButton boutonAR = new JButton("Arreter");
	private JButton boutonVER = new JButton("Verifier si la preuve est terminee");
	private JButton boutonOH = new JButton("OK Hypotheses");
	private JButton boutonOC = new JButton("OK Conclusions");
	private String s;
	private ArrayList<Formule> Gamma =new ArrayList<Formule>();
	private ArrayList<Formule> Delta =new ArrayList<Formule>();
	private Sequent seq;
	private int i;
	private Noeud Racine;
	private Noeud noeudCourant;
	private FlowLayout lgauche = new FlowLayout(FlowLayout.LEFT);
	private FlowLayout ldroite = new FlowLayout(FlowLayout.RIGHT);
	private FlowLayout lcentre = new FlowLayout(FlowLayout.CENTER);
	private BoxLayout lhorizon;

	
	
	
	public String aff(Noeud n){
		s = "<html>";
		ArrayList<String> list = n.listString(false);
		for (int i=0;i<list.size();i++){
			s = s+"<br>"+(list.get(i));
		}
		s = s+"</html>";
		return s;
	}
	
	// lors du clic bouton ok
	ActionListener valider = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			seq = new Sequent(Gamma,Delta);
			Racine = seq.noeudpasfini();
			noeudCourant = Racine;
			s = aff(noeudCourant);
			arbre.setText(s);
			label.setText("que voulez vous faire");
			label.setText("<html>que voulez vous faire ?<br>pour appliquer une regle :<br>veuillez renseigner la position de la formule sur laquelle applique la regle"+
				"(debute a zero de chaque cote de la these)<br>"+
				"pour la regle cut veuillez indiquer la nouvelle formule"+
				"puis choisir la regle</html>");
			arbre.setText(aff(noeudCourant));
		}
	};
	
	//lors du clic bouton OK Hypotheses
	ActionListener oH = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			s = zoneTexte.getText();
			Gamma.add(Util.entrerFormule(s));
			System.out.println(s);
		}
	};
	
	
	//lors du clic bouton OK Conclusions
	ActionListener oC = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			s = zoneTexte.getText();
			Delta.add(Util.entrerFormule(s));
			System.out.println(s);
		}
	};

	/**actions crées pour tout les boutons de choix*/	
	
	//lors du clic bouton retourner à l racine
	ActionListener racine = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			noeudCourant = Racine;
			label.setText("retourner a la racine fait");
			arbre.setText(aff(noeudCourant));
		}
	};
	
	//lors du clic bouton aller sur le noeud de gauche
	ActionListener gauche = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try{
				noeudCourant=(Noeud) (noeudCourant.getPrems()).get(0);
				label.setText("aller sur le noeud gauche fait");
				arbre.setText(aff(noeudCourant));
			}
			catch(IndexOutOfBoundsException | ClassCastException ee){
				label.setText("Noeud inexistant");
			}
		}
	};
	
	//lors du clic bouton aller sur le noeud de droite
	ActionListener droite = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try{
				noeudCourant=(Noeud) (noeudCourant.getPrems()).get(1);
				label.setText("aller sur le noeud droit fait");
				arbre.setText(aff(noeudCourant));
			}
			catch(IndexOutOfBoundsException | ClassCastException ee){
				label.setText("Noeud inexistant");
			}
		}
	};
	
	//lors du clic bouton Verifier si la preuve est terminee
	ActionListener verifier = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if (noeudCourant.estValide()){
				label.setText("Preuve terminee et formule valide !");
			}else {
				label.setText("Preuve non terminee");
			}
		}
	};
	
	//lors du clic bouton faire une preuve sur ce noeud
	ActionListener preuve = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			label.setText("<html>veuillez renseigner la position de la formule sur laquelle applique la regle"+
				"(debute a zero de chaque cote de la these)<br>"+
				"pour la regle cut veuillez indiquer la nouvelle formule"+
				"puis choisir la regle</html>");
			arbre.setText(aff(noeudCourant));
		}
	};
	
	//lors du clic bouton Arrêter
	ActionListener stop = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			label.setText("exit");
			System.exit(0);
		}
	};
	
		/**actions crées pour tous les boutons de règles*/
	
	//bouton ETd
	ActionListener etd = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String t = "" ;
			System.out.println("et droite");
			s = zoneTexte.getText();
			try{
				i = Integer.parseInt(s);
				t = noeudCourant.fairePreuve(i, Regles.valueOf("EtD"));
				arbre.setText(aff(noeudCourant));
			}
			catch(IndexOutOfBoundsException ee){
				label.setText("Position non valide");
			}
			catch(InputMismatchException ee){
				label.setText("Erreur : pas un entier");
			}
		}
	};
	
	//bouton ETg
		ActionListener etg = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("et gauche");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("EtG"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
		}
	};
	
	//bouton Axiome
	ActionListener ax = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String t = "" ;
			System.out.println("axiome");
			try{
				i = -1;
				t = noeudCourant.fairePreuve(i, Regles.valueOf("Axiome"));
				arbre.setText(aff(noeudCourant));
			}
			catch(IndexOutOfBoundsException ee){
				label.setText("Position non valide");
			}
			catch(InputMismatchException ee){
				label.setText("Erreur : pas un entier");
			}
		}
	};
	
	//bouton CUT
		ActionListener cut = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String f = "";
				String t = "" ;
				f = zoneTexte.getText();
				try{
					t = noeudCourant.faireCut(f);
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};
	
	//bouton OUd
		ActionListener oud = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("ou droit");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("OuD"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};	
	
	//bouton OUg
		ActionListener oug = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("ou gauche");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("OuG"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};
		
	//bouton NONg
		ActionListener nong = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("non gauche");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("NonG"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};
		
	//bouton NONd
		ActionListener nond = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("non droit");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("NonD"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};		
		
	//bouton CONTg
		ActionListener contg = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("cont gauche");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("contG"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};		
		
	//bouton CONTd
		ActionListener contd = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("cont droit");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("contD"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};
		
	//bouton FAUXg
		ActionListener fauxg = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("Faux gauche");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("FauxG"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};		
		
	//bouton VRAId
		ActionListener vraid = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("vrai droit");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("VraiD"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};		
		
	//bouton IMPg
		ActionListener impliqueg = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("implique gauche");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("ImpliqueG"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};
		
	//bouton IMPd
		ActionListener impliqued = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("implique droit");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("ImpliqueD"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};		
		
	//bouton EQUg1
		ActionListener equivalentg1 = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("equivalent gauche 1");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("EquivalentG1"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};		
		
	//bouton EQUg2
		ActionListener equivalentg2 = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("equivalent gauche 2");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("EquivalentG2"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};	
		
	//bouton EQUd
		ActionListener equivalentd = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t = "" ;
				System.out.println("equivalent droit");
				s = zoneTexte.getText();
				try{
					i = Integer.parseInt(s);
					t = noeudCourant.fairePreuve(i, Regles.valueOf("EquivalentD"));
					arbre.setText(aff(noeudCourant));
				}
				catch(IndexOutOfBoundsException ee){
					label.setText("Position non valide");
				}
				catch(InputMismatchException ee){
					label.setText("Erreur : pas un entier");
				}
			}
		};				
		
	//constructor
	public Graphique(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		lhorizon = new BoxLayout(getContentPane(),BoxLayout.Y_AXIS);
		getContentPane().setLayout(lhorizon);
		Scanner sc = new Scanner(System.in);

		String requete="";
		Noeud noeudCourant;
		
		boutonETd.addActionListener(etd);
		boutonETg.addActionListener(etg);
		boutonAx.addActionListener(ax);
		boutonOUg.addActionListener(oug);
		boutonOUd.addActionListener(oud);
		boutonCUT.addActionListener(cut);
		boutonNONg.addActionListener(nong);
		boutonNONd.addActionListener(nond);
		boutonCONTg.addActionListener(contg);
		boutonCONTd.addActionListener(contd);
		boutonFAUXg.addActionListener(fauxg);
		boutonVRAId.addActionListener(vraid);
		boutonIMPg.addActionListener(impliqueg);
		boutonIMPd.addActionListener(impliqued);
		boutonEQUg1.addActionListener(equivalentg1);
		boutonEQUg2.addActionListener(equivalentg2);
		boutonEQUd.addActionListener(equivalentd);
		boutonRAC.addActionListener(racine);
		boutonNG.addActionListener(gauche);
		boutonND.addActionListener(droite);
		boutonVER.addActionListener(verifier);
		boutonPN.addActionListener(preuve);
		boutonAR.addActionListener(stop);
		boutonOH.addActionListener(oH);
		boutonOC.addActionListener(oC);
		
		zoneTexte = new JTextField(15);
		boutonOK.addActionListener(valider);
				
		panel.add(zoneTexte);
		panel.add(boutonOH);
		panel.add(boutonOC);
        panel.add(boutonOK);
		panel.add(boutonVER);
        panel.add(boutonAR);
        panel.add(boutonPN);
        panel.add(boutonNG);
        panel.add(boutonND);
        panel.add(boutonRAC);
        panel.add(boutonAx);
        panel.add(boutonETd);
        panel.add(boutonETg);
        panel.add(boutonCUT);
        panel.add(boutonOUg);
        panel.add(boutonOUd);
        panel.add(boutonNONd);
        panel.add(boutonNONg);
        panel.add(boutonCONTd);
        panel.add(boutonCONTg);
        panel.add(boutonFAUXg);
        panel.add(boutonVRAId);
        panel.add(boutonIMPg);
        panel.add(boutonIMPd);
        panel.add(boutonEQUd);
        panel.add(boutonEQUg1);
        panel.add(boutonEQUg2);
		panneau.add(label);
        panel.setLayout(lcentre);
		pan.add(arbre);
        add(panel);
		add(panneau);
        add(pan);
        label.setText("Veuillez entrer chaque hypothese et appuyer sur OK Hypotheses pour chacune puis faire de meme pour les conclusions quand vous avez termine appuyer sur OK");
        
        setSize(1000,500);
        

	}
	
	
	//main
	public static void main (String[] args){
		Graphique g = new Graphique();
		g.setVisible(true);
	}
	
}

