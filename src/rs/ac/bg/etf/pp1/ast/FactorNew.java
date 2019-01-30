// generated with ast extension for cup
// version 0.8
// 30/0/2019 19:25:39


package rs.ac.bg.etf.pp1.ast;

public class FactorNew extends Factor {

    private Type Type;
    private FactorTypeExpr FactorTypeExpr;

    public FactorNew (Type Type, FactorTypeExpr FactorTypeExpr) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FactorTypeExpr=FactorTypeExpr;
        if(FactorTypeExpr!=null) FactorTypeExpr.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FactorTypeExpr getFactorTypeExpr() {
        return FactorTypeExpr;
    }

    public void setFactorTypeExpr(FactorTypeExpr FactorTypeExpr) {
        this.FactorTypeExpr=FactorTypeExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FactorTypeExpr!=null) FactorTypeExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FactorTypeExpr!=null) FactorTypeExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FactorTypeExpr!=null) FactorTypeExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNew(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorTypeExpr!=null)
            buffer.append(FactorTypeExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNew]");
        return buffer.toString();
    }
}
