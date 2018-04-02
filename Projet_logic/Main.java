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
		Racine.fairePreuve(0, Regles.OuD);
		for (int i=0;i<Racine.getPrems().size();i++){		
		System.out.println(Racine.getPrems().get(i).getConcl().affiche());
		}
		
	}

}
