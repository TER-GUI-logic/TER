
public class Non extends Formule {

	
	private Formule arg;
	
	
	public Non(Formule arg) {
	this.arg=arg;
	}
	@Override
	String affiche() {
		return "( " +"  Non  " + arg.affiche() + " )"; //affichage Non  

	}

}
