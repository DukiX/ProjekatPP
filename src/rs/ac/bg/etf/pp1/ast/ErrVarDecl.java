// generated with ast extension for cup
// version 0.8
// 2/3/2019 18:26:33


package rs.ac.bg.etf.pp1.ast;

public class ErrVarDecl extends VarDeclList {

    public ErrVarDecl () {
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
        buffer.append("ErrVarDecl(\n");

        buffer.append(tab);
        buffer.append(") [ErrVarDecl]");
        return buffer.toString();
    }
}
