// generated with ast extension for cup
// version 0.8
// 12/4/2019 21:14:38


package rs.ac.bg.etf.pp1.ast;

public class FactorBoolDef extends ConstDef {

    private BoolConstDef BoolConstDef;

    public FactorBoolDef (BoolConstDef BoolConstDef) {
        this.BoolConstDef=BoolConstDef;
        if(BoolConstDef!=null) BoolConstDef.setParent(this);
    }

    public BoolConstDef getBoolConstDef() {
        return BoolConstDef;
    }

    public void setBoolConstDef(BoolConstDef BoolConstDef) {
        this.BoolConstDef=BoolConstDef;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BoolConstDef!=null) BoolConstDef.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BoolConstDef!=null) BoolConstDef.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BoolConstDef!=null) BoolConstDef.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorBoolDef(\n");

        if(BoolConstDef!=null)
            buffer.append(BoolConstDef.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorBoolDef]");
        return buffer.toString();
    }
}
