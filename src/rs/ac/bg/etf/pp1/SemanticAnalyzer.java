package rs.ac.bg.etf.pp1;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.structure.HashTableDataStructure;

public class SemanticAnalyzer extends VisitorAdaptor {

	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	int nVars;
	
	int brGrobProm;
	int brGlobConst;
	int brGlobNiz;
	int brMet;
	int brEnuma;

	public static final Struct boolType = new Struct(Struct.Bool);
	// public static final Struct enumType = new Struct(Struct.Enum,Tab.intType);

	public SemanticAnalyzer() {
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));

		// CHR metoda
		currentMethod = Tab.chrObj;
		Tab.openScope();

		Obj varNode = Tab.insert(Obj.Var, "i", Tab.intType);
		currentMethod.setLevel(1);
		varNode.setLevel(1);
		varNode.setFpPos(1);

		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		returnFound = false;
		currentMethod = null;

		// ORD metoda
		currentMethod = Tab.ordObj;
		Tab.openScope();

		varNode = Tab.insert(Obj.Var, "ch", Tab.charType);
		currentMethod.setLevel(1);
		varNode.setLevel(1);
		varNode.setFpPos(1);

		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		returnFound = false;
		currentMethod = null;
		
		// LEN metoda
		currentMethod = Tab.lenObj;
		Tab.openScope();

		varNode = Tab.insert(Obj.Var, "arr", new Struct(Struct.Array, Tab.noType));
		currentMethod.setLevel(1);
		varNode.setLevel(1);
		varNode.setFpPos(1);

		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		returnFound = false;
		currentMethod = null;
	}

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

	/*
	 * public void visit(VarDeclArray arrayDecl) { report_info("Deklarisan niz " +
	 * arrayDecl.getArrayName(), arrayDecl); Obj varNode = Tab.insert(Obj.Var,
	 * arrayDecl.getArrayName(), new Struct(Struct.Array,
	 * arrayDecl.getType().struct)); }
	 */

	private LinkedList<Integer> nizForParLista = new LinkedList<>();

	public void visit(FormalParamDecl fpd) {
		if (nizForParLista.removeLast() == 1) {
			report_info("Deklarisan formalni parametar " + fpd.getFormalName(), fpd);
			Obj varNode = Tab.insert(Obj.Var, fpd.getFormalName(), new Struct(Struct.Array, fpd.getType().struct));
			int brojParam = currentMethod.getLevel();
			currentMethod.setLevel(++brojParam);
			varNode.setFpPos(brojParam);
		} else {
			report_info("Deklarisan formalni parametar " + fpd.getFormalName(), fpd);
			Obj varNode = Tab.insert(Obj.Var, fpd.getFormalName(), fpd.getType().struct);
			int brojParam = currentMethod.getLevel();
			currentMethod.setLevel(++brojParam);
			varNode.setFpPos(brojParam);
		}
	}

	public void visit(ArrayForParY afpy) {
		nizForParLista.add(1);
	}

	public void visit(ArrayForParN afpn) {
		nizForParLista.add(0);
	}

	private LinkedList<Integer> nizDeclLista = new LinkedList<>();

	public void visit(VarDecl varDecl) {
		if (nizDeclLista.removeLast() == 1) {
			report_info("Deklarisan niz " + varDecl.getVarName(), varDecl);
			Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), new Struct(Struct.Array, varDecl.getType().struct));
		} else {
			report_info("Deklarisana promenljiva " + varDecl.getVarName(), varDecl);
			Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), varDecl.getType().struct);
		}
	}

	public void visit(VarListY vly) {
		if (nizDeclLista.removeLast() == 1) {
			vly.setLine(linija);
			vly.struct = varTip;
			report_info("Deklarisan niz " + vly.getVarName(), vly);
			Obj varNode = Tab.insert(Obj.Var, vly.getVarName(), new Struct(Struct.Array, vly.struct));
		} else {
			vly.struct = varTip;
			vly.setLine(linija);
			report_info("Deklarisana promenljiva " + vly.getVarName(), vly);
			Obj varNode = Tab.insert(Obj.Var, vly.getVarName(), vly.struct);
		}
	}

	public void visit(ArrayOptY aoy) {
		nizDeclLista.add(1);
		if(currentMethod==null) {
			brGlobNiz++;
		}
	}

	public void visit(ArrayOptN aon) {
		nizDeclLista.add(0);
		if(currentMethod==null) {
			brGrobProm++;
		}
	}

	private LinkedList<Integer> constInt = new LinkedList<>();

	public void visit(ConstDecl constDecl) {
		if (constDecl.getType().struct == constDecl.getConstDef().struct) {
			report_info("Deklarisana konstanta " + constDecl.getConstName(), constDecl);
			Obj varNode = Tab.insert(Obj.Con, constDecl.getConstName(), constDecl.getType().struct);
			varNode.setAdr(constInt.removeLast());
		} else {
			report_error("Deklarisana konstanta nije dobrog tipa: " + constDecl.getConstName(), constDecl);
			Obj varNode = Tab.insert(Obj.Con, constDecl.getConstName(), constDecl.getType().struct);
			varNode.setAdr(constInt.removeLast());
		}
		
		if(currentMethod==null) {
			brGlobConst++;
		}
	}

	public void visit(CnstList constDecl) {
		if (varTip == constDecl.getConstDef().struct) {
			constDecl.setLine(linija);
			report_info("Deklarisana konstanta " + constDecl.getConstName(), constDecl);
			Obj varNode = Tab.insert(Obj.Con, constDecl.getConstName(), varTip);
			varNode.setAdr(constInt.removeLast());
		} else {
			constDecl.setLine(linija);
			report_error("Deklarisana konstanta nije dobrog tipa: " + constDecl.getConstName(), constDecl);
			Obj varNode = Tab.insert(Obj.Con, constDecl.getConstName(), varTip);
			varNode.setAdr(constInt.removeLast());
		}
		
		if(currentMethod==null) {
			brGlobConst++;
		}
	}

	public void visit(ConstDefNum dfn) {
		dfn.struct = Tab.intType;
		constInt.add(dfn.getN1());
	}

	public void visit(CharConstDef ccd) {
		ccd.struct = Tab.charType;
		constInt.add((int) ccd.getC1());
	}

	public void visit(FactorBoolDef fbd) {
		fbd.struct = boolType;
	}

	public void visit(BoolTrueDef btd) {
		constInt.add(1);
	}

	public void visit(BoolFalseDef bfd) {
		constInt.add(0);
	}

	public void visit(EnumElem el) {
		report_info("Deklarisan element nabrajanja " + el.getName(), el);
		Obj o = new Obj(Obj.Con, el.getName(), Tab.intType);
		int nextConst = enumInt.removeLast();
		if (nextConst == -1) {
			o.setAdr(enumConstCount++);
		} else {
			if (dosadasnjeKonstanteEnuma.contains(nextConst)) {
				report_error("Dupla konstanta u enumu " + el.getName(), el);
			}
			o.setAdr(nextConst);
			enumConstCount = nextConst + 1;
		}
		dosadasnjeKonstanteEnuma.add(o.getAdr());
		okruzujuciEnum.getType().getMembersTable().insertKey(o);
	}

	public void visit(EnumLst el) {
		report_info("Deklarisan element nabrajanja " + el.getName(), el);
		Obj o = new Obj(Obj.Con, el.getName(), Tab.intType);
		int nextConst = enumInt.removeLast();
		if (nextConst == -1) {
			o.setAdr(enumConstCount++);
		} else {
			if (dosadasnjeKonstanteEnuma.contains(nextConst)) {
				report_error("Dupla konstanta u enumu " + el.getName(), el);
			}
			o.setAdr(nextConst);
			enumConstCount = nextConst + 1;
		}
		dosadasnjeKonstanteEnuma.add(o.getAdr());
		okruzujuciEnum.getType().getMembersTable().insertKey(o);
	}

	private Obj okruzujuciEnum = null;

	private int enumConstCount = 0;

	private LinkedList<Integer> dosadasnjeKonstanteEnuma;

	public void visit(EnumName en) {
		Struct estr = new Struct(Struct.Enum, new HashTableDataStructure());
		okruzujuciEnum = en.obj = Tab.insert(Obj.Type, en.getEnumNme(), estr);
		report_info("Deklarisano nabrajanje " + en.getEnumNme(), en);

		enumConstCount = 0;

		dosadasnjeKonstanteEnuma = new LinkedList<>();
		
		brEnuma++;
	}

	private LinkedList<Integer> enumInt = new LinkedList<>();

	public void visit(EnumNmbr en) {
		en.struct = Tab.intType;
		enumInt.add(en.getN1());
	}

	public void visit(EnumNoNmbr enn) {
		enn.struct = Tab.intType;
		enumInt.add(-1);
	}

	public void visit(Increment inc) {
		if (inc.getDesignator().obj.getKind() != Obj.Var && inc.getDesignator().obj.getKind() != Obj.Elem) {
			report_error("++ mora imati promenljivu ili element niza: " + inc.getDesignator().getName() + " na liniji "
					+ inc.getLine(), null);
		}
		if (inc.getDesignator().obj.getType() != Tab.intType) {
			report_error("Promenljiva kod ++ mora biti INT: " + inc.getDesignator().getName() + " na liniji "
					+ inc.getLine(), null);
		}
	}

	public void visit(Decrement dec) {
		if (dec.getDesignator().obj.getKind() != Obj.Var && dec.getDesignator().obj.getKind() != Obj.Elem) {
			report_error("-- mora imati promenljivu ili element niza: " + dec.getDesignator().getName() + " na liniji "
					+ dec.getLine(), null);
		}
		if (dec.getDesignator().obj.getType() != Tab.intType) {
			report_error("Promenljiva kod -- mora biti INT: " + dec.getDesignator().getName() + " na liniji "
					+ dec.getLine(), null);
		}
	}

	private Struct varTip;
	private int linija;

	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola", null);
			type.struct = Tab.noType;
		} else {
			if (Obj.Type == typeNode.getKind()) {
				if (typeNode.getType().getKind() != Struct.Enum) {
					type.struct = typeNode.getType();
				} else {
					type.struct = Tab.intType;
				}
			} else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip ", type);
				type.struct = Tab.noType;
			}
		}
		varTip = type.struct;
		linija = type.getLine();
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
		
		brMet++;
	}

	public void visit(MethodTypeName methodTypeName) {
		currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), methodTypeName.getType().struct);
		methodTypeName.obj = currentMethod;
		Tab.openScope();
		report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
	}

	public void visit(MethodTypeVoid mtv) {
		currentMethod = Tab.insert(Obj.Meth, mtv.getMethName(), Tab.noType);
		mtv.obj = currentMethod;
		Tab.openScope();
		report_info("Obradjuje se funkcija " + mtv.getMethName(), mtv);
	}

	public void visit(Assignment assignment) {
		if (!assignment.getExpr().struct.assignableTo(assignment.getDesignator().obj.getType()))
			report_error("Greska na liniji " + assignment.getLine() + " : "
					+ " nekompatibilni tipovi u dodeli vrednosti ", null);
	}

	public void visit(PrintStmt printStmt) {
		printCallCount++;
		if (printStmt.getExpr().struct != Tab.intType && printStmt.getExpr().struct != Tab.charType
				&& printStmt.getExpr().struct != boolType) {
			report_error("Promenljiva kod print mora biti INT, CHAR ili BOOL na liniji " + printStmt.getLine(), null);
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

	public void visit(ReturnNoExpr rne) {
		returnFound = true;
		if (currentMethod.getType() != Tab.noType) {
			report_error(
					"Greska na liniji " + rne.getLine() + " : "
							+ "return mora imati izraz koji je tipa povratne vrednosti fje " + currentMethod.getName(),
					null);
		}
	}

	public void visit(ProcCall procCall) {
		Obj func = procCall.getDesignator().obj;
		if (Obj.Meth == func.getKind()) {
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + procCall.getLine()+", "+ispisCvora(func), null);
			// RESULT = func.getType();
		} else {
			report_error("Greska na liniji " + procCall.getLine() + " : ime " + func.getName() + " nije funkcija!",
					null);
			// RESULT = Tab.noType;
		}

		int actPar = listaBrojaParametara.removeLast().get();

		if (func.getLevel() != actPar) {
			report_error("Greska na liniji " + procCall.getLine() + " : funkcija " + func.getName()
					+ " nije prosledjen dobar broj parametara!", null);
		}

		if (actPar != 0) {
			LinkedList<Struct> actParLst = listaListiTipova.removeLast();
			for (Obj obj : func.getLocalSymbols()) {
				if (obj.getFpPos() != 0 && obj.getFpPos() <= actParLst.size()) {
					if (obj.getType() != actParLst.get(obj.getFpPos() - 1)) {
						if (obj.getType().getKind() == Struct.Array
								&& actParLst.get(obj.getFpPos() - 1).getKind() == Struct.Array) {
							if (obj.getType().getElemType() == actParLst.get(obj.getFpPos() - 1).getElemType() || func.getName().equals("len")) {
								// dobar
							} else {
								report_error("Greska na liniji " + procCall.getLine()
										+ " pogresan tip parametra funkcije " + func.getName(), null);
							}
						} else {
							report_error("Greska na liniji " + procCall.getLine() + " pogresan tip parametra funkcije "
									+ func.getName(), null);
						}
					}
				}
			}
		}
	}

	public void visit(FuncCall funcCall) {
		Obj func = funcCall.getDesignator().obj;
		if (Obj.Meth == func.getKind()) {
			if (func.getType() == Tab.noType) {
				report_error("Greska na liniji " + funcCall.getLine() + " : funkcija " + func.getName()
						+ " nema povratnu vrednost!", funcCall);
			} else {
				report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine()+", "+ispisCvora(func), null);
				funcCall.struct = func.getType();
			}
		} else {
			report_error("Greska na liniji " + funcCall.getLine() + " : ime " + func.getName() + " nije funkcija!",
					null);
			funcCall.struct = Tab.noType;
		}

		int actPar = listaBrojaParametara.removeLast().get();

		if (func.getLevel() != actPar) {
			report_error("Greska na liniji " + funcCall.getLine() + " : funkcija " + func.getName()
					+ " nije prosledjen dobar broj parametara!", null);
		}

		if (actPar != 0) {
			LinkedList<Struct> actParLst = listaListiTipova.removeLast();
			for (Obj obj : func.getLocalSymbols()) {
				if (obj.getFpPos() != 0 && obj.getFpPos() <= actParLst.size()) {
					if (obj.getType() != actParLst.get(obj.getFpPos() - 1)) {
						if (obj.getType().getKind() == Struct.Array
								&& actParLst.get(obj.getFpPos() - 1).getKind() == Struct.Array) {
							if (obj.getType().getElemType() == actParLst.get(obj.getFpPos() - 1).getElemType() || func.getName().equals("len")) {
								// dobar
							} else {
								report_error("Greska na liniji " + funcCall.getLine()
										+ " pogresan tip parametra funkcije " + func.getName(), null);
							}
						} else {
							report_error("Greska na liniji " + funcCall.getLine() + " pogresan tip parametra funkcije "
									+ func.getName(), null);
						}
					}
				}
			}
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

	public void visit(MinusTerm mt) {
		if (mt.getTerm().struct == Tab.intType) {
			mt.struct = mt.getTerm().struct;
		} else {
			report_error("Greska na liniji " + mt.getLine() + " : Negacija sme samo ispred INT tipa", null);
			mt.struct = Tab.noType;
		}
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

	public void visit(FactorExpr fe) {
		fe.struct = fe.getExpr().struct;
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

	private int inFor = 0;

	public void visit(ForFor fd) {
		inFor++;
	}

	public void visit(MatchedBreak mb) {
		if (inFor == 0) {
			report_error("Greska na liniji " + mb.getParent().getLine() + " : break van fora! ", null);
		}
	}

	public void visit(MatchedContinue mc) {
		if (inFor == 0) {
			report_error("Greska na liniji " + mc.getParent().getLine() + " : continue van fora! ", null);
		}
	}

	public void visit(MatchedFor mf) {
		inFor--;
	}

	public void visit(MatchedRead mr) {
		if (mr.getDesignator().obj.getKind() != Obj.Var && mr.getDesignator().obj.getKind() != Obj.Elem) {
			report_error("Read mora imati promenljivu ili element niza: " + mr.getDesignator().getName() + " na liniji "
					+ mr.getLine(), null);
		}
		if (mr.getDesignator().obj.getType() != Tab.intType && mr.getDesignator().obj.getType() != Tab.charType
				&& mr.getDesignator().obj.getType() != boolType) {
			report_error("Promenljiva kod read mora biti INT, CHAR ili BOOL " + mr.getDesignator().getName()
					+ " na liniji " + mr.getLine(), null);
		}
	}

	public void visit(PrintStmtTwo pst) {
		printCallCount++;
		if (pst.getExpr().struct != Tab.intType && pst.getExpr().struct != Tab.charType
				&& pst.getExpr().struct != boolType) {
			report_error("Promenljiva kod print mora biti INT, CHAR ili BOOL na liniji " + pst.getLine(), null);
		}
	}

	/*
	 * public void visit(SquareDesignatorOption sdo) { sdo.struct = new
	 * Struct(Struct.Int); }
	 */

	public void visit(FactorNewArr fna) {
		if (fna.getExpr().struct != Tab.intType) {
			report_error("Promenljiva izmedju [ ] mora biti INT na liniji " + fna.getLine(), null);
		}
		fna.struct = new Struct(Struct.Array, fna.getType().struct);
	}

	public void visit(CndFct cf) {
		if (cf.getExpr().struct != boolType) {
			report_error("Samostalan uslov mora biti bool " + cf.getLine(), null);
		}
	}

	public void visit(CndFctNotBool cfnb) {
		if (!cfnb.getExpr().struct.compatibleWith(cfnb.getExpr1().struct))
			report_error("Nekompatibilni tipovi u iskazu na liniji" + cfnb.getLine(), null);
		if (cfnb.getExpr().struct.getKind() == Struct.Array) {// ili klasa
			// samo == ili !=
		}
	}

	public void visit(Designator designator) {
		Obj obj = Tab.find(designator.getName());
		if (obj == Tab.noObj) {
			report_error("Greska na liniji " + designator.getLine() + " : ime " + designator.getName()
					+ " nije deklarisano! ", null);
		}
		designator.obj = obj;
		if (obj.getKind() == Obj.Var) {
			if (obj.getLevel() == 0) {
				report_info(
						"Upotreba globalne promenljive " + designator.getName() + " na liniji " + designator.getLine()+", "+ispisCvora(designator.obj),
						null);
			} else {
				if (obj.getFpPos() == 0) {
					report_info("Upotreba lokalne promenljive " + designator.getName() + " na liniji "
							+ designator.getLine()+", "+ispisCvora(designator.obj), null);
				} else {
					report_info("Upotreba formalnog parametra " + designator.getName() + " na liniji "
							+ designator.getLine()+", "+ispisCvora(designator.obj), null);
				}
			}
		} else if (obj.getKind() == Obj.Con) {
			if (obj.getLevel() == 0) {
				report_info(
						"Upotreba globalne konstante " + designator.getName() + " na liniji " + designator.getLine()+", "+ispisCvora(designator.obj),
						null);
			} else {
				report_info("Upotreba lokalne konstante " + designator.getName() + " na liniji " + designator.getLine()+", "+ispisCvora(designator.obj),
						null);
			}
		}

		/*
		 * if(obj.getType().getKind() == Struct.Array) { report_info("NIIIIIIIIIIIIIZ",
		 * null); }
		 */

		if (desopt == 1) {
			if (obj.getType().getKind() == Struct.Enum) {
				if (obj.getType().getMembersTable().searchKey(namedot) != null) {
					report_info("Upotreba konstante " + namedot + " nabrajanja " + obj.getName() + " na liniji "
							+ designator.getLine()+", "+ispisCvora(designator.obj), null);
					designator.obj = obj.getType().getMembersTable().searchKey(namedot);
				} else {
					report_error("Upotreba " + namedot + " nije element nabrajanja " + obj.getName() + " na liniji "
							+ designator.getLine(), null);
				}
			} else {
				report_error("Ime " + obj.getName() + " nije tipa nabrajanja na liniji " + designator.getLine(), null);
			}
		}
		if (desopt == 2) {
			if (obj.getType().getKind() == Struct.Array) {
				designator.obj = new Obj(Obj.Elem, "", obj.getType().getElemType(), obj.getAdr(), obj.getLevel()); // IME
																													// ELEMENTA
																													// NIZA
																													// I
																													// DRUGA
																													// 2
																													// ARGUMENTA!!
				report_info("Upotreba elementa niza " + obj.getName() + " na liniji " + designator.getLine()+", "+ispisCvora(designator.obj), null);
			} else {
				report_error("Ime " + obj.getName() + " nije tip niz na liniji " + designator.getLine(), null);
			}
		}
		desopt = 0;
	}

	private int desopt = 0;
	private String namedot = "";

	public void visit(DotDesignatorOption ddo) {
		desopt = 1;
		namedot = ddo.getIdnam();
	}

	public void visit(SquareDesignatorOption sdo) {
		desopt = 2;
		if (sdo.getExpr().struct != Tab.intType) {
			report_error("Samo INT moze da indeksira niz na liniji " + sdo.getLine(), null);
		}
	}

	public void visit(NoDesignatorOptions ndo) {
		desopt = 0;
	}

	private LinkedList<AtomicInteger> listaBrojaParametara = new LinkedList<>();
	private LinkedList<LinkedList<Struct>> listaListiTipova = new LinkedList<>();

	public void visit(ActualParams ap) {

		listaBrojaParametara.getLast().incrementAndGet();

		ap.struct = ap.getExpr().struct;

		listaListiTipova.getLast().add(ap.struct);
	}

	public void visit(ActualParam ap) {
		ap.struct = ap.getExpr().struct;

		listaBrojaParametara.add(new AtomicInteger(1));

		LinkedList<Struct> lst = new LinkedList<>();
		lst.add(ap.struct);
		listaListiTipova.add(lst);

	}

	public void visit(NoActuals na) {
		listaBrojaParametara.add(new AtomicInteger(0));
	}

	public boolean passed() {
		return !errorDetected;
	}
	
	public String ispisCvora(Obj objToVisit) {
		StringBuilder output= new StringBuilder();
		switch (objToVisit.getKind()) {
			case Obj.Con:  output.append("Con "); break;
			case Obj.Var:  output.append("Var "); break;
			case Obj.Type: output.append("Type "); break;
			case Obj.Meth: output.append("Meth "); break;
			case Obj.Fld:  output.append("Fld "); break;
			case Obj.Prog: output.append("Prog "); break;
		}
		
		output.append(objToVisit.getName());
		output.append(": ");
		
		if ((Obj.Var == objToVisit.getKind()) && "this".equalsIgnoreCase(objToVisit.getName()))
			output.append("");
		else{
			switch (objToVisit.getType().getKind()) {
				case Struct.None:
					output.append("notype");
					break;
				case Struct.Int:
					output.append("int");
					break;
				case Struct.Char:
					output.append("char");
					break;
				case Struct.Array:
					output.append("Arr of ");
					
					switch (objToVisit.getType().getElemType().getKind()) {
					case Struct.None:
						output.append("notype");
						break;
					case Struct.Int:
						output.append("int");
						break;
					case Struct.Char:
						output.append("char");
						break;
					case Struct.Class:
						output.append("Class");
						break;
					}
					break;
				case Struct.Class:
					output.append("Class [");
					/*for (Obj obj : objToVisit.getType().getMembers()) {
						obj.accept(this);
					}*/
					output.append("]");
					break;
			}
		}
		
		output.append(", ");
		output.append(objToVisit.getAdr());
		output.append(", ");
		output.append(objToVisit.getLevel() + " ");
				
		/*if (objToVisit.getKind() == Obj.Prog || objToVisit.getKind() == Obj.Meth) {
			output.append("\n");
			nextIndentationLevel();
		}*/
		

		/*for (Obj o : objToVisit.getLocalSymbols()) {
			output.append(currentIndent.toString());
			o.accept(this);
			output.append("\n");
		}
		
		if (objToVisit.getKind() == Obj.Prog || objToVisit.getKind() == Obj.Meth) 
			previousIndentationLevel();*/

		//output.append("]");
		return output.toString();
	}

}