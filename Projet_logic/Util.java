import org.antlr.v4.runtime.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Util{
	static Formule entrerFormule(String s){
		CharStream stream = CharStreams.fromString(s);
		AnalyseurLexer lexer= new AnalyseurLexer(stream);
		CommonTokenStream tokens=new CommonTokenStream(lexer);
		AnalyseurParser parser=new AnalyseurParser(tokens);
		return parser.formul().value;
	}
	
	
	static Formule entrerFormule(){
		Scanner sc= new Scanner(System.in);
		return entrerFormule(sc.nextLine());
	}
	
	static Sequent entrerSequent(){
		ArrayList<Formule> Gamma =new ArrayList<Formule>();
		ArrayList<Formule> Delta =new ArrayList<Formule>();
		Scanner sc= new Scanner(System.in);
		int nbHyp=0,nbCcl=0,compt=5;
		System.out.println("Entrez votre nombre d'hypotheses suivi du nombre de conclusions de votre sequent :");

		while (compt>0){
			try{
				nbHyp=sc.nextInt();
				nbCcl=sc.nextInt();
				sc.nextLine();
				break;
			}
			catch (InputMismatchException e){compt--;sc.nextLine();System.out.println("Entrez 2 entiers svp");}				

		}


		for (int i=1;i<=nbHyp;i++){
			System.out.println("Entrez votre hypothese "+i+" :");
			Gamma.add(entrerFormule());

		}
		for (int i=1;i<=nbCcl;i++){
			System.out.println("Entrez votre conclusion "+i+" :");
			Delta.add(entrerFormule());

		}

		return new Sequent(Gamma,Delta);
	}



}