
public class Implique extends OpBinaire {
	
	
	
	public Implique(Formule argG , Formule argD) {
		super(argG,argD);
	}

	
	public String toString() {
		return "( " + argG.toString() +"  =>  " + argD.toString() + " )"; //affichage Implique 
	}


}
