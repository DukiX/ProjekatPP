// generated with ast extension for cup
// version 0.8
// 30/2/2019 12:53:57


package rs.ac.bg.etf.pp1.ast;

public class CharConstDef extends ConstDef {

    private char C1;

    public CharConstDef (char C1) {
        this.C1=C1;
    }

    public char getC1() {
        return C1;
    }

    public void setC1(char C1) {
        this.C1=C1;
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
        buffer.append("CharConstDef(\n");

        buffer.append(" "+tab+C1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharConstDef]");
        return buffer.toString();
    }
}
