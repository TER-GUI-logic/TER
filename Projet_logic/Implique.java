
public class Implique extends OpBinaire {
	
	
	
	public Implique(Formule argG , Formule argD) {
		
	}

	@Override
	String affiche() {
		return "( " + argG.affiche() +"  =>  " + argD.affiche() + " )"; //affichage Implique 
	}


}
