// generated with ast extension for cup
// version 0.8
// 19/2/2019 20:6:17


package rs.ac.bg.etf.pp1.ast;

public class UnmatchedIf extends Unmatched {

    private Ifif Ifif;
    private Condition Condition;
    private Begif Begif;
    private Statement Statement;
    private Endif Endif;

    public UnmatchedIf (Ifif Ifif, Condition Condition, Begif Begif, Statement Statement, Endif Endif) {
        this.Ifif=Ifif;
        if(Ifif!=null) Ifif.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.Begif=Begif;
        if(Begif!=null) Begif.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.Endif=Endif;
        if(Endif!=null) Endif.setParent(this);
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

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public Endif getEndif() {
        return Endif;
    }

    public void setEndif(Endif Endif) {
        this.Endif=Endif;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Ifif!=null) Ifif.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(Begif!=null) Begif.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(Endif!=null) Endif.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Ifif!=null) Ifif.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(Begif!=null) Begif.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(Endif!=null) Endif.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Ifif!=null) Ifif.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(Begif!=null) Begif.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(Endif!=null) Endif.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedIf(\n");

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

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Endif!=null)
            buffer.append(Endif.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedIf]");
        return buffer.toString();
    }
}
