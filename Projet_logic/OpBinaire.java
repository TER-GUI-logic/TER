import java.util.ArrayList;

public abstract class OpBinaire extends Formule {
	public Formule argG;
	public Formule argD;
	
	public OpBinaire(Formule argG, Formule argD){
		this.argG=argG;
		this.argD=argD;
	}
	public Formule getArgG() {
		return this.argG;
	}

	public Formule getArgD() {
		return this.argD;
	}
	@Override
	ArrayList<Formule> getArgs() {
		// TODO Auto-generated method stub
		ArrayList<Formule> args = new ArrayList<Formule>();
		args.add(argG);
		args.add(argD);
		
		return args;
	}
}
