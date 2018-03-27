
public class Implique extends OpBinaire {
	
	
	
	public Implique(Formule argG , Formule argD) {
		this.argG=argG;
		this.argD=argD;
		
	}

	@Override
	String affiche() {
		return "( " + argG.affiche() +"  =>  " + argD.affiche() + " )"; //affichage Implique 
	}
}
