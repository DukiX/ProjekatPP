// generated with ast extension for cup
// version 0.8
// 16/2/2019 15:27:6


package rs.ac.bg.etf.pp1.ast;

public class ForDesignatorDerived1 extends ForDesignator {

    public ForDesignatorDerived1 () {
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
        buffer.append("ForDesignatorDerived1(\n");

        buffer.append(tab);
        buffer.append(") [ForDesignatorDerived1]");
        return buffer.toString();
    }
}
