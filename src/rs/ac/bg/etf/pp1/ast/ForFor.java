// generated with ast extension for cup
// version 0.8
// 3/1/2019 11:41:1


package rs.ac.bg.etf.pp1.ast;

public class ForFor extends For {

    public ForFor () {
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
        buffer.append("ForFor(\n");

        buffer.append(tab);
        buffer.append(") [ForFor]");
        return buffer.toString();
    }
}
