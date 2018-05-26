import java.util.ArrayList;

public class Feuille extends Preuve{
	
	//attributs
	
	//constructeurs
	public Feuille(Sequent concl){
		this.concl=concl;
	}
	
	//methodes
	public ArrayList<String> listString(){
		/*
		ArrayList<String> list= new ArrayList<String>();
		String s=new String(new char[concl.toString().length()]).replace("\0","-");
		s+="Ax";
		list.add(s);
		list.add(concl.toString());
		return list;
		*/
		return new ArrayList<String>();
	}

	public boolean estValide(){
		return true;
	}
}
