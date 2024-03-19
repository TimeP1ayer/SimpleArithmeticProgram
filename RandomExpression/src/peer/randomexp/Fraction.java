package peer.randomexp;

public class Fraction {
    /*
    这个类用来定义分数
    统一表达式树中的数据流
     */
    int numerator;
    int denominator;
    boolean negative;

    private void simplify() {
        if(numerator == 0) {
            return;
        }
        else if(numerator > 0 && denominator > 0) {
            negative = false;
        }
        else if(numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
            negative = false;
        }
        else {
            negative = true;
        }
        int gcd = getGreatestCommonDivider(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int getGreatestCommonDivider(int x, int y) {
        int a = Math.abs(x);
        int b = Math.abs(y);
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    public Fraction(int numerator, int denominator) {
        if(denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public String ToString() {
        String ret = null;
        if(numerator == 0) {
            ret = String.valueOf(0);
        }
        // 先看看是不是整数
        if (denominator == 1) {
            ret = String.valueOf(numerator);
        }
        else if (denominator > numerator) {
            ret = String.format("%d/%d",numerator, denominator);
        }
        else if (denominator == numerator) {
            ret = String.valueOf(1);
        }
        // 商，带分数中的带子还是什么之类的东西
        int quotient = numerator / denominator;
        int mod = numerator % denominator;
        ret = String.format("%d'%d/%d", quotient, mod, denominator);
        if(negative)
            return String.format("-%s", ret);
        return ret;
    }

}
