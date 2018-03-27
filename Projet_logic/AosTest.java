import org.antlr.v4.runtime.*;

public class AosTest{
	
	public static void main(String [] argv){
	ANTLRInputStream stream = new ANTLRInputStream(argv[0]);
	AnalyseurLexer lexer= new AnalyseurLexer(stream);
	CommonTokenStream tokens=new CommonTokenStream(lexer);
	AnalyseurParser parser=new AnalyseurParser(tokens);
	Formule f=parser.formul().value;
	System.out.println(f.affiche());

	}
}