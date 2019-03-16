// generated with ast extension for cup
// version 0.8
// 16/2/2019 15:26:3


package rs.ac.bg.etf.pp1.ast;

public class AndbegadrDerived1 extends Andbegadr {

    public AndbegadrDerived1 () {
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
        buffer.append("AndbegadrDerived1(\n");

        buffer.append(tab);
        buffer.append(") [AndbegadrDerived1]");
        return buffer.toString();
    }
}
