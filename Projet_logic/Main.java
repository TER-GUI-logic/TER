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
		//System.out.println(F.affiche());
		//System.out.println(seq.getDelta().get(0).getArgs().toString());
		Noeud Racine = seq.noeudpasfini();


		System.out.println("relgles existantes: \nAxiome,cut,EtG,EtD,OuG,OuD,NonG,NonD,contG,contD,\nFauxG,VraiD,ImpliqueG,ImpliqueD,EquivalentG1,EquivalentG2,EquivalentD");
		Scanner sc1 = new Scanner(System.in);



		Racine.fairePreuve(0, Regles.valueOf(sc1.nextLine()));
		System.out.println(Racine.getPrems().get(0).affiche());
		
		
	}

}
