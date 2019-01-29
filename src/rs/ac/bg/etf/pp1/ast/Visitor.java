// generated with ast extension for cup
// version 0.8
// 29/0/2019 10:49:1


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Unmatched Unmatched);
    public void visit(Mulop Mulop);
    public void visit(ForDesignator ForDesignator);
    public void visit(DesignatorOptions DesignatorOptions);
    public void visit(Matched Matched);
    public void visit(Relop Relop);
    public void visit(CondTermList CondTermList);
    public void visit(StatementList StatementList);
    public void visit(FactorList FactorList);
    public void visit(Addop Addop);
    public void visit(ForCondition ForCondition);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(FactorTypeExpr FactorTypeExpr);
    public void visit(CondFactList CondFactList);
    public void visit(Condition Condition);
    public void visit(CondFactNotBool CondFactNotBool);
    public void visit(BoolConst BoolConst);
    public void visit(ActualParamList ActualParamList);
    public void visit(VarDeclList VarDeclList);
    public void visit(FormalParamList FormalParamList);
    public void visit(Expr Expr);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ActualPars ActualPars);
    public void visit(Statement Statement);
    public void visit(CondFact CondFact);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(FormPars FormPars);
    public void visit(Relle Relle);
    public void visit(Relge Relge);
    public void visit(Rellt Rellt);
    public void visit(Relgt Relgt);
    public void visit(Relne Relne);
    public void visit(Releq Releq);
    public void visit(Modop Modop);
    public void visit(Divop Divop);
    public void visit(Timesop Timesop);
    public void visit(Minop Minop);
    public void visit(Plusop Plusop);
    public void visit(NoDesignatorOptions NoDesignatorOptions);
    public void visit(SquareDesignatorOption SquareDesignatorOption);
    public void visit(DotDesignatorOption DotDesignatorOption);
    public void visit(Designator Designator);
    public void visit(ActualParam ActualParam);
    public void visit(ActualParams ActualParams);
    public void visit(NoActuals NoActuals);
    public void visit(Actuals Actuals);
    public void visit(BoolFalse BoolFalse);
    public void visit(BoolTrue BoolTrue);
    public void visit(NoFactorTypeExpr NoFactorTypeExpr);
    public void visit(YFactorTypeExpr YFactorTypeExpr);
    public void visit(FuncCall FuncCall);
    public void visit(Var Var);
    public void visit(FactorNew FactorNew);
    public void visit(FactorBool FactorBool);
    public void visit(FactorExpr FactorExpr);
    public void visit(CharConst CharConst);
    public void visit(Const Const);
    public void visit(NoFactor NoFactor);
    public void visit(MulopFactor MulopFactor);
    public void visit(Term Term);
    public void visit(MinusTerm MinusTerm);
    public void visit(TermExpr TermExpr);
    public void visit(AddExpr AddExpr);
    public void visit(Decrement Decrement);
    public void visit(Increment Increment);
    public void visit(Assignment Assignment);
    public void visit(ProcCall ProcCall);
    public void visit(CondFactNotBoolDerived1 CondFactNotBoolDerived1);
    public void visit(CndFctNotBool CndFctNotBool);
    public void visit(CndFct CndFct);
    public void visit(CondFactListDerived1 CondFactListDerived1);
    public void visit(CondFacts CondFacts);
    public void visit(CondT CondT);
    public void visit(CondTermListDerived1 CondTermListDerived1);
    public void visit(CondTerms CondTerms);
    public void visit(Condit Condit);
    public void visit(ForConditionDerived1 ForConditionDerived1);
    public void visit(ForCond ForCond);
    public void visit(ForDesignatorDerived1 ForDesignatorDerived1);
    public void visit(ForDesign ForDesign);
    public void visit(MatchedFor MatchedFor);
    public void visit(MatchedBreak MatchedBreak);
    public void visit(MatchedContinue MatchedContinue);
    public void visit(MatchedBraces MatchedBraces);
    public void visit(PrintStmtTwo PrintStmtTwo);
    public void visit(MatchedRead MatchedRead);
    public void visit(MatchedDesignatorStatement MatchedDesignatorStatement);
    public void visit(MatchedIf MatchedIf);
    public void visit(ReturnNoExpr ReturnNoExpr);
    public void visit(ReturnExpr ReturnExpr);
    public void visit(PrintStmt PrintStmt);
    public void visit(ErrAssignment ErrAssignment);
    public void visit(UnmatchedIfElse UnmatchedIfElse);
    public void visit(UnmatchedIf UnmatchedIf);
    public void visit(UnmachedStmt UnmachedStmt);
    public void visit(MatchedStmt MatchedStmt);
    public void visit(NoStmt NoStmt);
    public void visit(Statements Statements);
    public void visit(FormalParamDecl FormalParamDecl);
    public void visit(SingleFormalParamDecl SingleFormalParamDecl);
    public void visit(FormalParamDecls FormalParamDecls);
    public void visit(NoFormParam NoFormParam);
    public void visit(FormParams FormParams);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoMethodDecl NoMethodDecl);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(Type Type);
    public void visit(VarDecl VarDecl);
    public void visit(NoVarDecl NoVarDecl);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
