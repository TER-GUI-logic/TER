// Generated from Analyseur.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AnalyseurParser}.
 */
public interface AnalyseurListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AnalyseurParser#formul}.
	 * @param ctx the parse tree
	 */
	void enterFormul(AnalyseurParser.FormulContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyseurParser#formul}.
	 * @param ctx the parse tree
	 */
	void exitFormul(AnalyseurParser.FormulContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyseurParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(AnalyseurParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyseurParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(AnalyseurParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyseurParser#ou}.
	 * @param ctx the parse tree
	 */
	void enterOu(AnalyseurParser.OuContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyseurParser#ou}.
	 * @param ctx the parse tree
	 */
	void exitOu(AnalyseurParser.OuContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyseurParser#et}.
	 * @param ctx the parse tree
	 */
	void enterEt(AnalyseurParser.EtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyseurParser#et}.
	 * @param ctx the parse tree
	 */
	void exitEt(AnalyseurParser.EtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyseurParser#implique}.
	 * @param ctx the parse tree
	 */
	void enterImplique(AnalyseurParser.ImpliqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyseurParser#implique}.
	 * @param ctx the parse tree
	 */
	void exitImplique(AnalyseurParser.ImpliqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyseurParser#equivalent}.
	 * @param ctx the parse tree
	 */
	void enterEquivalent(AnalyseurParser.EquivalentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyseurParser#equivalent}.
	 * @param ctx the parse tree
	 */
	void exitEquivalent(AnalyseurParser.EquivalentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyseurParser#non}.
	 * @param ctx the parse tree
	 */
	void enterNon(AnalyseurParser.NonContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyseurParser#non}.
	 * @param ctx the parse tree
	 */
	void exitNon(AnalyseurParser.NonContext ctx);
}