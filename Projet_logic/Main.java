import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String requete="";
		Noeud noeudCourant;


		Sequent seq=Util.entrerSequent();
		Noeud Racine = seq.noeudpasfini();
		noeudCourant = Racine;

		while(!requete.equals("A"))
		{
			//System.out.println("\n"+noeudCourant.toString()+"\n");
			noeudCourant.affiche(true);

			System.out.println("Quelle est la prochaine etape ?\nR : Retourner a la racine                P : Faire une preuve sur ce noeud"+
				"\nG : Aller sur le noeud de gauche         D : Aller sur le noeud de droite\nV : Verifier si la preuve est terminee   A : Arreter");
			requete = sc.nextLine();
			System.out.println();
			switch(requete){
				case "R":
					noeudCourant=Racine;
				break;

				case "G":
					try{
						noeudCourant=(Noeud) (noeudCourant.getPrems()).get(0);
					}
					catch(IndexOutOfBoundsException | ClassCastException e){System.out.println("Noeud inexistant");}
				break;

				case "D":
					try{
						noeudCourant=(Noeud) (noeudCourant.getPrems()).get(1);
					}
					catch(IndexOutOfBoundsException | ClassCastException e){System.out.println("Noeud inexistant");}
				break;
			
				case "P":
					System.out.println("Regles a appliquer : \nAxiome, cut, EtG, EtD, OuG, OuD, NonG, NonD, contG, contD"+
						"\nFauxG, VraiD, ImpliqueG, ImpliqueD, EquivalentG1, EquivalentG2, EquivalentD");
					String scc= sc.nextLine();
					int i=-1;
					try{
						if(!(scc.equals("Axiome") || scc.equals("cut"))){
							System.out.println("Quelle est la position de formule sur laquelle on applique la regle?\n       'debute a 0 pour chaque cote de la these' ");
							i = sc.nextInt();
							sc.nextLine();
						}
						System.out.println(noeudCourant.fairePreuve(i, Regles.valueOf(scc)));
					}
					catch(InputMismatchException e){
													sc.nextLine();
													System.out.println("Erreur : pas un entier");}
					catch(IllegalArgumentException e){System.out.println("Nom de regle non valide");}
					catch(IndexOutOfBoundsException e){System.out.println("Position non valide");}
				break;

				case "V":
					if (noeudCourant.estValide())
						System.out.println("Preuve terminee et formule valide !");
					else 
						System.out.println("Preuve non terminee");
				break;
			}
		}
	}
}