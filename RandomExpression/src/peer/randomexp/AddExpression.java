package peer.randomexp;

import java.util.Map;
import java.util.Random;

public class AddExpression extends Expression{
    @Override
    public String getExp() {
        Random rand = new Random();
        String leftExp = left.getExp();
        String rightExp = right.getExp();
        if(left.opType.equals(OPTYPE.Add) || left.opType.equals(OPTYPE.Sub)
            || left.opType.equals(OPTYPE.Mul) || left.opType.equals(OPTYPE.Div)) {
            if(rand.nextInt(100)%2==0){
                leftExp = "(" + leftExp + ")";
            }
        }
        if(right.opType.equals(OPTYPE.Add) || right.opType.equals(OPTYPE.Sub)
                || right.opType.equals(OPTYPE.Mul) || right.opType.equals(OPTYPE.Div)) {
            if(rand.nextInt(100)%2==0){
                rightExp = "(" + rightExp + ")";
            }
        }
        return leftExp + "+" + rightExp;
    }

    public AddExpression(Expression left, Expression right) {
        // 当以 + 或 * 号为根的树，一棵子树是 + ，另一棵是 *，*左+右
        if(left.opType == OPTYPE.Mul && right.opType == OPTYPE.Add) {
            this.left = left;
            this.right = right;
        }
        else if (left.opType == OPTYPE.Add && right.opType == OPTYPE.Mul) {
            this.left = right;
            this.right = left;
        }
        else if (left.opType == OPTYPE.Add && right.opType == OPTYPE.Add) {
            if(left.result.Great(right.result)) {
                this.left = left;
                this.right = right;
            }
            else {
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
                else {
                    this.left = right;
                    this.right = left;
                }
            }
        }
        else {
            this.left = left;
            this.right = right;
        }
        this.result = left.result.Add(right.result);
        if(left.maxLeaf.Great(right.maxLeaf)) {
            this.maxLeaf = left.maxLeaf;
        }
        else {
            this.maxLeaf = right.maxLeaf;
        }
        opType = OPTYPE.Add;
    }
}
