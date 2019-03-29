// generated with ast extension for cup
// version 0.8
// 29/2/2019 12:34:5


package rs.ac.bg.etf.pp1.ast;

public class DotDesignatorOption extends DesignatorOptions {

    private String idnam;

    public DotDesignatorOption (String idnam) {
        this.idnam=idnam;
    }

    public String getIdnam() {
        return idnam;
    }

    public void setIdnam(String idnam) {
        this.idnam=idnam;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DotDesignatorOption(\n");

        buffer.append(" "+tab+idnam);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DotDesignatorOption]");
        return buffer.toString();
    }
}
