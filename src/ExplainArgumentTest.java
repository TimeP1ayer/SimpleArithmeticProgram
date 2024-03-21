import org.junit.Test;
import peers.explain.ExplainArgument;

public class ExplainArgumentTest {
    @Test
    public void ExplainTest() {
        // 测试正常的参数解释
        String[] args0 = {"-n", "10", "-r", "10"};
        ExplainArgument explainer = new ExplainArgument(args0);
        System.out.println("已经开启了随机生成表达式功能? " + explainer.isOpenCreateExpression());
        System.out.println("已经开启了答案对比功能? " + explainer.isOpenCompareResult());
        System.out.println("生成题目条数：" + explainer.getN() +
                ", 生成的基数范围为[0, " + explainer.getR() + ")");
        System.out.printf("答案文件为：%s, 学生文件为：%s\n",
                explainer.getExerciseFile(), explainer.getAnswerFile());
        System.out.println(" ");

        String[] args1 = {"-e", "exerciseFile.txt", "-a", "answerFile.txt"};
        explainer = new ExplainArgument(args1);
        System.out.println("已经开启了随机生成表达式功能? " + explainer.isOpenCreateExpression());
        System.out.println("已经开启了答案对比功能? " + explainer.isOpenCompareResult());
        System.out.println("生成题目条数：" + explainer.getN() +
                ", 生成的基数范围为[0, " + explainer.getR() + ")");
        System.out.printf("答案文件为：%s, 学生文件为：%s\n",
                explainer.getExerciseFile(), explainer.getAnswerFile());
        System.out.println(" ");

        // 测试异常参数
        String[] args2 = {"-n", "abx123", "-r", "12"};
        try {
            explainer = new ExplainArgument(args2);
            System.out.println("已经开启了随机生成表达式功能? " + explainer.isOpenCreateExpression());
            System.out.println("已经开启了答案对比功能? " + explainer.isOpenCompareResult());
            System.out.println("生成题目条数：" + explainer.getN() +
                    ", 生成的基数范围为[0, " + explainer.getR() + ")");
            System.out.printf("答案文件为：%s, 学生文件为：%s\n",
                    explainer.getExerciseFile(), explainer.getAnswerFile());
            System.out.println(" ");
        }
        catch(NumberFormatException e) {
            System.out.println("-n 或 -r 中指定的数字中包含字符串！" );
            System.out.println("正确的使用方法：");
            System.out.println("-n 整数 -r 整数 -e 练习文件 -a 答案文件");
            System.out.println(" ");
        }

        // 测试两种功能都指定
        String[] args3 = {"-n", "10", "-r", "10", "-e", "exerciseFile.txt", "-a", "answerFile.txt"};
        explainer = new ExplainArgument(args3);
        System.out.println("已经开启了随机生成表达式功能? " + explainer.isOpenCreateExpression());
        System.out.println("已经开启了答案对比功能? " + explainer.isOpenCompareResult());
        System.out.println("生成题目条数：" + explainer.getN() +
                ", 生成的基数范围为[0, " + explainer.getR() + ")");
        System.out.printf("答案文件为：%s, 学生文件为：%s\n",
                explainer.getExerciseFile(), explainer.getAnswerFile());
        System.out.println(" ");

    }
}
