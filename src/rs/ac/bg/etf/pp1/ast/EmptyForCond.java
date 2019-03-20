// generated with ast extension for cup
// version 0.8
// 20/2/2019 15:28:48


package rs.ac.bg.etf.pp1.ast;

public class EmptyForCond extends ForCondition {

    public EmptyForCond () {
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
        buffer.append("EmptyForCond(\n");

        buffer.append(tab);
        buffer.append(") [EmptyForCond]");
        return buffer.toString();
    }
}