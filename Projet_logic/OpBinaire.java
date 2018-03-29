import java.util.ArrayList;

public abstract class OpBinaire extends Formule {
	public Formule argG;
	public Formule argD;
	
	public Formule getArgG() {
		return this.argG;
	}

	public Formule getArgD() {
		return this.argD;
	}
	@Override
	ArrayList<Formule> getArgs() {
		// TODO Auto-generated method stub
		ArrayList<Formule> prof_X = new ArrayList<Formule> ();
		prof_X.add(argG);
		prof_X.add(argD);
		
		return prof_X ;
	}
}
