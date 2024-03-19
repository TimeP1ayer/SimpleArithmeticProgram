import org.junit.Test;
import peer.randomexp.Fraction;
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
    }

}
