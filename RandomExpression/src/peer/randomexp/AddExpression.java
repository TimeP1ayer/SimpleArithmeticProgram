package peer.randomexp;

import java.util.Random;

public class AddExpression extends Expression{
    @Override
    public String getExp() {
        Random rand = new Random();
        String ret = left.getExp() + "+" + right.getExp();
        if(rand.nextInt(100) % 2 == 0){
            ret = "(" + ret + ")";
        }
        return ret;
    }

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
        result = left.result.Add(right.result);
        if(left.maxLeaf.Great(right.maxLeaf)) {
            maxLeaf = left.maxLeaf;
        }
        else {
            maxLeaf = right.maxLeaf;
        }
        opType = OPTYPE.Add;
    }
}
