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
            numerator = -Math.abs(numerator);
            denominator = Math.abs(denominator);
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
        return a;
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
        else if (denominator > Math.abs(numerator)) {
            ret = String.format("%d/%d",numerator, denominator);
        }
        else if (denominator == numerator) {
            ret = String.valueOf(1);
        }
        else {
            // 商，带分数中的带子还是什么之类的东西
            int quotient = numerator / denominator;
            int mod = numerator % denominator;
            ret = String.format("%d'%d/%d", quotient, Math.abs(mod), denominator);
        }
        return ret;
    }

    public Fraction Add(Fraction x) {
        int NewNumerator = this.numerator * x.denominator + this.denominator * x.numerator;
        int NewDenominator = this.denominator * x.denominator;
        int gcd = getGreatestCommonDivider(NewNumerator, NewDenominator);
        Fraction ret = new Fraction(NewNumerator / gcd, NewDenominator / gcd);
        ret.simplify();
        return ret;
    }

    public Fraction Sub(Fraction x) {
        int NewNumerator = this.numerator * x.denominator - this.denominator * x.numerator;
        int NewDenominator = this.denominator * x.denominator;
        int gcd = getGreatestCommonDivider(NewNumerator, NewDenominator);
        Fraction ret = new Fraction(NewNumerator / gcd, NewDenominator / gcd);
        ret.simplify();
        return ret;
    }

    public Fraction Mul(Fraction x) {
        int NewNumerator = this.numerator * x.numerator;
        int NewDenominator = this.denominator * x.denominator;
        int gcd = getGreatestCommonDivider(NewNumerator, NewDenominator);
        Fraction ret = new Fraction(NewNumerator / gcd, NewDenominator / gcd);
        ret.simplify();
        ret.negative = this.negative ^ x.negative;
        return ret;
    }
    public Fraction Div(Fraction x) {
        int NewNumerator = this.numerator * x.denominator;
        int NewDenominator = this.denominator * x.numerator;
        int gcd = getGreatestCommonDivider(NewNumerator, NewDenominator);
        Fraction ret = new Fraction(NewNumerator / gcd, NewDenominator / gcd);
        ret.simplify();
        ret.negative = this.negative ^ x.negative;
        return ret;
    }
}
