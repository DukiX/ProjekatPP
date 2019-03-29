// generated with ast extension for cup
// version 0.8
// 29/2/2019 12:34:5


package rs.ac.bg.etf.pp1.ast;

public class MatchedIf extends Matched {

    private Ifif Ifif;
    private Condition Condition;
    private Begif Begif;
    private Matched Matched;
    private Begelse Begelse;
    private Matched Matched1;
    private Endelse Endelse;

    public MatchedIf (Ifif Ifif, Condition Condition, Begif Begif, Matched Matched, Begelse Begelse, Matched Matched1, Endelse Endelse) {
        this.Ifif=Ifif;
        if(Ifif!=null) Ifif.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.Begif=Begif;
        if(Begif!=null) Begif.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
        this.Begelse=Begelse;
        if(Begelse!=null) Begelse.setParent(this);
        this.Matched1=Matched1;
        if(Matched1!=null) Matched1.setParent(this);
        this.Endelse=Endelse;
        if(Endelse!=null) Endelse.setParent(this);
    }

    public Ifif getIfif() {
        return Ifif;
    }

    public void setIfif(Ifif Ifif) {
        this.Ifif=Ifif;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public Begif getBegif() {
        return Begif;
    }

    public void setBegif(Begif Begif) {
        this.Begif=Begif;
    }

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public Begelse getBegelse() {
        return Begelse;
    }

    public void setBegelse(Begelse Begelse) {
        this.Begelse=Begelse;
    }

    public Matched getMatched1() {
        return Matched1;
    }

    public void setMatched1(Matched Matched1) {
        this.Matched1=Matched1;
    }

    public Endelse getEndelse() {
        return Endelse;
    }

    public void setEndelse(Endelse Endelse) {
        this.Endelse=Endelse;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Ifif!=null) Ifif.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(Begif!=null) Begif.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
        if(Begelse!=null) Begelse.accept(visitor);
        if(Matched1!=null) Matched1.accept(visitor);
        if(Endelse!=null) Endelse.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Ifif!=null) Ifif.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(Begif!=null) Begif.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
        if(Begelse!=null) Begelse.traverseTopDown(visitor);
        if(Matched1!=null) Matched1.traverseTopDown(visitor);
        if(Endelse!=null) Endelse.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Ifif!=null) Ifif.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(Begif!=null) Begif.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        if(Begelse!=null) Begelse.traverseBottomUp(visitor);
        if(Matched1!=null) Matched1.traverseBottomUp(visitor);
        if(Endelse!=null) Endelse.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedIf(\n");

        if(Ifif!=null)
            buffer.append(Ifif.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Begif!=null)
            buffer.append(Begif.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Begelse!=null)
            buffer.append(Begelse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Matched1!=null)
            buffer.append(Matched1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Endelse!=null)
            buffer.append(Endelse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedIf]");
        return buffer.toString();
    }
}
