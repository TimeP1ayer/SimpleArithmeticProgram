package peer.randomexp;

import java.util.*;

public class CreateExpression {
    Map<String, String> answer;

    public CreateExpression(int n, int r) {
        Map<String, Expression> exist;
        if(n <= 0 || r < 0) {
            answer= null;
            exist = null;
            return;
        }
        Random rand = new Random();
        Queue<Expression> exprs = new LinkedList<Expression>();
        Queue<Expression.OPTYPE> operators = new LinkedList<Expression.OPTYPE>();
        for(int i = 0;i < n;i++) {
            int numerator = rand.nextInt(r);
            LeafExpression tmp = new LeafExpression(new Fraction(numerator, 1));
            exprs.offer(tmp);
        }
        for(int i = 0;i < n - 1;i++) {
            int op = rand.nextInt(1000);
            op = op % (Expression.OPTYPE.values().length - 1);
            switch(op){
                case 0:
                    operators.offer(Expression.Add());
                    break;
                case 1:
                    operators.offer(Expression.Sub());
                    break;
                case 2:
                    operators.offer(Expression.Mul());
                    break;
                case 3:
                    operators.offer(Expression.Div());
                    break;
            }
        }
        while(exprs.size() >= 2) {
            ArrayList<Expression> buffer = new ArrayList<>();
            ArrayList<Expression.OPTYPE> typeBuffer = new ArrayList<>();
        }
    }

    public Map<String, String> getExps() {
        return null;
    }

}
