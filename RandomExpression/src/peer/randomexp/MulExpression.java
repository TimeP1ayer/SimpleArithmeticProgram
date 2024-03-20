package peer.randomexp;

public class MulExpression extends Expression{
    @Override
    public String getExp() {
        return "Mul";
    }

    public MulExpression(Expression left, Expression right) {
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
