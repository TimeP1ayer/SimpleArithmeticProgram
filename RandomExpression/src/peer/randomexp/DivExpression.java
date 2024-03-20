package peer.randomexp;

import java.util.Random;

public class DivExpression extends Expression{

    @Override
    public String getExp() {
        Random rand = new Random();
        String leftExp = this.left.getExp();
        String rightExp = this.right.getExp();
        if(left.opType.equals(OPTYPE.Add) || left.opType.equals(OPTYPE.Sub)) {
            leftExp = "(" + leftExp + ")";
        }
        else if(left.opType.equals(OPTYPE.Mul) || left.opType.equals(OPTYPE.Div)) {
            if(rand.nextInt(100) % 2 == 0) {
                leftExp = "(" + leftExp + ")";
            }
        }
        // 分母必须有括号
        if(right.opType != OPTYPE.Leaf) {
            rightExp = "(" + rightExp + ")";
        }
        return leftExp + "/" + rightExp;
    }

    public DivExpression(Expression left, Expression right) {
        if(left.result.isZero() && right.result.isZero()) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }
        else if(left.result.isZero()) {
            this.left = left;
            this.right = right;
        }
        else if(right.result.isZero()) {
            this.left = right;
            this.right = left;
        }
        else {
            this.left = left;
            this.right = right;
        }
        result = this.left.result.Div(this.right.result);
        if(left.maxLeaf.Great(right.maxLeaf)) {
            this.maxLeaf = left.maxLeaf;
        }
        else {
            this.maxLeaf = right.maxLeaf;
        }
        opType = OPTYPE.Div;
    }
}
