// generated with ast extension for cup
// version 0.8
// 15/5/2019 18:19:4


package rs.ac.bg.etf.pp1.ast;

public class CharConst extends Factor {

    private char c;

    public CharConst (char c) {
        this.c=c;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c=c;
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
        buffer.append("CharConst(\n");

        buffer.append(" "+tab+c);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharConst]");
        return buffer.toString();
    }
}
