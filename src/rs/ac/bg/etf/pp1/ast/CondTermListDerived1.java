// generated with ast extension for cup
// version 0.8
// 29/0/2019 10:49:1


package rs.ac.bg.etf.pp1.ast;

public class CondTermListDerived1 extends CondTermList {

    public CondTermListDerived1 () {
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
        buffer.append("CondTermListDerived1(\n");

        buffer.append(tab);
        buffer.append(") [CondTermListDerived1]");
        return buffer.toString();
    }
}
