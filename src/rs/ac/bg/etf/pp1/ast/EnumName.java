// generated with ast extension for cup
// version 0.8
// 11/5/2019 23:17:8


package rs.ac.bg.etf.pp1.ast;

public class EnumName implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String EnumNme;

    public EnumName (String EnumNme) {
        this.EnumNme=EnumNme;
    }

    public String getEnumNme() {
        return EnumNme;
    }

    public void setEnumNme(String EnumNme) {
        this.EnumNme=EnumNme;
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
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumName(\n");

        buffer.append(" "+tab+EnumNme);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumName]");
        return buffer.toString();
    }
}
