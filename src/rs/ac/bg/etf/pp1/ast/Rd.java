// generated with ast extension for cup
// version 0.8
// 19/5/2019 16:5:7


package rs.ac.bg.etf.pp1.ast;

public class Rd implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public Rd () {
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
        buffer.append("Rd(\n");

        buffer.append(tab);
        buffer.append(") [Rd]");
        return buffer.toString();
    }
}
