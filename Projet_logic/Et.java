
public class Et extends OpBinaire{
	public Et(Formule argG,Formule argD) {
		this.argG=argG;
		this.argD=argD;
		
	}
	@Override
	String affiche() {
		return "( " + argG.affiche() +"  ^  " + argD.affiche() + " )"; //affichage Et , alt-8743 
	}
}
