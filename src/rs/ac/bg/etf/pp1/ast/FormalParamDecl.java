// generated with ast extension for cup
// version 0.8
// 30/0/2019 19:25:39


package rs.ac.bg.etf.pp1.ast;

public class FormalParamDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String formalName;

    public FormalParamDecl (Type Type, String formalName) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.formalName=formalName;
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
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
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

        buffer.append(tab);
        buffer.append(") [FormalParamDecl]");
        return buffer.toString();
    }
}
