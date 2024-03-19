package peer.randomexp;

public class Fraction {
    /*
    这个类用来定义分数
    统一表达式树中的数据流
     */
    int numerator;
    int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String ToString() {
        // 先看看是不是整数
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        else if (denominator > numerator) {
            return String.format("%d/%d",numerator, denominator);
        }
        else if(denominator == numerator) {
            return String.valueOf(1);
        }
        // 商，带分数中的带子还是什么之类的东西
        int quotient = numerator / denominator;
        int mod = numerator % denominator;
        return String.format("%d'%d/%d", quotient, mod, denominator);
    }
}
