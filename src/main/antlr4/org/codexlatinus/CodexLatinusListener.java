// Generated from CodexLatinus.g4 by ANTLR 4.13.1
package org.codexlatinus;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CodexLatinusParser}.
 */
public interface CodexLatinusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CodexLatinusParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CodexLatinusParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#globalVarsSection}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVarsSection(CodexLatinusParser.GlobalVarsSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#globalVarsSection}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVarsSection(CodexLatinusParser.GlobalVarsSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#functionsSection}.
	 * @param ctx the parse tree
	 */
	void enterFunctionsSection(CodexLatinusParser.FunctionsSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#functionsSection}.
	 * @param ctx the parse tree
	 */
	void exitFunctionsSection(CodexLatinusParser.FunctionsSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#mainSection}.
	 * @param ctx the parse tree
	 */
	void enterMainSection(CodexLatinusParser.MainSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#mainSection}.
	 * @param ctx the parse tree
	 */
	void exitMainSection(CodexLatinusParser.MainSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(CodexLatinusParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(CodexLatinusParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDecl(CodexLatinusParser.ArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDecl(CodexLatinusParser.ArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#arrayInit}.
	 * @param ctx the parse tree
	 */
	void enterArrayInit(CodexLatinusParser.ArrayInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#arrayInit}.
	 * @param ctx the parse tree
	 */
	void exitArrayInit(CodexLatinusParser.ArrayInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#structDecl}.
	 * @param ctx the parse tree
	 */
	void enterStructDecl(CodexLatinusParser.StructDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#structDecl}.
	 * @param ctx the parse tree
	 */
	void exitStructDecl(CodexLatinusParser.StructDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#structMember}.
	 * @param ctx the parse tree
	 */
	void enterStructMember(CodexLatinusParser.StructMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#structMember}.
	 * @param ctx the parse tree
	 */
	void exitStructMember(CodexLatinusParser.StructMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#structInit}.
	 * @param ctx the parse tree
	 */
	void enterStructInit(CodexLatinusParser.StructInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#structInit}.
	 * @param ctx the parse tree
	 */
	void exitStructInit(CodexLatinusParser.StructInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#structVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterStructVarDecl(CodexLatinusParser.StructVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#structVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitStructVarDecl(CodexLatinusParser.StructVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#structAttrAssignList}.
	 * @param ctx the parse tree
	 */
	void enterStructAttrAssignList(CodexLatinusParser.StructAttrAssignListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#structAttrAssignList}.
	 * @param ctx the parse tree
	 */
	void exitStructAttrAssignList(CodexLatinusParser.StructAttrAssignListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#structAttrAssign}.
	 * @param ctx the parse tree
	 */
	void enterStructAttrAssign(CodexLatinusParser.StructAttrAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#structAttrAssign}.
	 * @param ctx the parse tree
	 */
	void exitStructAttrAssign(CodexLatinusParser.StructAttrAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(CodexLatinusParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(CodexLatinusParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(CodexLatinusParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(CodexLatinusParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#funcVarSection}.
	 * @param ctx the parse tree
	 */
	void enterFuncVarSection(CodexLatinusParser.FuncVarSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#funcVarSection}.
	 * @param ctx the parse tree
	 */
	void exitFuncVarSection(CodexLatinusParser.FuncVarSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(CodexLatinusParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(CodexLatinusParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(CodexLatinusParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(CodexLatinusParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CodexLatinusParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CodexLatinusParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(CodexLatinusParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(CodexLatinusParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(CodexLatinusParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(CodexLatinusParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(CodexLatinusParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(CodexLatinusParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStmt(CodexLatinusParser.DoWhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStmt(CodexLatinusParser.DoWhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(CodexLatinusParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(CodexLatinusParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(CodexLatinusParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(CodexLatinusParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(CodexLatinusParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(CodexLatinusParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(CodexLatinusParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(CodexLatinusParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(CodexLatinusParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(CodexLatinusParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#continueStmt}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(CodexLatinusParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#continueStmt}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(CodexLatinusParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(CodexLatinusParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(CodexLatinusParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void enterReadStmt(CodexLatinusParser.ReadStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void exitReadStmt(CodexLatinusParser.ReadStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(CodexLatinusParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(CodexLatinusParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(CodexLatinusParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(CodexLatinusParser.LvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(CodexLatinusParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(CodexLatinusParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(CodexLatinusParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(CodexLatinusParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(CodexLatinusParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(CodexLatinusParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAndExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpr(CodexLatinusParser.LogicalAndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAndExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpr(CodexLatinusParser.LogicalAndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(CodexLatinusParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(CodexLatinusParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicativeExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(CodexLatinusParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativeExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(CodexLatinusParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOrExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpr(CodexLatinusParser.LogicalOrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOrExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpr(CodexLatinusParser.LogicalOrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(CodexLatinusParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(CodexLatinusParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(CodexLatinusParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(CodexLatinusParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(CodexLatinusParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(CodexLatinusParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostIncDecExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPostIncDecExpr(CodexLatinusParser.PostIncDecExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostIncDecExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPostIncDecExpr(CodexLatinusParser.PostIncDecExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LvalueExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLvalueExpr(CodexLatinusParser.LvalueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LvalueExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLvalueExpr(CodexLatinusParser.LvalueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(CodexLatinusParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(CodexLatinusParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(CodexLatinusParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link CodexLatinusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(CodexLatinusParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(CodexLatinusParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(CodexLatinusParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(CodexLatinusParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(CodexLatinusParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(CodexLatinusParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(CodexLatinusParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexLatinusParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CodexLatinusParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexLatinusParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CodexLatinusParser.LiteralContext ctx);
}