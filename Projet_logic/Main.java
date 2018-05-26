import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int nbHyp=0,nbCcl=0;
		String requete="";
		Noeud noeudCourant;
		ArrayList<Formule> Gamma =new ArrayList<Formule>();
		ArrayList<Formule> Delta =new ArrayList<Formule>();

		System.out.println("Entrez votre nombre d'hypothèses suivi du nombre de conclusions de votre séquent :");

		while (true){
			try{
				nbHyp=sc.nextInt();
				nbCcl=sc.nextInt();
				sc.nextLine();
				break;
			}
			catch (InputMismatchException e){sc.nextLine();System.out.println("Entrez 2 entiers svp");}				

		}


		for (int i=1;i<=nbHyp;i++){
			System.out.println("Entrez votre hypothèse "+i+" :");
			Gamma.add(Formule.entrerFormule(sc.nextLine()));

		}
		for (int i=1;i<=nbCcl;i++){
			System.out.println("Entrez votre conclusion "+i+" :");
			Delta.add(Formule.entrerFormule(sc.nextLine()));

		}

		Sequent seq=new Sequent(Gamma,Delta);
		Noeud Racine = seq.noeudpasfini();
		noeudCourant = Racine;

		while(!requete.equals("A"))
		{
			//System.out.println("\n"+noeudCourant.toString()+"\n");
			noeudCourant.affiche();

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
						if(!scc.equals("Axiome")){
							System.out.println("Quelle est la position de formule sur laquelle on applique la regle?\n       'debute a 0 pour chaque cote de la these' ");
							i = sc.nextInt();
							sc.nextLine();
						}
						noeudCourant.fairePreuve(i, Regles.valueOf(scc));
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