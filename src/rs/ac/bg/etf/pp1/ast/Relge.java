// generated with ast extension for cup
// version 0.8
// 13/2/2019 10:51:45


package rs.ac.bg.etf.pp1.ast;

public class Relge extends Relop {

    public Relge () {
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
        buffer.append("Relge(\n");

        buffer.append(tab);
        buffer.append(") [Relge]");
        return buffer.toString();
    }
}
