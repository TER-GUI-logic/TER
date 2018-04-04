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
	
	public Feuille feuille(){
		return new Feuille(this);
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
		String S = "";
		if(Gamma.size()!=0){
		S+=Gamma.get(0).affiche()+" ";


		for(int i=1;i<Gamma.size();i++){
			S+=", "+Gamma.get(i).affiche();
		}
		}
		S+=" |-- ";
		if(Delta.size()!=0){
		S+=Delta.get(0).affiche()+" ";
		for(int i=1;i<Delta.size();i++){
			S+=", "+Delta.get(i).affiche();
		}
	}
		return S;
	}

}