// generated with ast extension for cup
// version 0.8
// 19/5/2019 16:5:7


package rs.ac.bg.etf.pp1.ast;

public class FactorNewArr extends Factor {

    private Type Type;
    private LsquareNt LsquareNt;
    private DuzinaNiza DuzinaNiza;

    public FactorNewArr (Type Type, LsquareNt LsquareNt, DuzinaNiza DuzinaNiza) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.LsquareNt=LsquareNt;
        if(LsquareNt!=null) LsquareNt.setParent(this);
        this.DuzinaNiza=DuzinaNiza;
        if(DuzinaNiza!=null) DuzinaNiza.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public LsquareNt getLsquareNt() {
        return LsquareNt;
    }

    public void setLsquareNt(LsquareNt LsquareNt) {
        this.LsquareNt=LsquareNt;
    }

    public DuzinaNiza getDuzinaNiza() {
        return DuzinaNiza;
    }

    public void setDuzinaNiza(DuzinaNiza DuzinaNiza) {
        this.DuzinaNiza=DuzinaNiza;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(LsquareNt!=null) LsquareNt.accept(visitor);
        if(DuzinaNiza!=null) DuzinaNiza.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(LsquareNt!=null) LsquareNt.traverseTopDown(visitor);
        if(DuzinaNiza!=null) DuzinaNiza.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(LsquareNt!=null) LsquareNt.traverseBottomUp(visitor);
        if(DuzinaNiza!=null) DuzinaNiza.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNewArr(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LsquareNt!=null)
            buffer.append(LsquareNt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DuzinaNiza!=null)
            buffer.append(DuzinaNiza.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNewArr]");
        return buffer.toString();
    }
}
