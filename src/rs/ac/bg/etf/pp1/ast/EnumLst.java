// generated with ast extension for cup
// version 0.8
// 3/1/2019 11:41:1


package rs.ac.bg.etf.pp1.ast;

public class EnumLst extends EnumList {

    private EnumList EnumList;
    private String name;
    private EnumNumbering EnumNumbering;

    public EnumLst (EnumList EnumList, String name, EnumNumbering EnumNumbering) {
        this.EnumList=EnumList;
        if(EnumList!=null) EnumList.setParent(this);
        this.name=name;
        this.EnumNumbering=EnumNumbering;
        if(EnumNumbering!=null) EnumNumbering.setParent(this);
    }

    public EnumList getEnumList() {
        return EnumList;
    }

    public void setEnumList(EnumList EnumList) {
        this.EnumList=EnumList;
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
        if(EnumList!=null) EnumList.accept(visitor);
        if(EnumNumbering!=null) EnumNumbering.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EnumList!=null) EnumList.traverseTopDown(visitor);
        if(EnumNumbering!=null) EnumNumbering.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EnumList!=null) EnumList.traverseBottomUp(visitor);
        if(EnumNumbering!=null) EnumNumbering.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumLst(\n");

        if(EnumList!=null)
            buffer.append(EnumList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        if(EnumNumbering!=null)
            buffer.append(EnumNumbering.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumLst]");
        return buffer.toString();
    }
}
