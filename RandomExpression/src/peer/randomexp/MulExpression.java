package peer.randomexp;

import java.util.Random;

public class MulExpression extends Expression{
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
        if(right.opType.equals(OPTYPE.Add) || right.opType.equals(OPTYPE.Sub)) {
            rightExp = "(" + rightExp + ")";
        }
        else if(right.opType.equals(OPTYPE.Mul) || right.opType.equals(OPTYPE.Div)) {
            if(rand.nextInt(100) % 2 == 0) {
                rightExp = "(" + rightExp + ")";
            }
        }
        return leftExp + " × " + rightExp;
    }

    public MulExpression(Expression left, Expression right) {
        if(left.getOpType() == right.getOpType()) {
            if(left.result.Equal(right.result)) {
                if(left.maxLeaf.Great(right.maxLeaf)) {
                    this.left = left;
                    this.right = right;
                }
                else {
                    this.left = right;
                    this.right = left;
                }
            }
            else if (left.result.Great(right.result)){
                this.left = left;
                this.right = right;
            }
            else {
                this.left = right;
                this.right = left;
            }
        }
        else {
            int leftLevel = left.opPriority();
            int rightLevel = right.opPriority();
            if(leftLevel > rightLevel) {
                this.left = left;
                this.right = right;
            }
            else {
                this.left = right;
                this.right = left;
            }
        }
        this.result = left.result.Mul(right.result);
        if(left.maxLeaf.Great(right.maxLeaf)) {
            this.maxLeaf = left.maxLeaf;
        }
        else {
            this.maxLeaf = right.maxLeaf;
        }
        opType = OPTYPE.Mul;
    }
}
