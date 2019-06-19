// generated with ast extension for cup
// version 0.8
// 15/5/2019 18:19:4


package rs.ac.bg.etf.pp1.ast;

public class EnumElem extends EnumList {

    private String name;
    private EnumNumbering EnumNumbering;

    public EnumElem (String name, EnumNumbering EnumNumbering) {
        this.name=name;
        this.EnumNumbering=EnumNumbering;
        if(EnumNumbering!=null) EnumNumbering.setParent(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public EnumNumbering getEnumNumbering() {
        return EnumNumbering;
    }

    public void setEnumNumbering(EnumNumbering EnumNumbering) {
        this.EnumNumbering=EnumNumbering;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(EnumNumbering!=null) EnumNumbering.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EnumNumbering!=null) EnumNumbering.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EnumNumbering!=null) EnumNumbering.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumElem(\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        if(EnumNumbering!=null)
            buffer.append(EnumNumbering.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumElem]");
        return buffer.toString();
    }
}
