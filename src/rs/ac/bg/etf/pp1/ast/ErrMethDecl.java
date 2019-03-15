// generated with ast extension for cup
// version 0.8
// 15/2/2019 18:3:34


package rs.ac.bg.etf.pp1.ast;

public class ErrMethDecl extends MethodDeclr {

    public ErrMethDecl () {
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
        buffer.append("ErrMethDecl(\n");

        buffer.append(tab);
        buffer.append(") [ErrMethDecl]");
        return buffer.toString();
    }
}
