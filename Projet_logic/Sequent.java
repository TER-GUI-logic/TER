import java.util.ArrayList;

public class Sequent {
	private ArrayList<Formule> Gamma;
	private ArrayList<Formule> Delta;

	
	public Sequent(ArrayList<Formule> gamma, ArrayList<Formule> delta) {
		Gamma = gamma;
		Delta = delta;
	}

	

	public Formule Resoudre() {
		
		
		
		
		
		return null;
		
	}
	
	


	public Noeud noeudpasfini(){
	return new Noeud(this,new ArrayList<Preuve>(),"Encours");
	
}
	
	public ArrayList<Formule> getGamma() {
		return Gamma;
	}

	public ArrayList<Formule> getDelta() {
		return Delta;
	}
	
	public String affiche(){
		String staline = null;//nom a changer
		for(int i=0;i<Gamma.size();i++){
			staline+=Gamma.get(i).affiche()+" ";
		}
		staline+=" |-- ";
		for(int i=0;i<Delta.size();i++){
			staline+=Delta.get(i).affiche()+" ";
		}
		return staline;
	}

}