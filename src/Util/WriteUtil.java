package Util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * 用于管理表达式与答案的输出
 *
 */

public class WriteUtil {

    /**
     * 写入表达式,在文件的最后一行的下一行写入
     * @param exp 表达式
     * @param FilePath 写入路径
     */
    public static void WriteExpression(String exp,String FilePath){

        //检查是否存在此文件
        File file = new File(FilePath);
        try {
            //不存在则创建此文件
            if (!file.exists()){
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            RandomAccessFile randomFile = new RandomAccessFile(FilePath,"rw");

            long fileLength = randomFile.length();
            randomFile.seek(fileLength);
            //换行
            randomFile.writeBytes(exp+"\n");
            randomFile.close();

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
         * Correct: 5 (1, 3, 5, 7, 9)
         * Wrong: 5 (2, 4, 6, 8, 10)
         */
        String CorrectNumber = Correct.get(0).toString();
        String WrongNumber = Wrong.get(0).toString();
        for (int i = 1; i <Correct.size();i++) {
            CorrectNumber += ", "+Correct.get(i).toString();
        }
        for (int i = 1; i <Wrong.size();i++) {
            WrongNumber += ", "+Wrong.get(i).toString();
        }

        String sCorrect = "Correct: " + Correct.size() + " (" + CorrectNumber +")";
        String sWrong = "Wrong: " + Wrong.size() + " (" + WrongNumber +")";

        WriteUtil.WriteExpression(sCorrect, FilePath);
        WriteUtil.WriteExpression(sWrong, FilePath);

    }

}
