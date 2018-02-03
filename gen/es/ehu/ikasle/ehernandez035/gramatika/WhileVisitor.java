// Generated from /home/elena/workspace/Test/src/main/antlr4/While.g4 by ANTLR 4.7
package es.ehu.ikasle.ehernandez035.gramatika;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WhileParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WhileVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WhileParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(WhileParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link WhileParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(WhileParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link WhileParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(WhileParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code esleipen}
	 * labeled alternative in {@link WhileParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEsleipen(WhileParser.EsleipenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hutsa}
	 * labeled alternative in {@link WhileParser#adierazpena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHutsa(WhileParser.HutsaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cdr}
	 * labeled alternative in {@link WhileParser#adierazpena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCdr(WhileParser.CdrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cons}
	 * labeled alternative in {@link WhileParser#adierazpena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCons(WhileParser.ConsContext ctx);
}