// generated with ast extension for cup
// version 0.8
// 21/2/2019 19:19:5


package rs.ac.bg.etf.pp1.ast;

public class Relgt extends Relop {

    public Relgt () {
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
        buffer.append("Relgt(\n");

        buffer.append(tab);
        buffer.append(") [Relgt]");
        return buffer.toString();
    }
}
