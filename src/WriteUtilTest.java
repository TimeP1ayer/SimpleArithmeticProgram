import Util.WriteUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class WriteUtilTest {

    @Test
    public void writeExpression() {
        for (int i = 0; i <5 ; i++) {
            WriteUtil.WriteExpression((i+1)+".HappyEveryDay!","D:\\Users\\Desktop\\exp.txt");
        }
    }

}