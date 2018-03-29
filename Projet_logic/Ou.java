
public class Ou extends OpBinaire{

	public Ou(Formule argG,Formule argD) {
		this.argD=argD;
		this.argG=argG;
		
	}
	@Override
	String affiche() {
		return "( " + argG.affiche() +"  v  " + argD.affiche() + " )"; //affichage Ou
	}
}
