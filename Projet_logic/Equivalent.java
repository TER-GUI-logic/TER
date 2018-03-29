
public class Equivalent extends OpBinaire {

	public Equivalent(Formule argG, Formule argD) {
		
	}
	@Override
	String affiche() {
		return "( " + argG.affiche() +"  <=>  " + argD.affiche() + " )"; //affichage comme l'Implique mais dans les deux sens
	}
}
