// generated with ast extension for cup
// version 0.8
// 31/0/2019 10:19:38


package rs.ac.bg.etf.pp1.ast;

public class NoFactorTypeExpr extends FactorTypeExpr {

    public NoFactorTypeExpr () {
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
        buffer.append("NoFactorTypeExpr(\n");

        buffer.append(tab);
        buffer.append(") [NoFactorTypeExpr]");
        return buffer.toString();
    }
}
