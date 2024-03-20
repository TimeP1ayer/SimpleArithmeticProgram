package peer.randomexp;

public class Expression {
    /*
    表达式类的基类，主要提供多态性，一般不使用这个对象
     */
    public enum OPTYPE{
        ADD,
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
        return null;
    }

    public String getExp() {
        return null;
    }

    public OPTYPE getType() {
        return opType;
    }

    public Expression getLeft() {
        return null;
    }

    public Expression getRight() {
        return null;
    }

    public Fraction getMaxLeaf() {
        return maxLeaf;
    }

    public OPTYPE getOpType() {
        return opType;
    }


    public static OPTYPE Add() {
        return OPTYPE.ADD;
    }

    public static OPTYPE Sub() {
        return OPTYPE.Sub;
    }
    public static OPTYPE Mul() {
        return OPTYPE.Mul;
    }
    public static OPTYPE Div() {
        return OPTYPE.Div;
    }

    public  static  OPTYPE Leaf() {
        return OPTYPE.Leaf;
    }
}
