import java.util.ArrayList;

abstract public class Preuve {
	Sequent concl;

	public Sequent getConcl() {
		return concl;
	}

    public abstract String toString();
    public abstract ArrayList<String> listString();

}
