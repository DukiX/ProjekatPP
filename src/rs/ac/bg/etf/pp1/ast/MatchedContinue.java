// generated with ast extension for cup
// version 0.8
// 21/2/2019 19:19:5


package rs.ac.bg.etf.pp1.ast;

public class MatchedContinue extends Matched {

    public MatchedContinue () {
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
        buffer.append("MatchedContinue(\n");

        buffer.append(tab);
        buffer.append(") [MatchedContinue]");
        return buffer.toString();
    }
}
