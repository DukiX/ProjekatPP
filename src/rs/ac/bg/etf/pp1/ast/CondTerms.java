// generated with ast extension for cup
// version 0.8
// 16/2/2019 15:27:6


package rs.ac.bg.etf.pp1.ast;

public class CondTerms extends CondTermList {

    private CondTermList CondTermList;
    private Andbegadr Andbegadr;
    private CondTerm CondTerm;

    public CondTerms (CondTermList CondTermList, Andbegadr Andbegadr, CondTerm CondTerm) {
        this.CondTermList=CondTermList;
        if(CondTermList!=null) CondTermList.setParent(this);
        this.Andbegadr=Andbegadr;
        if(Andbegadr!=null) Andbegadr.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public CondTermList getCondTermList() {
        return CondTermList;
    }

    public void setCondTermList(CondTermList CondTermList) {
        this.CondTermList=CondTermList;
    }

    public Andbegadr getAndbegadr() {
        return Andbegadr;
    }

    public void setAndbegadr(Andbegadr Andbegadr) {
        this.Andbegadr=Andbegadr;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTermList!=null) CondTermList.accept(visitor);
        if(Andbegadr!=null) Andbegadr.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTermList!=null) CondTermList.traverseTopDown(visitor);
        if(Andbegadr!=null) Andbegadr.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTermList!=null) CondTermList.traverseBottomUp(visitor);
        if(Andbegadr!=null) Andbegadr.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTerms(\n");

        if(CondTermList!=null)
            buffer.append(CondTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Andbegadr!=null)
            buffer.append(Andbegadr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTerms]");
        return buffer.toString();
    }
}
