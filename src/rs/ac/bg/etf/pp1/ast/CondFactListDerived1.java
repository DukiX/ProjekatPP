// generated with ast extension for cup
// version 0.8
// 16/2/2019 13:20:35


package rs.ac.bg.etf.pp1.ast;

public class CondFactListDerived1 extends CondFactList {

    public CondFactListDerived1 () {
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
        buffer.append("CondFactListDerived1(\n");

        buffer.append(tab);
        buffer.append(") [CondFactListDerived1]");
        return buffer.toString();
    }
}
