// generated with ast extension for cup
// version 0.8
// 2/3/2019 18:26:33


package rs.ac.bg.etf.pp1.ast;

public class BoolFalseDef extends BoolConstDef {

    public BoolFalseDef () {
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
        buffer.append("BoolFalseDef(\n");

        buffer.append(tab);
        buffer.append(") [BoolFalseDef]");
        return buffer.toString();
    }
}
