import java.util.ArrayList;

public class Feuille extends Preuve{
	
	//attributs
	
	//constructeurs
	public Feuille(Sequent concl){
		this.concl=concl;
	}
	
	//methodes
	public ArrayList<String> listString(boolean mode){
		return new ArrayList<String>();
	}

	public boolean estValide(){
		return true;
	}
}
