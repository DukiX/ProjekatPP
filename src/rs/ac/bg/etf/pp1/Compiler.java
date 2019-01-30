package rs.ac.bg.etf.pp1;

import java_cup.runtime.*;
import java.io.*;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;

public class Compiler {
	public static void main(String args[]) throws Exception {
		FileReader r = new FileReader(args[0]);
		
		Yylex skener = new Yylex(r);
		MJParser p = new MJParser(skener);
		Symbol s = p.parse();
		//System.out.println(s.value.getClass());
		Program prog = (Program)(s.value);
    	Tab.init();
		SemanticAnalyzer stv = new SemanticAnalyzer(); 
		prog.traverseBottomUp(stv);
		Tab.dump();
		//Ispis stabla:
		//System.out.println(prog.toString(""));
	}
}
