// generated with ast extension for cup
// version 0.8
// 19/2/2019 20:6:17


package rs.ac.bg.etf.pp1.ast;

public class ForConditionDerived1 extends ForCondition {

    public ForConditionDerived1 () {
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
        buffer.append("ForConditionDerived1(\n");

        buffer.append(tab);
        buffer.append(") [ForConditionDerived1]");
        return buffer.toString();
    }
}
