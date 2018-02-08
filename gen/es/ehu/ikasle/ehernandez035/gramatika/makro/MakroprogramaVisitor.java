// Generated from /home/elena/workspace/Test/src/main/antlr4/Makroprograma.g4 by ANTLR 4.7
package es.ehu.ikasle.ehernandez035.gramatika.makro;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MakroprogramaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MakroprogramaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MakroprogramaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(MakroprogramaParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakroprogramaParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(MakroprogramaParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link MakroprogramaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(MakroprogramaParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link MakroprogramaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(MakroprogramaParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code esleipen}
	 * labeled alternative in {@link MakroprogramaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEsleipen(MakroprogramaParser.EsleipenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hitza}
	 * labeled alternative in {@link MakroprogramaParser#adierazpena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHitza(MakroprogramaParser.HitzaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aldagaia}
	 * labeled alternative in {@link MakroprogramaParser#adierazpena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAldagaia(MakroprogramaParser.AldagaiaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hutsa}
	 * labeled alternative in {@link MakroprogramaParser#adierazpena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHutsa(MakroprogramaParser.HutsaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code car}
	 * labeled alternative in {@link MakroprogramaParser#adierazpena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCar(MakroprogramaParser.CarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funtzioDeia}
	 * labeled alternative in {@link MakroprogramaParser#adierazpena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuntzioDeia(MakroprogramaParser.FuntzioDeiaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code deskod}
	 * labeled alternative in {@link MakroprogramaParser#adierazpena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeskod(MakroprogramaParser.DeskodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notAdierazpena}
	 * labeled alternative in {@link MakroprogramaParser#adierazpena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotAdierazpena(MakroprogramaParser.NotAdierazpenaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alderaketak}
	 * labeled alternative in {@link MakroprogramaParser#adierazpena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlderaketak(MakroprogramaParser.AlderaketakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cons}
	 * labeled alternative in {@link MakroprogramaParser#adierazpena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCons(MakroprogramaParser.ConsContext ctx);
}