package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

public class CodeGenerator extends VisitorAdaptor {
	
	private int varCount;
	
	private int paramCnt;
	
	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
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
	public void visit(VarDecl VarDecl) {
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
	public void visit(Assignment Assignment) {
		Code.store(Assignment.getDesignator().obj);
	}
	
	@Override
	public void visit(Const Const) {
		Code.load(new Obj(Obj.Con, "$", Const.struct, Const.getN1(), 0));
	}
	
	@Override
	public void visit(Designator Designator) {
		SyntaxNode parent = Designator.getParent();
		if (Assignment.class != parent.getClass() && FuncCall.class != parent.getClass()) {
			Code.load(Designator.obj);
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
		
		if(procCall.getDesignator().obj.getType() != Tab.noType) {
			Code.put(Code.pop);
		}
	}
	
	@Override
	public void visit(PrintStmt PrintStmt) {
		Code.put(Code.const_5);
		Code.put(Code.print);
	}
	
	@Override
	public void visit(AddExpr AddExpr) {
		if(AddExpr.getAddop().getClass()==Plusop.class) {
			Code.put(Code.add);
		}else {
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
		if(mf.getMulop().getClass()==Timesop.class) {
			Code.put(Code.mul);
		}else if(mf.getMulop().getClass()==Divop.class) {
			Code.put(Code.div);
		}else {
			Code.put(Code.rem);
		}
	}
}
