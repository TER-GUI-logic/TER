import java.util.ArrayList;

public abstract class Preuve {
	Sequent concl;

	public Sequent getConcl() {
		return concl;
	}

    public abstract boolean estValide();
    public abstract ArrayList<String> listString();

}
