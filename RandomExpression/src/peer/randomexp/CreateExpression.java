package peer.randomexp;

import java.util.*;

public class CreateExpression {
    Map<String, String> answer;

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

    public CreateExpression(int n, int r) {
        Map<String, Expression> exist;
        if(n <= 0 || r < 0) {
            answer= null;
            exist = null;
            return;
        }
        Random rand = new Random();
        ArrayList<Expression> exprs = new ArrayList<>();
        ArrayList<Expression.OPTYPE> operators = new ArrayList<>();
        int operatorNums = rand.nextInt(3) + 1;
        for(int i = 0;i < 3 + 1;i++) {
            int numerator = rand.nextInt(r);
            LeafExpression tmp = new LeafExpression(new Fraction(numerator, 1));
            exprs.add(tmp);
        }
        operators.add(Expression.OPTYPE.Add);
        operators.add(Expression.OPTYPE.Add);
        operators.add(Expression.OPTYPE.Add);
        /*
        for(int i = 0;i < operatorNums - 1;i++) {
            int op = rand.nextInt(1000);
            op = op % (Expression.OPTYPE.values().length - 1);
            switch(op){
                case 0:
                    operators.add(Expression.Add());
                    break;
                case 1:
                    operators.add(Expression.Sub());
                    break;
                case 2:
                    operators.add(Expression.Mul());
                    break;
                case 3:
                    operators.add(Expression.Div());
                    break;
                default:
                    System.out.println("Lose");
                    break;
            }
        }
        */
        if(analysis(operators)){
            ExpressionSort(exprs);
        }
        Queue<Expression> queue_exp = new LinkedList<>();
        for(Expression exp : exprs) {
            queue_exp.offer(exp);
        }
        for(Expression.OPTYPE op : operators) {
            Expression left = queue_exp.poll();
            Expression right = queue_exp.poll();
            if(op == Expression.OPTYPE.Add) {
                queue_exp.offer(new AddExpression(left, right));
            }
            /*
            else if(op == Expression.OPTYPE.Sub) {
                queue_exp.offer(new SubExpression(left, right));
            }
            else if(op == Expression.OPTYPE.Mul) {
                queue_exp.offer(new MulExpression(left, right));
            }
            else if(op == Expression.OPTYPE.Div) {
                queue_exp.offer(new DivExpression(left, right));
            }
             */
        }
        Expression result = queue_exp.poll();
        System.out.println(result.getExp());
    }

    public Map<String, String> getExps() {
        return null;
    }

}
