
public class Ou extends OpBinaire{

	public Ou(Formule argG,Formule argD) {
		super(argG,argD);		
	}
	
	public String toString() {
		return "( " + argG.toString() +"  v  " + argD.toString() + " )"; //affichage Ou
	}
}
