package rs.ac.bg.etf.pp1;

import java_cup.runtime.*;
import java.io.*;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class Compiler {
	/*public static void main(String args[]) throws Exception {
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
	}*/
	
	public static void tsdump(Logger log) {
		log.info("=====================SYMBOL TABLE DUMP=========================");
		DumpSymbolTableVisitor stv = new DumpSymbolTableVisitor();
		for (Scope s = Tab.currentScope; s != null; s = s.getOuter()) {
			s.accept(stv);
		}
		log.info("\n"+stv.getOutput());
	}

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception {
		Logger log = Logger.getLogger(Compiler.class);
		if (args.length < 2) {
			log.error("Not enough arguments supplied! Usage: MJParser <source-file> <obj-file> ");
			return;
		}
		
		File sourceCode = new File(args[0]);
		if (!sourceCode.exists()) {
			log.error("Source file [" + sourceCode.getAbsolutePath() + "] not found!");
			return;
		}
			
		log.info("Compiling source file: " + sourceCode.getAbsolutePath());
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceCode))) {
			Yylex lexer = new Yylex(br);
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  //pocetak parsiranja
	        Program prog = (Program)(s.value);
	        
	        //Ispis stabla:
			//System.out.println(prog.toString(""));
			log.info(prog.toString(""));
	        
			Tab.init(); // Universe scope
			SemanticAnalyzer semanticCheck = new SemanticAnalyzer();
			prog.traverseBottomUp(semanticCheck);
			
	        log.info("Print calls = " + semanticCheck.printCallCount);
	        log.info("Globalnih promenljivih = " + semanticCheck.brGrobProm);
	        log.info("Globalnih konstanti = " + semanticCheck.brGlobConst);
	        log.info("Globalnih nizova = " + semanticCheck.brGlobNiz);
	        log.info("Broj metoda = " + semanticCheck.brMet);
	        log.info("Broj enuma = " + semanticCheck.brEnuma);
	        
	        tsdump(log);
	        
	        if (!p.errorDetected && semanticCheck.passed()) {
	        	File objFile = new File(args[1]);
	        	log.info("Generating bytecode file: " + objFile.getAbsolutePath());
	        	if (objFile.exists())
	        		objFile.delete();
	        	
	        	// Code generation...
	        	CodeGenerator codeGenerator = new CodeGenerator();
	        	prog.traverseBottomUp(codeGenerator);
	        	Code.dataSize = semanticCheck.nVars;
	        	Code.mainPc = codeGenerator.getMainPc();
	        	Code.write(new FileOutputStream(objFile));
	        	log.info("Parsiranje uspesno zavrseno!");
	        }
	        else {
	        	log.error("Parsiranje NIJE uspesno zavrseno!");
	        }
		}
	}
}
