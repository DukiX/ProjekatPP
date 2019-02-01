// generated with ast extension for cup
// version 0.8
// 1/1/2019 18:3:38


package rs.ac.bg.etf.pp1.ast;

public class MatchedFor extends Matched {

    private For For;
    private ForDesignator ForDesignator;
    private ForCondition ForCondition;
    private ForDesignator ForDesignator1;
    private Matched Matched;

    public MatchedFor (For For, ForDesignator ForDesignator, ForCondition ForCondition, ForDesignator ForDesignator1, Matched Matched) {
        this.For=For;
        if(For!=null) For.setParent(this);
        this.ForDesignator=ForDesignator;
        if(ForDesignator!=null) ForDesignator.setParent(this);
        this.ForCondition=ForCondition;
        if(ForCondition!=null) ForCondition.setParent(this);
        this.ForDesignator1=ForDesignator1;
        if(ForDesignator1!=null) ForDesignator1.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
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

    public ForCondition getForCondition() {
        return ForCondition;
    }

    public void setForCondition(ForCondition ForCondition) {
        this.ForCondition=ForCondition;
    }

    public ForDesignator getForDesignator1() {
        return ForDesignator1;
    }

    public void setForDesignator1(ForDesignator ForDesignator1) {
        this.ForDesignator1=ForDesignator1;
    }

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(For!=null) For.accept(visitor);
        if(ForDesignator!=null) ForDesignator.accept(visitor);
        if(ForCondition!=null) ForCondition.accept(visitor);
        if(ForDesignator1!=null) ForDesignator1.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(For!=null) For.traverseTopDown(visitor);
        if(ForDesignator!=null) ForDesignator.traverseTopDown(visitor);
        if(ForCondition!=null) ForCondition.traverseTopDown(visitor);
        if(ForDesignator1!=null) ForDesignator1.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(For!=null) For.traverseBottomUp(visitor);
        if(ForDesignator!=null) ForDesignator.traverseBottomUp(visitor);
        if(ForCondition!=null) ForCondition.traverseBottomUp(visitor);
        if(ForDesignator1!=null) ForDesignator1.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
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

        if(ForCondition!=null)
            buffer.append(ForCondition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForDesignator1!=null)
            buffer.append(ForDesignator1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedFor]");
        return buffer.toString();
    }
}
