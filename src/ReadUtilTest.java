import Util.ReadUtil;
import org.junit.Test;

public class ReadUtilTest {

    @Test
    public void countLine() {
        System.out.println("line:"+ ReadUtil.CountLine("D:\\Users\\Desktop\\exp.txt"));
    }

    @Test
    public void getResult() {
        System.out.println(ReadUtil.GetResult("D:\\Users\\Desktop\\exp.txt",3));
        System.out.println(ReadUtil.GetResult("D:\\Users\\Desktop\\exp.txt",5));

    }
}