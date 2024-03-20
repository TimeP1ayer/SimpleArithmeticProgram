package peer.randomexp;

public class Expression {
    /*
    表达式类的基类，主要提供多态性，一般不使用这个对象
     */
    public enum OPTYPE{
        Add,
        Sub,
        Mul,
        Div,
        Leaf
    };
    Expression left;
    Expression right;
    Fraction maxLeaf;
    Fraction result;
    OPTYPE opType;

    public String getResult() {
        return result.ToString();
    }

    public String getExp() {
        return "Base Class No Operator";
    }

    public OPTYPE getType() {
        return opType;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public Fraction getMaxLeaf() {
        return maxLeaf;
    }

    public OPTYPE getOpType() {
        return opType;
    }
}
