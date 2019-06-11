// generated with ast extension for cup
// version 0.8
// 11/5/2019 23:17:8


package rs.ac.bg.etf.pp1.ast;

public class FormalParamDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String formalName;
    private ArrayForPar ArrayForPar;

    public FormalParamDecl (Type Type, String formalName, ArrayForPar ArrayForPar) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.formalName=formalName;
        this.ArrayForPar=ArrayForPar;
        if(ArrayForPar!=null) ArrayForPar.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getFormalName() {
        return formalName;
    }

    public void setFormalName(String formalName) {
        this.formalName=formalName;
    }

    public ArrayForPar getArrayForPar() {
        return ArrayForPar;
    }

    public void setArrayForPar(ArrayForPar ArrayForPar) {
        this.ArrayForPar=ArrayForPar;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ArrayForPar!=null) ArrayForPar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ArrayForPar!=null) ArrayForPar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ArrayForPar!=null) ArrayForPar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParamDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+formalName);
        buffer.append("\n");

        if(ArrayForPar!=null)
            buffer.append(ArrayForPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParamDecl]");
        return buffer.toString();
    }
}
