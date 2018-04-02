
public class Ou extends OpBinaire{

	public Ou(Formule argG,Formule argD) {
		super(argG,argD);		
	}
	@Override
	String affiche() {
		return "( " + argG.affiche() +"  v  " + argD.affiche() + " )"; //affichage Ou
	}
}
