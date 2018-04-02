import java.util.ArrayList;

public class Variable extends Formule {
	private String s;				// a modifier plus tard
	public Variable(String s) {
		this.s=s;
	}
	
	@Override
	String affiche() {
		return s;
	}

	@Override
	ArrayList<Formule> getArgs() {
		return null;
	}

}
