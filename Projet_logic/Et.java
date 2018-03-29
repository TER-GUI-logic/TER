
public class Et extends OpBinaire{
	public Et(Formule argG,Formule arg) {
		
	}
	@Override
	String affiche() {
		return "( " + argG.affiche() +"  ^ " + argD.affiche() + " )"; //affichage Et , alt-8743 
	}
}
