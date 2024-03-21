package Util;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * 用于管理表达式与答案的输出
 *
 */

public class WriteUtil {

    /**
     *
     * @param tmp 表达式和答案map
     * @param expPath 表达式文件路径
     * @param answerPath 答案文件路径
     */
    public static void WriteExpression(Map<String, String> tmp, String expPath,String answerPath){

        //检查是否存在此文件
        File file1 = new File(expPath);
        File file2 = new File(answerPath);

        try {
            //不存在则创建此文件
            if (!file1.exists()){
                file1.createNewFile();
            }else {
                //清空文件
                FileWriter writer = new FileWriter(expPath);
                writer.write("");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //不存在则创建此文件
            if (!file2.exists()){
                file2.createNewFile();
            }else {
                FileWriter writer = new FileWriter(answerPath);
                writer.write("");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            BufferedWriter expWriter = new BufferedWriter(new FileWriter(expPath));
            BufferedWriter answerWriter = new BufferedWriter(new FileWriter(answerPath));
            int i=1;
            for (Map.Entry<String,String>entry : tmp.entrySet()){
                expWriter.write(i+"."+entry.getKey()+"=");
                expWriter.newLine();
                i++;
            }
            expWriter.close();
            i=1;
            for (Map.Entry<String,String>entry : tmp.entrySet()){
                answerWriter.write(i+"."+entry.getValue());
                answerWriter.newLine();
                i++;
            }
            answerWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param GetCompareResult 答案批阅结果
     * @param FilePath 结果写入文件路径
     */
    public static void WriteCompareResult(ArrayList<Integer>[] GetCompareResult, String FilePath) {
        File file = new File(FilePath);
        try {
            //不存在则创建此文件
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> Correct = GetCompareResult[0];
        ArrayList<Integer> Wrong = GetCompareResult[1];

        if (Correct==null||Wrong==null){
            return;
        }

        /**
         * eg.
         * Correct: 5 (1, 3, 5, 7, 9)
         * Wrong: 5 (2, 4, 6, 8, 10)
         */

        String sCorrect ="";
        String sWrong = "";
        if (Correct.size()!=0){
            String CorrectNumber = Correct.get(0).toString();
            for (int i = 1; i <Correct.size();i++) {
                CorrectNumber += ", "+Correct.get(i).toString();
            }
            sCorrect = "Correct: " + Correct.size() + " (" + CorrectNumber +")";
        }

        if(Wrong.size()!=0){
            String WrongNumber = Wrong.get(0).toString();
            for (int i = 1; i <Wrong.size();i++) {
                WrongNumber += ", "+Wrong.get(i).toString();
            }
            sWrong = "Wrong: " + Wrong.size() + " (" + WrongNumber +")";
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FilePath));
            writer.write(sCorrect);
            writer.newLine();
            writer.write(sWrong);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
