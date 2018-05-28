
public class Equivalent extends OpBinaire {

	public Equivalent(Formule argG, Formule argD) {
		super(argG,argD);
	}
	
	public String toString() {
		return "( " + argG.toString() +" <=> " + argD.toString() + " )"; //affichage comme l'Implique mais dans les deux sens
	}
}
