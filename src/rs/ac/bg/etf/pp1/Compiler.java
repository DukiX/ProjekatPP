package rs.ac.bg.etf.pp1;

import java_cup.runtime.*;
import java.io.*;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.*;

public class Compiler {
	public static void main(String args[]) throws Exception {
		FileReader r = new FileReader(args[0]);
		
		Yylex skener = new Yylex(r);
		MJParser p = new MJParser(skener);
		Symbol s = p.parse();
		//System.out.println(s.value.getClass());
		Program prog = (Program)(s.value);
		
		//Ispis stabla:
		//System.out.println(prog.toString(""));
		
    	Tab.init();
		SemanticAnalyzer stv = new SemanticAnalyzer(); 
		prog.traverseBottomUp(stv);
		tsdump();
		
		if (!p.errorDetected && stv.passed()) {
        	File objFile = new File(args[1]);
        	//log.info("Generating bytecode file: " + objFile.getAbsolutePath());
        	System.out.println("Generating bytecode file: " + objFile.getAbsolutePath());
        	if (objFile.exists())
        		objFile.delete();
        	
        	// Code generation...
        	CodeGenerator codeGenerator = new CodeGenerator();
        	prog.traverseBottomUp(codeGenerator);
        	Code.dataSize = stv.nVars;
        	Code.mainPc = codeGenerator.getMainPc();
        	Code.write(new FileOutputStream(objFile));
        	//log.info("Parsiranje uspesno zavrseno!");
        	System.out.println("Parsiranje uspesno zavrseno!");
        }
        else {
        	//log.error("Parsiranje NIJE uspesno zavrseno!");
        	System.out.println("Parsiranje NIJE uspesno zavrseno!");
        }
	}
	
	public static void tsdump() {
		Tab.dump();
	}
}
