// generated with ast extension for cup
// version 0.8
// 12/4/2019 21:14:38


package rs.ac.bg.etf.pp1.ast;

public class Timesop extends Mulop {

    public Timesop () {
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
        buffer.append("Timesop(\n");

        buffer.append(tab);
        buffer.append(") [Timesop]");
        return buffer.toString();
    }
}
