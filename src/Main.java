import Util.CommandUtil;
import Util.ReadUtil;
import Util.WriteUtil;
import peer.randomexp.CreateExpression;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //测试用例
        String ak[] = {"-r","10","-a","D:\\SEwork\\SimpleArithmeticProgram\\result.txt","-e","D:\\SEwork\\SimpleArithmeticProgram\\result2.txt"};

        CommandUtil commandUtil = new CommandUtil();
        commandUtil.getParameter(args);

        String currentDir = System.getProperty("user.dir");
        String Exercises = currentDir+"\\Exercises.txt";
        String Grade = currentDir+"\\Grade.txt";
        String answer = currentDir+"\\Answers.txt";

        //写入题目与答案
        if (commandUtil.getR()>0){
            CreateExpression a = new CreateExpression(commandUtil.getN(), commandUtil.getR());
            Map<String, String> tmp = a.getExpressionAndResult();
            WriteUtil.WriteExpression(tmp,Exercises,answer);
        }

        //批阅答案并输出结果
        if(commandUtil.getA()!=null&&commandUtil.getE()!=null){
            WriteUtil.WriteCompareResult(ReadUtil.ResultCompare(commandUtil.getA(),commandUtil.getE()),Grade);
        }

    }
}
