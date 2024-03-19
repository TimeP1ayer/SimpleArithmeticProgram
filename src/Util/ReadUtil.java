package Util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 答案格式为
 * 1.result1
 * 2.result2
 * 以"."作为分隔符返回字符串
 */


public class ReadUtil {

    //指示目前读取工具读取到第几行

    private int line=1;

    /**
     * 返回文件行数
     * @param filepath 路径地址
     * @return 文件行数
     */

    public static long CountLine(String filepath){
        long count;
        try {
            count = Files.lines(Paths.get(filepath)).count();
            return count;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;

    }


    /**
     * 读取指定行的字符串
     * @param filepath 路径地址
     * @param targetLine 目标行
     * @return "."后的答案
     */
    public static String GetResult(String filepath,int targetLine){
        File file = new File(filepath);

        String text ;
        int currentLine=1;

        //文件不存在
        if(!file.exists()){
            System.out.println("file does not exist!");
            return null;
        }

        if(file.isFile()){
            try {
                //创建输入流,使用UTF-8格式读取
                FileInputStream fileInputStream = new FileInputStream(filepath);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                BufferedReader Reader = new BufferedReader(inputStreamReader);

                //读取文件第line行文字，每调用一次readline，则往下走一行
                while ( (text = Reader.readLine() )!=null){
                    if(currentLine==targetLine){
                        System.out.println("content: "+text);
                        break;
                    }
                    currentLine++;
                }
                //截取答案
                String targetText = text.substring(text.indexOf(".")+1);
                return  targetText;
            }catch (Exception e){
                //异常处理
                System.out.println("read result wrong");
                return null;
            }
        }
        return null;
    }


}
