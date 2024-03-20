package peer.randomexp;

public class LeafExpression extends Expression{
    public LeafExpression(Fraction frac) {
        result = frac;
        maxLeaf = frac;
        left = null;
        right = null;
        opType = OPTYPE.Leaf;
    }

    @Override
    public String getExp() {
        return result.ToString();
    }

}
