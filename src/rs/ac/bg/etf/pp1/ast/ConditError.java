// generated with ast extension for cup
// version 0.8
// 19/2/2019 20:6:17


package rs.ac.bg.etf.pp1.ast;

public class ConditError extends Condition {

    public ConditError () {
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
        buffer.append("ConditError(\n");

        buffer.append(tab);
        buffer.append(") [ConditError]");
        return buffer.toString();
    }
}
