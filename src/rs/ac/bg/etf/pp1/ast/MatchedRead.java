// generated with ast extension for cup
// version 0.8
// 19/5/2019 16:5:7


package rs.ac.bg.etf.pp1.ast;

public class MatchedRead extends Matched {

    private Rd Rd;
    private Designator Designator;

    public MatchedRead (Rd Rd, Designator Designator) {
        this.Rd=Rd;
        if(Rd!=null) Rd.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public Rd getRd() {
        return Rd;
    }

    public void setRd(Rd Rd) {
        this.Rd=Rd;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Rd!=null) Rd.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Rd!=null) Rd.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Rd!=null) Rd.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedRead(\n");

        if(Rd!=null)
            buffer.append(Rd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedRead]");
        return buffer.toString();
    }
}
