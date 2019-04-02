package rs.ac.bg.etf.pp1;

import java.util.LinkedList;

import jdk.internal.org.objectweb.asm.tree.MethodNode;
import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	private int varCount;

	private int paramCnt;

	private int mainPc;

	public int getMainPc() {
		return mainPc;
	}

	public CodeGenerator() {

		// LEN metoda
		Tab.lenObj.setAdr(Code.pc);

		Code.put(Code.enter);
		Code.put(0);
		Code.put(0);

		Code.put(Code.arraylength);

		Code.put(Code.exit);
		Code.put(Code.return_);

		// CHR metoda
		Tab.chrObj.setAdr(Code.pc);

		Code.put(Code.enter);
		Code.put(0);
		Code.put(0);

		// ?

		Code.put(Code.exit);
		Code.put(Code.return_);

		// ORD metoda
		Tab.ordObj.setAdr(Code.pc);

		Code.put(Code.enter);
		Code.put(0);
		Code.put(0);

		// ?

		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	@Override
	public void visit(MethodTypeName MethodTypeName) {
		if ("main".equalsIgnoreCase(MethodTypeName.getMethName())) {
			mainPc = Code.pc;
		}
		MethodTypeName.obj.setAdr(Code.pc);

		// Collect arguments and local variables.
		SyntaxNode methodNode = MethodTypeName.getParent();
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);

		// Generate the entry.
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(varCnt.getCount() + fpCnt.getCount());

	}

	@Override
	public void visit(MethodTypeVoid MethodTypeName) {
		if ("main".equalsIgnoreCase(MethodTypeName.getMethName())) {
			mainPc = Code.pc;
		}
		MethodTypeName.obj.setAdr(Code.pc);

		// Collect arguments and local variables.
		SyntaxNode methodNode = MethodTypeName.getParent();
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);

		// Generate the entry.
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(varCnt.getCount() + fpCnt.getCount());
	}

	@Override
	public void visit(VarDecl VarDecl) {
		varCount++;
	}

	@Override
	public void visit(VarListY v) {
		varCount++;
	}

	@Override
	public void visit(FormalParamDecl FormalParam) {
		paramCnt++;
	}

	@Override
	public void visit(MethodDecl MethodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	@Override
	public void visit(ReturnExpr ReturnExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	@Override
	public void visit(ReturnNoExpr ReturnNoExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	@Override
	public void visit(Assignment assignment) {
		if (assignment.getDesignator().obj.getKind() == Obj.Elem) {

			if (assignment.getDesignator().obj.getLevel() == 0) { // global variable
				Code.put(Code.getstatic);
				Code.put2(assignment.getDesignator().obj.getAdr());
			} else {
				// local variable
				if (0 <= assignment.getDesignator().obj.getAdr() && assignment.getDesignator().obj.getAdr() <= 3)
					Code.put(Code.load_n + assignment.getDesignator().obj.getAdr());
				else {
					Code.put(Code.load);
					Code.put(assignment.getDesignator().obj.getAdr());
				}
			}
			Code.put(Code.dup_x2);
			Code.put(Code.pop);
		}

		Code.store(assignment.getDesignator().obj);
	}

	@Override
	public void visit(Const Const) {
		Code.load(new Obj(Obj.Con, "$", Const.struct, Const.getN1(), 0));
	}

	public void visit(CharConst cc) {
		Code.load(new Obj(Obj.Con, "$", cc.struct, cc.getC(), 0));
	}

	public void visit(BoolTrue bt) {
		Code.load(new Obj(Obj.Con, "$", bt.struct, 1, 0));
	}

	public void visit(BoolFalse bf) {
		Code.load(new Obj(Obj.Con, "$", bf.struct, 0, 0));
	}

	@Override
	public void visit(Designator designator) {
		SyntaxNode parent = designator.getParent();
		if (Assignment.class != parent.getClass() && FuncCall.class != parent.getClass()) {
			if (designator.obj.getKind() == Obj.Elem) {
				// Code.loadConst(designator.obj.getAdr());
				/*
				 * Code.put(Code.getstatic); Code.put2(designator.obj.getAdr());
				 */

				if (designator.obj.getLevel() == 0) { // global variable
					Code.put(Code.getstatic);
					Code.put2(designator.obj.getAdr());
				} else {
					// local variable
					if (0 <= designator.obj.getAdr() && designator.obj.getAdr() <= 3)
						Code.put(Code.load_n + designator.obj.getAdr());
					else {
						Code.put(Code.load);
						Code.put(designator.obj.getAdr());
					}
				}
				Code.put(Code.dup_x1);
				Code.put(Code.pop);
				/*
				 * Code.put2(designator.obj.getAdr()); Code.put(Code.dup_x1);
				 * Code.put(Code.pop);
				 */
			}
			if (!uReadu) {
				Code.load(designator.obj);
			}
		}
	}

	@Override
	public void visit(FuncCall FuncCall) {
		Obj functionObj = FuncCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
	}

	@Override
	public void visit(ProcCall procCall) {
		Obj functionObj = procCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);

		if (procCall.getDesignator().obj.getType() != Tab.noType) {
			Code.put(Code.pop);
		}
	}

	@Override
	public void visit(PrintStmt printStmt) {
		if (printStmt.getExpr().struct == Tab.charType) {
			Code.put(Code.const_5);
			Code.put(Code.bprint);
		} else if (printStmt.getExpr().struct == Tab.intType) {
			Code.put(Code.const_5);
			Code.put(Code.print);
		} else {// bool
			Code.put(Code.const_5);
			Code.put(Code.print);
		}
	}

	public void visit(PrintStmtTwo pst) {
		if (pst.getExpr().struct == Tab.charType) {
			Code.loadConst(pst.getNum());
			Code.put(Code.bprint);
		} else if (pst.getExpr().struct == Tab.intType) {
			Code.loadConst(pst.getNum());
			Code.put(Code.print);
		} else {// bool
			Code.loadConst(pst.getNum());
			Code.put(Code.print);
		}
	}

	@Override
	public void visit(AddExpr AddExpr) {
		if (AddExpr.getAddop().getClass() == Plusop.class) {
			Code.put(Code.add);
		} else {
			Code.put(Code.sub);
		}
	}

	public void visit(Increment inc) {
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.store(inc.getDesignator().obj);
	}

	public void visit(Decrement dec) {
		Code.put(Code.const_1);
		Code.put(Code.sub);
		Code.store(dec.getDesignator().obj);
	}

	public void visit(MinusTerm mt) {
		Code.put(Code.neg);
	}

	public void visit(MulopFactor mf) {
		if (mf.getMulop().getClass() == Timesop.class) {
			Code.put(Code.mul);
		} else if (mf.getMulop().getClass() == Divop.class) {
			Code.put(Code.div);
		} else {
			Code.put(Code.rem);
		}
	}

	private boolean uReadu = false;

	public void visit(Rd rd) {
		uReadu = true;
	}

	public void visit(MatchedRead mr) {
		if (mr.getDesignator().obj.getType() == Tab.charType) {
			Code.put(Code.bread);
			Code.store(mr.getDesignator().obj);
		} else {
			Code.put(Code.read);
			Code.store(mr.getDesignator().obj);
		}

		uReadu = false;
	}

	public void visit(FactorNewArr fna) {
		Code.put(Code.newarray);
		if (fna.getType().struct == Tab.charType) {
			Code.put(0);
		} else {
			Code.put(1);
		}
	}

	// int adresa1;
	int adresa2;

	private LinkedList<LinkedList<Integer>> listaListiAdresaElse = new LinkedList<>();

	private LinkedList<LinkedList<Integer>> listaListiAdresaPocIf = new LinkedList<>();

	public void visit(Ifif ifif) {
		listaListiAdresaElse.add(new LinkedList<>());

		listaListiAdresaPocIf.add(new LinkedList<>());
	}

	public void visit(CndFct cf) {
		Code.put(Code.const_1);
		Code.putFalseJump(Code.eq, 0);
		listaListiAdresaElse.peekLast().add(new Integer(Code.pc - 2));
	}

	public void visit(CndFctNotBool cnb) {
		if (cnb.getRelop().getClass() == Releq.class) {
			// Code.put(Code.jcc+Code.eq);
			Code.putFalseJump(Code.eq, 0);
		} else if (cnb.getRelop().getClass() == Relne.class) {
			// Code.put(Code.jcc+Code.ne);
			Code.putFalseJump(Code.ne, 0);
		} else if (cnb.getRelop().getClass() == Relgt.class) {
			// Code.put(Code.jcc+Code.gt);
			Code.putFalseJump(Code.gt, 0);
		} else if (cnb.getRelop().getClass() == Rellt.class) {
			// Code.put(Code.jcc+Code.lt);
			Code.putFalseJump(Code.lt, 0);
		} else if (cnb.getRelop().getClass() == Relge.class) {
			// Code.put(Code.jcc+Code.ge);
			Code.putFalseJump(Code.ge, 0);
		} else if (cnb.getRelop().getClass() == Relle.class) {
			// Code.put(Code.jcc+Code.le);
			Code.putFalseJump(Code.le, 0);
		}
		// adresa1 = Code.pc - 2;
		listaListiAdresaElse.peekLast().add(new Integer(Code.pc - 2));
	}

	public void visit(Endif e) {
		// Code.fixup(adresa1);
		LinkedList<Integer> lst = listaListiAdresaElse.removeLast();
		for (Integer i : lst) {
			Code.fixup(i);
		}
	}

	public void visit(Begif b) {
		LinkedList<Integer> lst = listaListiAdresaPocIf.removeLast();
		for (Integer i : lst) {
			Code.fixup(i);
		}
	}

	public void visit(Begelse e) {
		Code.putJump(0);
		// Code.fixup(adresa1);

		LinkedList<Integer> lst = listaListiAdresaElse.removeLast();
		for (Integer i : lst) {
			Code.fixup(i);
		}

		adresa2 = Code.pc - 2;
	}

	public void visit(Andbegadr e) {
		// Code.fixup(adresa1);
		LinkedList<Integer> lst = listaListiAdresaElse.peekLast();
		if (lst != null) {
			for (Integer i : lst) {
				Code.fixup(i);
			}
			lst.clear();
		}
	}

	public void visit(Endelse e) {
		Code.fixup(adresa2);
	}

	public void visit(CondT t) {
		Code.putJump(0);
		listaListiAdresaPocIf.peekLast().add(new Integer(Code.pc - 2));
	}

	private LinkedList<Integer> listaForPocetnihAdr = new LinkedList<>();

	public void visit(ForFor f) {
		listaListiAdresaElse.add(new LinkedList<>());

		listaListiAdresaPocIf.add(new LinkedList<>());

		listaListiBreak.add(new LinkedList<>());
	}

	public void visit(Begfor b) {
		LinkedList<Integer> lst = listaListiAdresaPocIf.removeLast();
		for (Integer i : lst) {
			Code.fixup(i);
		}
	}

	public void visit(Beginc b) {
		listaForPocetnihAdr.add(Code.pc);
	}

	private LinkedList<Integer> listaAdresaZaInc = new LinkedList<>();

	public void visit(BegForCond e) {
		listaAdresaZaInc.add(Code.pc);
	}

	public void visit(Endinc e) {
		Code.putJump(listaAdresaZaInc.removeLast());
	}

	public void visit(Endfor e) {
		Code.putJump(listaForPocetnihAdr.removeLast());
		LinkedList<Integer> lst = listaListiAdresaElse.removeLast();
		for (Integer i : lst) {
			Code.fixup(i);
		}

		lst = listaListiBreak.removeLast();
		for (Integer i : lst) {
			Code.fixup(i);
		}
	}

	public void visit(MatchedContinue mb) {
		Code.putJump(listaForPocetnihAdr.peekLast());
	}

	private LinkedList<LinkedList<Integer>> listaListiBreak = new LinkedList<>();

	public void visit(MatchedBreak mb) {
		Code.putJump(0);
		listaListiBreak.peekLast().add(Code.pc - 2);
	}

	public void visit(EmptyForCond efc) {
		Code.putJump(0);
		listaListiAdresaPocIf.peekLast().add(new Integer(Code.pc - 2));
	}
}
