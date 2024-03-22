import Util.ReadUtil;
import Util.WriteUtil;
import peer.explain.ExplainArgument;
import peer.randomexp.CreateExpression;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String currentDir = System.getProperty("user.dir");
        String Exercises = currentDir+"\\Exercises.txt";
        String Grade = currentDir+"\\Grade.txt";
        String answer = currentDir+"\\Answers.txt";

        //测试用例
        String[] args0 = {"-n", "100", "-r", "30"};
        String [] ak = {"-r","10","-e",Exercises,"-a",answer};
        String [] ak1 = {"-e",Exercises,"-a",answer};

        try {
            ExplainArgument explainer = new ExplainArgument(args0);
            //写入题目与答案
            if(explainer.isOpenCreateExpression()) {
                CreateExpression generator = new CreateExpression(explainer.getN(), explainer.getR());
                Map<String, String> tmp = generator.getExpressionAndResult();
                WriteUtil.WriteExpression(tmp, Exercises, answer);
            }
            //批阅答案并输出结果
            if(explainer.isOpenCompareResult()) {
                WriteUtil.WriteCompareResult(ReadUtil.ResultCompare(explainer.getAnswerFile(), explainer.getExerciseFile()), Grade);
            }
            if(!explainer.isOpenCreateExpression() && !explainer.isOpenCompareResult()) {
                System.out.println("使用方法：main.jar -n 整数 -r 整数 -e 练习文件 -a 答案文件");
                System.out.println("参数输入顺序对程序运行并无影响");
                System.out.println("生成题目的功能和对比答案的功能并无矛盾，也就是说只要四个参数同时被正确指定，两个功能都能正常运行");
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
