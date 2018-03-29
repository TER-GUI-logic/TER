import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Formule F = new Ou(new Variable("A"),new Variable("B"));
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
