
public class Ou extends OpBinaire{

	public Ou(Formule argG,Formule argD) {
		this.argG=argG;
		this.argD=argD;
	}
	@Override
	String affiche() {
		return "( " + argG.affiche() +"  v  " + argD.affiche() + " )"; //affichage Ou
	}
}
