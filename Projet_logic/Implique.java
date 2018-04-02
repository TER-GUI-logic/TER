
public class Implique extends OpBinaire {
	
	
	
	public Implique(Formule argG , Formule argD) {
		super(argG,argD);
	}

	@Override
	String affiche() {
		return "( " + argG.affiche() +"  =>  " + argD.affiche() + " )"; //affichage Implique 
	}


}
