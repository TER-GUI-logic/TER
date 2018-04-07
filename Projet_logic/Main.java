import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import org.antlr.v4.runtime.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String requete="";
		Noeud noeudCourant;

		System.out.println("Entrez votre formule :");

		CharStream stream = CharStreams.fromString(sc.nextLine());
		AnalyseurLexer lexer= new AnalyseurLexer(stream);
		CommonTokenStream tokens=new CommonTokenStream(lexer);
		AnalyseurParser parser=new AnalyseurParser(tokens);
		Formule F = parser.formul().value;
		ArrayList<Formule> Gamma =new ArrayList<Formule>();
		ArrayList<Formule> Delta =new ArrayList<Formule>();
		Delta.add(F);
		Sequent seq=new Sequent(Gamma,Delta);
		Noeud Racine = seq.noeudpasfini();
		noeudCourant = Racine;

		while(!requete.equals("S"))
		{
			//System.out.println("\n"+noeudCourant.toString()+"\n");
			noeudCourant.affiche();

			System.out.println("Quelle est la prochaine etape ?\nR : Retourner a la racine             P : Faire une preuve sur ce noeud"+
				"\nG : Aller sur le noeud de gauche      D : Aller sur le noeud de droite\nS : Arreter");
			requete = sc.nextLine();
			switch(requete){
				case "R":
					noeudCourant=Racine;
				break;

				case "G":
						noeudCourant=(Noeud) (noeudCourant.getPrems()).get(0);
				break;

				case "D":
						noeudCourant=(Noeud) (noeudCourant.getPrems()).get(1);
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
			}
		}
	}
}