// Generated from CodexLatinus.g4 by ANTLR 4.13.1
package org.codexlatinus;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CodexLatinusParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CodexLatinusVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CodexLatinusParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#globalVarsSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalVarsSection(CodexLatinusParser.GlobalVarsSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#functionsSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionsSection(CodexLatinusParser.FunctionsSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#mainSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainSection(CodexLatinusParser.MainSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(CodexLatinusParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDecl(CodexLatinusParser.ArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#arrayInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInit(CodexLatinusParser.ArrayInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#structDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDecl(CodexLatinusParser.StructDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#structMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructMember(CodexLatinusParser.StructMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#structInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructInit(CodexLatinusParser.StructInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#structVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructVarDecl(CodexLatinusParser.StructVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#structAttrAssignList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructAttrAssignList(CodexLatinusParser.StructAttrAssignListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#structAttrAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructAttrAssign(CodexLatinusParser.StructAttrAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(CodexLatinusParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(CodexLatinusParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#funcVarSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncVarSection(CodexLatinusParser.FuncVarSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(CodexLatinusParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(CodexLatinusParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CodexLatinusParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#blockStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(CodexLatinusParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(CodexLatinusParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(CodexLatinusParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#doWhileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStmt(CodexLatinusParser.DoWhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(CodexLatinusParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(CodexLatinusParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(CodexLatinusParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(CodexLatinusParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(CodexLatinusParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#continueStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(CodexLatinusParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(CodexLatinusParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#readStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStmt(CodexLatinusParser.ReadStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(CodexLatinusParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(CodexLatinusParser.LvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(CodexLatinusParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(CodexLatinusParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(CodexLatinusParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAndExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpr(CodexLatinusParser.LogicalAndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(CodexLatinusParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicativeExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(CodexLatinusParser.MultiplicativeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOrExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpr(CodexLatinusParser.LogicalOrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(CodexLatinusParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(CodexLatinusParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(CodexLatinusParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostIncDecExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncDecExpr(CodexLatinusParser.PostIncDecExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LvalueExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueExpr(CodexLatinusParser.LvalueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(CodexLatinusParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(CodexLatinusParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(CodexLatinusParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(CodexLatinusParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(CodexLatinusParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexLatinusParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CodexLatinusParser.LiteralContext ctx);
}