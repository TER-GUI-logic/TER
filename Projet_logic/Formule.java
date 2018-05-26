import java.util.ArrayList;
import org.antlr.v4.runtime.*;

public abstract class Formule {
	public abstract String toString();
	abstract ArrayList<Formule> getArgs();
	static Formule entrerFormule(String s){
		CharStream stream = CharStreams.fromString(s);
		AnalyseurLexer lexer= new AnalyseurLexer(stream);
		CommonTokenStream tokens=new CommonTokenStream(lexer);
		AnalyseurParser parser=new AnalyseurParser(tokens);
		return parser.formul().value;
	}
}
