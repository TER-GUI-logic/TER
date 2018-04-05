
public class Et extends OpBinaire{
	public Et(Formule argG,Formule argD) {
		super(argG,argD);		
	}
	
	public String toString() {
		return "( " + argG.toString() +"  ^ " + argD.toString() + " )"; //affichage Et , alt-8743 
	}
}
