package peer.randomexp;

import com.sun.source.tree.Tree;

import java.util.*;

public class CreateExpression {
    Map<String, String> answer;
    Map<String, ArrayList<Expression>> exist;

    private boolean TreesEqual(Expression x, Expression y) {
        if(x == null && y == null) {
            return true;
        }
        if(x == null || y == null) {
            return false;
        }
        if(x.opType != y.opType) {
            return false;
        }
        if(x.opType == Expression.OPTYPE.Leaf) {
            if(x.result == y.result)  {
                return true;
            }
            else {
                return false;
            }
        }
        boolean left = TreesEqual(x.left, y.left);
        boolean right = TreesEqual(x.right, y.right);
        return left && right;

    }

    private boolean hasDulplicate(Expression x, ArrayList<Expression> list) {
        for(Expression it : list) {
            if(TreesEqual(it, x)) {
                return true;
            }
        }
        return false;
    }
    private void ExpressionSort(ArrayList<Expression> exprs) {
        for(int i = 1;i < exprs.size();i++){
            Expression tmp = exprs.get(i);
            int j = 0;
            for(j = i - 1; j >= 0;j--) {
                if(tmp.getMaxLeaf().Great(exprs.get(j).maxLeaf)) {
                    exprs.set(j+1, exprs.get(j));
                }
                else {
                    break;
                }
            }
            exprs.set(j+1, tmp);
        }
    }
    private boolean analysis(ArrayList<Expression.OPTYPE> list) {
        int addNum = 0;
        int subNum = 0;
        int mulNum = 0;
        int divNum = 0;
        for(Expression.OPTYPE it : list) {
            if(it == Expression.OPTYPE.Add) {
                addNum++;
            }
            else if(it == Expression.OPTYPE.Sub) {
                subNum++;
            }
            else if(it == Expression.OPTYPE.Mul) {
                mulNum++;
            }
            else if(it == Expression.OPTYPE.Div) {
                divNum++;
            }
        }
        if(list.size() == addNum) {
            return true;
        }
        else if(list.size() == mulNum) {
            return true;
        }
        return false;
    }

    public void CreateOneExpression(int r) {
        Random rand = new Random();
        ArrayList<Expression> exprs = new ArrayList<>();
        ArrayList<Expression.OPTYPE> operators = new ArrayList<>();
        int operatorNums = rand.nextInt(3) + 1;
        // int[] test = {9, 8, 5};
        // operatorNums = test.length - 1;
        for(int i = 0;i < operatorNums + 1;i++) {
            int numerator = rand.nextInt(r);
            // numerator = test[i];
            LeafExpression tmp = new LeafExpression(new Fraction(numerator, 1));
            exprs.add(tmp);
        }
        // int[] test_op = {0, 1};
        for(int i = 0;i < operatorNums;i++) {
            int op = rand.nextInt(1000);
            op = op % (Expression.OPTYPE.values().length - 1);
            // op = test_op[i];
            switch(op){
                case 0:
                    operators.add(Expression.OPTYPE.Add);
                    break;
                case 1:
                    operators.add(Expression.OPTYPE.Sub);
                    break;
                case 2:
                    operators.add(Expression.OPTYPE.Mul);
                    break;
                case 3:
                    operators.add(Expression.OPTYPE.Div);
                    break;
                default:
                    System.out.println("Lose");
                    break;
            }
        }
        if(analysis(operators)){
            ExpressionSort(exprs);
        }
        Queue<Expression> queue_exp = new LinkedList<>();
        for(Expression exp : exprs) {
            // System.out.printf("%s ", exp.getExp());
            queue_exp.offer(exp);
        }
        // System.out.println(" ");
        for(Expression.OPTYPE op : operators) {
            Expression left = queue_exp.poll();
            Expression right = queue_exp.poll();
            if(op == Expression.OPTYPE.Add) {
                queue_exp.offer(new AddExpression(left, right));
            }
            else if(op == Expression.OPTYPE.Sub) {
                queue_exp.offer(new SubExpression(left, right));
            }
            else if(op == Expression.OPTYPE.Mul) {
                queue_exp.offer(new MulExpression(left, right));
            }
            else if(op == Expression.OPTYPE.Div) {
                queue_exp.offer(new DivExpression(left, right));
            }
        }
        Expression result = queue_exp.poll();
        ArrayList<Expression> rlist = exist.get(result.result.ToString());
        if(rlist == null) {
            rlist = new ArrayList<>();
            rlist.add(result);
            exist.put(result.result.ToString(), rlist);
            answer.put(result.getExp(), result.getResult());
        }
        else {
            if(!hasDulplicate(result, rlist)) {
                rlist.add(result) ;
                exist.put(result.result.ToString(), rlist);
                answer.put(result.getExp(), result.getResult());
            }
        }
    }

    public CreateExpression(int n, int r) {
        if(r < 0 || n <= 0) {
            answer = null;
            exist = null;
            return;
        }
        exist = new HashMap<>();
        answer = new HashMap<>();
        while(answer.size() < n) {
            try {
                CreateOneExpression(r);
                System.out.println(answer.size());
            }
            catch (Exception e) {
                String noop = e.toString();
            }
        }
    }

    public Map<String, String> getExpressionAndResult() {
        return answer;
    }

}
