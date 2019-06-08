// generated with ast extension for cup
// version 0.8
// 8/5/2019 18:17:42


package rs.ac.bg.etf.pp1.ast;

public class FactorNewArr extends Factor {

    private Type Type;
    private DuzinaNiza DuzinaNiza;
    private NewInitList NewInitList;

    public FactorNewArr (Type Type, DuzinaNiza DuzinaNiza, NewInitList NewInitList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.DuzinaNiza=DuzinaNiza;
        if(DuzinaNiza!=null) DuzinaNiza.setParent(this);
        this.NewInitList=NewInitList;
        if(NewInitList!=null) NewInitList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public DuzinaNiza getDuzinaNiza() {
        return DuzinaNiza;
    }

    public void setDuzinaNiza(DuzinaNiza DuzinaNiza) {
        this.DuzinaNiza=DuzinaNiza;
    }

    public NewInitList getNewInitList() {
        return NewInitList;
    }

    public void setNewInitList(NewInitList NewInitList) {
        this.NewInitList=NewInitList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(DuzinaNiza!=null) DuzinaNiza.accept(visitor);
        if(NewInitList!=null) NewInitList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(DuzinaNiza!=null) DuzinaNiza.traverseTopDown(visitor);
        if(NewInitList!=null) NewInitList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(DuzinaNiza!=null) DuzinaNiza.traverseBottomUp(visitor);
        if(NewInitList!=null) NewInitList.traverseBottomUp(visitor);
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

        if(DuzinaNiza!=null)
            buffer.append(DuzinaNiza.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NewInitList!=null)
            buffer.append(NewInitList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNewArr]");
        return buffer.toString();
    }
}
