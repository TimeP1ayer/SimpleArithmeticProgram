import org.junit.Test;
import peer.randomexp.CreateExpression;
import peer.randomexp.Fraction;

import java.util.Map;

public class RandomExpressionTest {
    @Test
    public void ToStringTest() {
        // 测试整数
        Fraction f1 = new Fraction(2, 1);
        System.out.println(f1.ToString());
        // 测试真分数
        Fraction f2 = new Fraction(1, 6);
        System.out.println(f2.ToString());
        // 测试假分数
        Fraction f3 = new Fraction(16, 6);
        System.out.println(f3.ToString());
        // 分子和分母相等
        Fraction f4 = new Fraction(3, 3);
        System.out.println(f4.ToString());
        // 测试负数
        Fraction f5 = new Fraction(-1, 3);
        System.out.println(f5.ToString());
        Fraction f6 = new Fraction(1, -3);
        System.out.println(f6.ToString());
        Fraction f7 = new Fraction(3, -2);
        System.out.println(f7.ToString());
        // 测试分母为零
        try {
            Fraction zero = new Fraction(1, 0);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        // 对分数加法的测试
        // 正数的加法
        Fraction a1 = new Fraction(2, 1);
        Fraction a2 = new Fraction(1, 4);
        System.out.println(a1.Add(a2).ToString());
        // 存在负数的加减法
        a1 = new Fraction(-1, 2);
        a2 = new Fraction(2, 1);
        System.out.println(a1.Add(a2).ToString());
        // 对分数的减法测试
        a1 = new Fraction(1, 4);
        a2 = new Fraction(2, 1);
        System.out.println(a1.Sub(a2).ToString());
        System.out.println(a2.Sub(a1).ToString());
        // 对分数的乘法进行测试
        a1 = new Fraction(3, 4);
        a2 = new Fraction(-4, 3);
        System.out.println(a1.Mul(a2).ToString());
        a2 = new Fraction(4, 3);
        System.out.println(a1.Mul(a2).ToString());
        // 对分数的除法进行测试
        a1 = new Fraction(3, 4);
        a2 = new Fraction(2, 5);
        System.out.println(a1.Div(a2).ToString());
        a1 = new Fraction(2, -5);
        System.out.println(a1.Div(a2).ToString());
    }
    @Test
    public void CreateExpressionTest() {
        CreateExpression a = new CreateExpression(30, 2);
        Map<String, String> tmp = a.getExpressionAndResult();
        for(String exp : tmp.keySet()) {
            System.out.println(exp);
        }
    }
}
