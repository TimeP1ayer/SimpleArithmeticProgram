import Util.ReadUtil;
import Util.WriteUtil;
import org.junit.Test;
import peer.randomexp.CreateExpression;

import java.util.Map;


public class WriteUtilTest {

    @Test
    public void writeExpression() {

        CreateExpression a = new CreateExpression(30,10);
        Map<String, String> tmp = a.getExpressionAndResult();
        int i = 1;
        //生成算数题目
        for (String exp : tmp.keySet()){
            WriteUtil.WriteExpression(i+"."+exp+"=","D:\\Users\\Desktop\\exp.txt");
            i++;
        }

        //生成题目答案
        i=1;
        for (String result : tmp.values()){
            WriteUtil.WriteExpression(i+"."+result,"D:\\Users\\Desktop\\result.txt");
            i++;
        }

    }

    @Test
    public void CompareResult(){
        WriteUtil.WriteCompareResult(ReadUtil.ResultCompare("D:\\Users\\Desktop\\result.txt","D:\\Users\\Desktop\\result2.txt"),"D:\\Users\\Desktop\\Compareresult.txt");
    }


}