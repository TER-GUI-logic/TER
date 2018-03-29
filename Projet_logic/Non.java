import java.util.ArrayList;

public class Non extends Formule {

	
	private Formule arg;
	
	
	public Non(Formule arg) {
	this.arg=arg;
	}
	@Override
	String affiche() {
		return "( " +"  Non  " + arg.affiche() + " )"; //affichage Non  

	}
	@Override
	ArrayList<Formule> getArgs() {
		// TODO Auto-generated method stub
		ArrayList<Formule> prof_X = new ArrayList<Formule> ();
		prof_X.add(arg);
		return prof_X ;
	}
}
