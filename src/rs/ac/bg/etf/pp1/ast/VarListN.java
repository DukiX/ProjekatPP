// generated with ast extension for cup
// version 0.8
// 15/2/2019 11:43:38


package rs.ac.bg.etf.pp1.ast;

public class VarListN extends VarList {

    public VarListN () {
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
        buffer.append("VarListN(\n");

        buffer.append(tab);
        buffer.append(") [VarListN]");
        return buffer.toString();
    }
}