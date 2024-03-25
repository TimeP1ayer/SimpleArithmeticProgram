package peer.randomexp;

import java.util.Random;

public class SubExpression extends Expression{
    @Override
    public String getExp() {
        Random rand = new Random();
        String leftExp = left.getExp();
        String rightExp = right.getExp();
        // 运算优先级相同或更高的，可加括号也可不加，所以采用随机加括号的方法
        if(left.opType.equals(OPTYPE.Add) || left.opType.equals(OPTYPE.Sub)
                || left.opType.equals(OPTYPE.Mul) || left.opType.equals(OPTYPE.Div)) {
            if(rand.nextInt(100)%2==0){
                leftExp = "(" + leftExp + ")";
            }
        }
        if(right.opType.equals(OPTYPE.Mul) || right.opType.equals(OPTYPE.Div)) {
            if(rand.nextInt(100)%2==0){
                rightExp = "(" + rightExp + ")";
            }
        }
        else if(right.opType.equals(OPTYPE.Add) || right.opType.equals(OPTYPE.Sub)) {
            rightExp = "(" + rightExp + ")";
        }
        return leftExp + " - " + rightExp;
    }

    public SubExpression(Expression left, Expression right) {
        // 保证 E1 >= E2,则左子树的结果一定得大于右子树，不然就会产生负数
        // 选择结果大的那棵子树作为左子树
        if(left.result.Great(right.result)) {
            this.left = left;
            this.right = right;
        }
        else {
            this.left = right;
            this.right = left;
        }
        this.result = this.left.result.Sub(this.right.result);
        if(left.maxLeaf.Great(right.maxLeaf)) {
            this.maxLeaf = left.maxLeaf;
        }
        else {
            this.maxLeaf = right.maxLeaf;
        }
        opType = OPTYPE.Sub;
    }
}
