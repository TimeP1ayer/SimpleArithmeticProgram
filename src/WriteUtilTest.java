import Util.ReadUtil;
import Util.WriteUtil;
import org.junit.Test;
import peer.randomexp.CreateExpression;

import java.util.Map;


public class WriteUtilTest {

    //TODO 覆写文件
    @Test
    public void writeExpression() {
        CreateExpression a = new CreateExpression(10,10);
        Map<String, String> tmp = a.getExpressionAndResult();

        WriteUtil.WriteExpression(tmp,"D:\\Users\\Desktop\\exp.txt","D:\\Users\\Desktop\\result.txt");

    }

    @Test
    public void CompareResult(){
        WriteUtil.WriteCompareResult(ReadUtil.ResultCompare("D:\\Users\\Desktop\\result.txt","D:\\Users\\Desktop\\result2.txt"),"D:\\Users\\Desktop\\Compareresult.txt");
    }


}