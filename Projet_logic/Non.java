import java.util.ArrayList;

public class Non extends Formule {

	
	private Formule arg;
	
	
	public Non(Formule arg) {
		this.arg=arg;
	}
	
	public String toString() {
		return "( " +"Non " + arg.toString() + " )"; //affichage Non  

	}
	@Override
	ArrayList<Formule> getArgs() {
		ArrayList<Formule> args = new ArrayList<Formule>();
		args.add(arg);
		return args;
	}
}
