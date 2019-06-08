// generated with ast extension for cup
// version 0.8
// 8/5/2019 18:17:42


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Unmatched Unmatched);
    public void visit(Mulop Mulop);
    public void visit(VarDeclaration VarDeclaration);
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
    public void visit(VarList VarList);
    public void visit(FactorTypeExpr FactorTypeExpr);
    public void visit(CondFactList CondFactList);
    public void visit(ConstList ConstList);
    public void visit(ArrayOpt ArrayOpt);
    public void visit(NewInitList NewInitList);
    public void visit(Condition Condition);
    public void visit(For For);
    public void visit(ConstDef ConstDef);
    public void visit(EnumList EnumList);
    public void visit(BoolConst BoolConst);
    public void visit(ActualParamList ActualParamList);
    public void visit(BoolConstDef BoolConstDef);
    public void visit(EnumNumbering EnumNumbering);
    public void visit(VarDeclList VarDeclList);
    public void visit(FormalParamList FormalParamList);
    public void visit(Expr Expr);
    public void visit(InitList InitList);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ActualPars ActualPars);
    public void visit(Statement Statement);
    public void visit(CondFact CondFact);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(ArrayForPar ArrayForPar);
    public void visit(FormPars FormPars);
    public void visit(MethodTypeN MethodTypeN);
    public void visit(MethodDeclr MethodDeclr);
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
    public void visit(InitListNo InitListNo);
    public void visit(InitListYes InitListYes);
    public void visit(NewInitListNo NewInitListNo);
    public void visit(NewInitListYes NewInitListYes);
    public void visit(DuzinaNiza DuzinaNiza);
    public void visit(FuncCall FuncCall);
    public void visit(Var Var);
    public void visit(FactorNewArr FactorNewArr);
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
    public void visit(CndFctNotBool CndFctNotBool);
    public void visit(CndFct CndFct);
    public void visit(CondFactListDerived1 CondFactListDerived1);
    public void visit(CondFacts CondFacts);
    public void visit(CondT CondT);
    public void visit(Andbegadr Andbegadr);
    public void visit(CondTermListDerived1 CondTermListDerived1);
    public void visit(CondTerms CondTerms);
    public void visit(ConditError ConditError);
    public void visit(Condit Condit);
    public void visit(EmptyForCond EmptyForCond);
    public void visit(ForCond ForCond);
    public void visit(ForDesignatorDerived1 ForDesignatorDerived1);
    public void visit(ForDesign ForDesign);
    public void visit(ForFor ForFor);
    public void visit(Endelse Endelse);
    public void visit(Begelse Begelse);
    public void visit(Endfor Endfor);
    public void visit(Begfor Begfor);
    public void visit(Endinc Endinc);
    public void visit(BegForCond BegForCond);
    public void visit(Beginc Beginc);
    public void visit(Begif Begif);
    public void visit(Ifif Ifif);
    public void visit(Rd Rd);
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
    public void visit(Endif Endif);
    public void visit(UnmatchedIfElse UnmatchedIfElse);
    public void visit(UnmatchedIf UnmatchedIf);
    public void visit(UnmachedStmt UnmachedStmt);
    public void visit(MatchedStmt MatchedStmt);
    public void visit(NoStmt NoStmt);
    public void visit(Statements Statements);
    public void visit(ArrayForParN ArrayForParN);
    public void visit(ArrayForParY ArrayForParY);
    public void visit(FormalParamDecl FormalParamDecl);
    public void visit(ErrFormPar ErrFormPar);
    public void visit(SingleFormalParamDecl SingleFormalParamDecl);
    public void visit(FormalParamDecls FormalParamDecls);
    public void visit(NoFormParam NoFormParam);
    public void visit(FormParams FormParams);
    public void visit(MethodTypeVoid MethodTypeVoid);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(ErrMethDecl ErrMethDecl);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoMethodDecl NoMethodDecl);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(Type Type);
    public void visit(BoolFalseDef BoolFalseDef);
    public void visit(BoolTrueDef BoolTrueDef);
    public void visit(FactorBoolDef FactorBoolDef);
    public void visit(CharConstDef CharConstDef);
    public void visit(ConstDefNum ConstDefNum);
    public void visit(EnumNoNmbr EnumNoNmbr);
    public void visit(EnumNmbr EnumNmbr);
    public void visit(EnumElem EnumElem);
    public void visit(EnumLst EnumLst);
    public void visit(EnumName EnumName);
    public void visit(CnstListEmpty CnstListEmpty);
    public void visit(CnstList CnstList);
    public void visit(ArrayOptN ArrayOptN);
    public void visit(ArrayOptY ArrayOptY);
    public void visit(VarListN VarListN);
    public void visit(VarListY VarListY);
    public void visit(EnumDecl EnumDecl);
    public void visit(ConstDecl ConstDecl);
    public void visit(VarDecl VarDecl);
    public void visit(ErrVarDecl ErrVarDecl);
    public void visit(NoVarDecl NoVarDecl);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
