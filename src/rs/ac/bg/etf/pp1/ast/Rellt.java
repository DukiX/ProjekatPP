// generated with ast extension for cup
// version 0.8
// 16/2/2019 13:20:35


package rs.ac.bg.etf.pp1.ast;

public class Rellt extends Relop {

    public Rellt () {
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
        buffer.append("Rellt(\n");

        buffer.append(tab);
        buffer.append(") [Rellt]");
        return buffer.toString();
    }
}
