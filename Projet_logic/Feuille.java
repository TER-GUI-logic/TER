
public class Feuille extends Preuve{
	
	//attributs
	
	//constructeurs
	public Feuille(Sequent concl){
		this.concl=concl;
	}
	
	//methodes
	public String toString(){
			return "AX\n"+concl.toString();
	}
}

