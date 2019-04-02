// generated with ast extension for cup
// version 0.8
// 2/3/2019 18:26:34


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String name;
    private DesignatorOptions DesignatorOptions;

    public Designator (String name, DesignatorOptions DesignatorOptions) {
        this.name=name;
        this.DesignatorOptions=DesignatorOptions;
        if(DesignatorOptions!=null) DesignatorOptions.setParent(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public DesignatorOptions getDesignatorOptions() {
        return DesignatorOptions;
    }

    public void setDesignatorOptions(DesignatorOptions DesignatorOptions) {
        this.DesignatorOptions=DesignatorOptions;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorOptions!=null) DesignatorOptions.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorOptions!=null) DesignatorOptions.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorOptions!=null) DesignatorOptions.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        if(DesignatorOptions!=null)
            buffer.append(DesignatorOptions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
