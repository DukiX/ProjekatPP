// generated with ast extension for cup
// version 0.8
// 15/5/2019 18:19:4


package rs.ac.bg.etf.pp1.ast;

public class Relne extends Relop {

    public Relne () {
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
        buffer.append("Relne(\n");

        buffer.append(tab);
        buffer.append(") [Relne]");
        return buffer.toString();
    }
}
