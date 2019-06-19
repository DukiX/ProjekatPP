// generated with ast extension for cup
// version 0.8
// 15/5/2019 18:19:4


package rs.ac.bg.etf.pp1.ast;

public class MatchedFor extends Matched {

    private For For;
    private ForDesignator ForDesignator;
    private BegForCond BegForCond;
    private ForCondition ForCondition;
    private Beginc Beginc;
    private ForDesignator ForDesignator1;
    private Endinc Endinc;
    private Begfor Begfor;
    private Matched Matched;
    private Endfor Endfor;

    public MatchedFor (For For, ForDesignator ForDesignator, BegForCond BegForCond, ForCondition ForCondition, Beginc Beginc, ForDesignator ForDesignator1, Endinc Endinc, Begfor Begfor, Matched Matched, Endfor Endfor) {
        this.For=For;
        if(For!=null) For.setParent(this);
        this.ForDesignator=ForDesignator;
        if(ForDesignator!=null) ForDesignator.setParent(this);
        this.BegForCond=BegForCond;
        if(BegForCond!=null) BegForCond.setParent(this);
        this.ForCondition=ForCondition;
        if(ForCondition!=null) ForCondition.setParent(this);
        this.Beginc=Beginc;
        if(Beginc!=null) Beginc.setParent(this);
        this.ForDesignator1=ForDesignator1;
        if(ForDesignator1!=null) ForDesignator1.setParent(this);
        this.Endinc=Endinc;
        if(Endinc!=null) Endinc.setParent(this);
        this.Begfor=Begfor;
        if(Begfor!=null) Begfor.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
        this.Endfor=Endfor;
        if(Endfor!=null) Endfor.setParent(this);
    }

    public For getFor() {
        return For;
    }

    public void setFor(For For) {
        this.For=For;
    }

    public ForDesignator getForDesignator() {
        return ForDesignator;
    }

    public void setForDesignator(ForDesignator ForDesignator) {
        this.ForDesignator=ForDesignator;
    }

    public BegForCond getBegForCond() {
        return BegForCond;
    }

    public void setBegForCond(BegForCond BegForCond) {
        this.BegForCond=BegForCond;
    }

    public ForCondition getForCondition() {
        return ForCondition;
    }

    public void setForCondition(ForCondition ForCondition) {
        this.ForCondition=ForCondition;
    }

    public Beginc getBeginc() {
        return Beginc;
    }

    public void setBeginc(Beginc Beginc) {
        this.Beginc=Beginc;
    }

    public ForDesignator getForDesignator1() {
        return ForDesignator1;
    }

    public void setForDesignator1(ForDesignator ForDesignator1) {
        this.ForDesignator1=ForDesignator1;
    }

    public Endinc getEndinc() {
        return Endinc;
    }

    public void setEndinc(Endinc Endinc) {
        this.Endinc=Endinc;
    }

    public Begfor getBegfor() {
        return Begfor;
    }

    public void setBegfor(Begfor Begfor) {
        this.Begfor=Begfor;
    }

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public Endfor getEndfor() {
        return Endfor;
    }

    public void setEndfor(Endfor Endfor) {
        this.Endfor=Endfor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(For!=null) For.accept(visitor);
        if(ForDesignator!=null) ForDesignator.accept(visitor);
        if(BegForCond!=null) BegForCond.accept(visitor);
        if(ForCondition!=null) ForCondition.accept(visitor);
        if(Beginc!=null) Beginc.accept(visitor);
        if(ForDesignator1!=null) ForDesignator1.accept(visitor);
        if(Endinc!=null) Endinc.accept(visitor);
        if(Begfor!=null) Begfor.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
        if(Endfor!=null) Endfor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(For!=null) For.traverseTopDown(visitor);
        if(ForDesignator!=null) ForDesignator.traverseTopDown(visitor);
        if(BegForCond!=null) BegForCond.traverseTopDown(visitor);
        if(ForCondition!=null) ForCondition.traverseTopDown(visitor);
        if(Beginc!=null) Beginc.traverseTopDown(visitor);
        if(ForDesignator1!=null) ForDesignator1.traverseTopDown(visitor);
        if(Endinc!=null) Endinc.traverseTopDown(visitor);
        if(Begfor!=null) Begfor.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
        if(Endfor!=null) Endfor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(For!=null) For.traverseBottomUp(visitor);
        if(ForDesignator!=null) ForDesignator.traverseBottomUp(visitor);
        if(BegForCond!=null) BegForCond.traverseBottomUp(visitor);
        if(ForCondition!=null) ForCondition.traverseBottomUp(visitor);
        if(Beginc!=null) Beginc.traverseBottomUp(visitor);
        if(ForDesignator1!=null) ForDesignator1.traverseBottomUp(visitor);
        if(Endinc!=null) Endinc.traverseBottomUp(visitor);
        if(Begfor!=null) Begfor.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        if(Endfor!=null) Endfor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedFor(\n");

        if(For!=null)
            buffer.append(For.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForDesignator!=null)
            buffer.append(ForDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BegForCond!=null)
            buffer.append(BegForCond.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForCondition!=null)
            buffer.append(ForCondition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Beginc!=null)
            buffer.append(Beginc.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForDesignator1!=null)
            buffer.append(ForDesignator1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Endinc!=null)
            buffer.append(Endinc.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Begfor!=null)
            buffer.append(Begfor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Endfor!=null)
            buffer.append(Endfor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedFor]");
        return buffer.toString();
    }
}
