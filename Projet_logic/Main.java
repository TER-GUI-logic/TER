import java.util.ArrayList;
import java.util.Scanner;
import org.antlr.v4.runtime.*;

public class Main {

	public static void main(String[] args) {

	

		System.out.println("Entrez votre formule :");
		Scanner sc = new Scanner(System.in);
		CharStream stream = CharStreams.fromString(sc.nextLine());
		AnalyseurLexer lexer= new AnalyseurLexer(stream);
		CommonTokenStream tokens=new CommonTokenStream(lexer);
		AnalyseurParser parser=new AnalyseurParser(tokens);
		Formule F = parser.formul().value;
		ArrayList<Formule> Gamma =new ArrayList<Formule>();
		ArrayList<Formule> Delta =new ArrayList<Formule>();
		Delta.add(F);
		Sequent seq=new Sequent(Gamma,Delta);
		//System.out.println(F.toString());
		//System.out.println(seq.getDelta().get(0).getArgs().toString());
		Noeud Racine = seq.noeudpasfini();

		System.out.println("Quel est la position de formule sur laquelle on applique la regle? \n       'debute a 0 pour chaque cote de la these' ");
		Scanner sc1 = new Scanner(System.in);

		int i = sc1.nextInt();
		

		System.out.println("relgles existantes: \nAxiome,cut,EtG,EtD,OuG,OuD,NonG,NonD,contG,contD,\nFauxG,VraiD,ImpliqueG,ImpliqueD,EquivalentG1,EquivalentG2,EquivalentD");
		Scanner sc2 = new Scanner(System.in);
		String scc= sc2.nextLine();


		Racine.fairePreuve(i, Regles.valueOf(scc));
		System.out.println(Racine.toString());
		//System.out.println(Racine.getPrems().get(i).toString());
		
		
	}

}
