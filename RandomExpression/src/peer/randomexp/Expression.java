package peer.randomexp;

public class Expression {
    /**
     * 整个表达式在每一次修改时变量都要更新
     * result 表达式的结果
     * peer.randomexp.Expression 表达式的字符串
     * maxLeaf 表达树中的最大叶子值
     * opType 子树操作符类型
     */
    private String result;
    private String Expression;
    private String maxLeaf;
    private String opType;

    public String getMaxLeaf() {
        return maxLeaf;
    }

    public void setMaxLeaf(String maxLeaf) {
        this.maxLeaf = maxLeaf;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getExpression() {
        return Expression;
    }

    public void setExpression(String expression) {
        Expression = expression;
    }
}
