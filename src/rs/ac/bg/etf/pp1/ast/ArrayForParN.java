// generated with ast extension for cup
// version 0.8
// 30/2/2019 12:53:57


package rs.ac.bg.etf.pp1.ast;

public class ArrayForParN extends ArrayForPar {

    public ArrayForParN () {
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
        buffer.append("ArrayForParN(\n");

        buffer.append(tab);
        buffer.append(") [ArrayForParN]");
        return buffer.toString();
    }
}
