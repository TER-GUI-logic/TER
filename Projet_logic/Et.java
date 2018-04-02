
public class Et extends OpBinaire{
	public Et(Formule argG,Formule argD) {
		super(argG,argD);		
	}
	@Override
	String affiche() {
		return "( " + argG.affiche() +"  ^ " + argD.affiche() + " )"; //affichage Et , alt-8743 
	}
}
