import Util.ReadUtil;
import Util.WriteUtil;
import peer.randomexp.CreateExpression;
import peers.explain.ExplainArgument;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] args0 = {"-n", "10", "-r", "10"};
        ExplainArgument explainer = null;
        try{
            explainer = new ExplainArgument(args0);
            if(explainer.isOpenCreateExpression()) {
                CreateExpression generator = new CreateExpression(explainer.getN(), explainer.getR());
                Map<String,String> temp = generator.getExpressionAndResult();
                int i = 1;
                for(String exp : temp.keySet()) {
                    WriteUtil.WriteExpression(i+"."+exp+"=",".\\Exercises.txt");
                    i++;
                }
                i = 1;
                for(String result : temp.values()) {
                    WriteUtil.WriteExpression(i+"."+result,".\\Answers.txt");
                    i++;
                }
            }
            if(explainer.isOpenCompareResult()) {
                ArrayList<Integer>[] GetCompareResult = ReadUtil.ResultCompare(explainer.getAnswerFile(), explainer.getExerciseFile());
                ArrayList<Integer>Correct = GetCompareResult[0];
                ArrayList<Integer>Wrong = GetCompareResult[1];
                System.out.print("Correct:");
                for (int num:Correct){
                    System.out.print(num+" ");
                }

                System.out.println();
                System.out.print("Wrong:");
                for(int n:Wrong){
                    System.out.print(n+" ");
                }
            }
            if(!explainer.isOpenCreateExpression() && !explainer.isOpenCompareResult()) {
                System.out.println("Usage: main.jar -n 整数 -r 整数 -e 练习答案文件 -a 试题答案文件");
            }

        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }
}
