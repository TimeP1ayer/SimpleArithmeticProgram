package Util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 用于管理表达式与答案的输出
 *
 */

public class WriteUtil {
    //写入表达式,在文件的下一行写入
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

}
