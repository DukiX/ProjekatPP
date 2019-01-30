package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	int nVars;
	
	public static final Struct boolType = new Struct(Struct.Bool);
	
	public SemanticAnalyzer() {
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}
	
	private Struct var_type=Tab.noType;

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getPName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(VarDecl varDecl) {
		report_info("Deklarisana promenljiva " + varDecl.getVarName(), varDecl);
		Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), varDecl.getType().struct);
	}

	public void visit(ConstDecl constDecl) {
		report_info("Deklarisana konstanta " + constDecl.getConstName(), constDecl);
		Obj varNode = Tab.insert(Obj.Con, constDecl.getConstName(), constDecl.getType().struct);
	}
	
	public void visit(VarDeclArray arrayDecl) {
		report_info("Deklarisan niz " + arrayDecl.getArrayName(), arrayDecl);
		Obj varNode = Tab.insert(Obj.Var, arrayDecl.getArrayName(), new Struct(Struct.Array, arrayDecl.getType().struct));
	}
	
	public void visit(FormalParamDecl fpd) {
		report_info("Deklarisan formalni argument " + fpd.getFormalName(), fpd);
		Obj varNode = Tab.insert(Obj.Var, fpd.getFormalName(), fpd.getType().struct);
	}
	
	public void visit(Increment inc) {
		if(inc.getDesignator().obj.getKind()!=Obj.Var) { //elem niza ili polje obj
			report_error("++ mora imati promenljivu: " + inc.getDesignator().getName() + " na liniji " + inc.getLine(), null);
		}
		if(inc.getDesignator().obj.getType()!=Tab.intType) {
			report_error("Promenljiva kod ++ mora biti INT: " + inc.getDesignator().getName() + " na liniji " + inc.getLine(), null);
		}
	}
	
	public void visit(Decrement dec) {
		if(dec.getDesignator().obj.getKind()!=Obj.Var) {//elem niza ili polje obj
			report_error("-- mora imati promenljivu: " + dec.getDesignator().getName() + " na liniji " + dec.getLine(), null);
		}
		if(dec.getDesignator().obj.getType()!=Tab.intType) {
			report_error("Promenljiva kod -- mora biti INT: " + dec.getDesignator().getName() + " na liniji " + dec.getLine(), null);
		}
	}

	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola", null);
			var_type = type.struct = Tab.noType;
		} else {
			if (Obj.Type == typeNode.getKind()) {
				var_type = type.struct = typeNode.getType();
			} else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip ", type);
				var_type = type.struct = Tab.noType;
			}
		}
	}

	public void visit(MethodDecl methodDecl) {
		if (!returnFound && currentMethod.getType() != Tab.noType) {
			report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funcija " + currentMethod.getName()
					+ " nema return iskaz!", null);
		}

		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();

		returnFound = false;
		currentMethod = null;
	}

	public void visit(MethodTypeName methodTypeName) {
		currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), methodTypeName.getType().struct);
		methodTypeName.obj = currentMethod;
		Tab.openScope();
		report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
	}

	public void visit(Assignment assignment) {
		if (!assignment.getExpr().struct.assignableTo(assignment.getDesignator().obj.getType()))
			report_error(
					"Greska na liniji " + assignment.getLine() + " : " + " nekompatibilni tipovi u dodeli vrednosti "+
							assignment.getDesignator().obj.getType().getKind()+" "+assignment.getExpr().struct.getKind(),
					null);
	}

	public void visit(PrintStmt printStmt) {
		printCallCount++;
		if(printStmt.getExpr().struct!=Tab.intType && printStmt.getExpr().struct!=Tab.charType) { //ili bool
			report_error("Promenljiva kod print mora biti INT ili CHAR na liniji " + printStmt.getLine(), null);
		}
	}

	public void visit(ReturnExpr returnExpr) {
		returnFound = true;
		Struct currMethType = currentMethod.getType();
		if (!currMethType.compatibleWith(returnExpr.getExpr().struct)) {
			report_error("Greska na liniji " + returnExpr.getLine() + " : "
					+ "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije "
					+ currentMethod.getName(), null);
		}
	}

	public void visit(ProcCall procCall) {
		Obj func = procCall.getDesignator().obj;
		if (Obj.Meth == func.getKind()) {
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + procCall.getLine(), null);
			// RESULT = func.getType();
		} else {
			report_error("Greska na liniji " + procCall.getLine() + " : ime " + func.getName() + " nije funkcija!",
					null);
			// RESULT = Tab.noType;
		}
	}

	public void visit(AddExpr addExpr) {
		Struct te = addExpr.getExpr().struct;
		Struct t = addExpr.getTerm().struct;
		if (te.equals(t) && te == Tab.intType)
			addExpr.struct = te;
		else {
			report_error("Greska na liniji " + addExpr.getLine()
					+ " : nekompatibilni tipovi u izrazu za sabiranje/oduzimanje.", null);
			addExpr.struct = Tab.noType;
		}
	}

	public void visit(MulopFactor mulFact) {
		Struct t = mulFact.getFactor().struct;
		if (t == Tab.intType) {
			mulFact.struct = t;
		} else {
			report_error("Greska na liniji " + mulFact.getParent().getLine()
					+ " : nekompatibilni tipovi u izrazu za mnozenje/deljenje.", null);
			mulFact.struct = Tab.noType;
		}
	}

	public void visit(TermExpr termExpr) {
		termExpr.struct = termExpr.getTerm().struct;
	}

	public void visit(Term term) {
		term.struct = term.getFactor().struct;
	}

	public void visit(Const cnst) {
		cnst.struct = Tab.intType;
	}
	
	public void visit(CharConst cc) {
		cc.struct = Tab.charType;
	}
	
	public void visit(FactorBool fb) {
		fb.struct = fb.getBoolConst().struct;
	}
	
	public void visit(BoolTrue bt) {
		bt.struct = boolType;
	}
	
	public void visit(BoolFalse bf) {
		bf.struct = boolType;
	}

	public void visit(Var var) {
		var.struct = var.getDesignator().obj.getType();
	}

	public void visit(FuncCall funcCall) {
		Obj func = funcCall.getDesignator().obj;
		if (Obj.Meth == func.getKind()) {
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.struct = func.getType();
		} else {
			report_error("Greska na liniji " + funcCall.getLine() + " : ime " + func.getName() + " nije funkcija!",
					null);
			funcCall.struct = Tab.noType;
		}

	}

	
	
	public void visit(Designator designator){
		Obj obj = Tab.find(designator.getName());
		if (obj == Tab.noObj) { 
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getName()+" nije deklarisano! ", null);
		}
		designator.obj = obj;
		if(obj.getKind()==Obj.Var) {
			if(obj.getLevel()==0) {
				report_info("Upotreba globalne promenljive " + designator.getName() + " na liniji " + designator.getLine(), null);
			}else {
				report_info("Upotreba lokalne promenljive " + designator.getName() + " na liniji " + designator.getLine(), null);
			}
		}else if(obj.getKind()==Obj.Con){
			if(obj.getLevel()==0) {
				report_info("Upotreba globalne konstante " + designator.getName() + " na liniji " + designator.getLine(), null);
			}else {
				report_info("Upotreba lokalne konstante " + designator.getName() + " na liniji " + designator.getLine(), null);
			}
		}
	}
	
	private int inFor=0;
	
	public void visit(ForFor fd) {
		inFor++;
	}
	
	public void visit(MatchedBreak mb) {
		if(inFor==0) {
			report_error("Greska na liniji " + mb.getParent().getLine()+ " : break van fora! ", null);
		}
	}
	
	public void visit(MatchedContinue mc) {
		if(inFor==0) {
			report_error("Greska na liniji " + mc.getParent().getLine()+ " : continue van fora! ", null);
		}
	}
	
	public void visit(MatchedFor mf) {
		inFor--;
	}
	
	public void visit(MatchedRead mr) {
		if(mr.getDesignator().obj.getKind()!=Obj.Var) { // ili elem niza ili polje objekta
			report_error("Read mora imati promenljivu: " + mr.getDesignator().getName() + " na liniji " + mr.getLine(), null);
		}
		if(mr.getDesignator().obj.getType()!=Tab.intType && mr.getDesignator().obj.getType()!=Tab.charType) { //ili bool
			report_error("Promenljiva kod read mora biti INT ili CHAR " + mr.getDesignator().getName() + " na liniji " + mr.getLine(), null);
		}
	}
	
	public void visit(PrintStmtTwo pst) {
		printCallCount++;
		if(pst.getExpr().struct!=Tab.intType && pst.getExpr().struct!=Tab.charType) { //ili bool
			report_error("Promenljiva kod print mora biti INT ili CHAR na liniji " + pst.getLine(), null);
		}
	}
	
	/*public void visit(SquareDesignatorOption sdo) {
		sdo.struct = new Struct(Struct.Int);
	}*/

	public boolean passed() {
		return !errorDetected;
	}

}
