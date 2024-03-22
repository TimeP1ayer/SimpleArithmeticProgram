package Util;

import java.io.File;
import java.util.Arrays;


public class CommandUtil {

    private int n;
    private int r;
    private String e;
    private String a;

    public int getN() {
        return n;
    }

    public int getR() {
        return r;
    }

    public String getE() {
        return this.e;
    }

    public String getA() {
        return this.a;
    }

    //n 个数
    //r 范围
    //e 回答答案
    //a 正确答案
    public CommandUtil(){
        //默认参数
        this.n=10;
        //r必须由用户给出
        this.e=null;
        this.a=null;
    }

    public void getParameter(String [] args){

        String waring = "生成题目用法提示：\n" +
                        "生成10个题目数量:-n 10 \n" +
                        "(生成题目时必填)生成题目数值范围为0~15:-r 15 \n"+
                        "批改功能用法提示：\n" +
                        "需要批改功能时,作答文件与标准答案文件都必须在程序运行目录SimpleArithmeticProgram下，参数应该为目录下的文件名\n"+
                        "作答文件:-e exercisefile.txt \n"+
                        "标准答案文件:-a answerfile\n";

        int n = Arrays.asList(args).indexOf("-n");
        int r = Arrays.asList(args).indexOf("-r");
        int e = Arrays.asList(args).indexOf("-e");
        int a = Arrays.asList(args).indexOf("-a");
        int length = args.length;

        if (n!=-1&&args[n+1]!=null&&args[n+1].matches("\\d+")){
            this.n=Integer.valueOf(args[n+1]);
        }else {
            System.out.println(waring);
        }

        if (r!=-1&&args[r+1]!=null&&args[r+1].matches("\\d+")){
            this.r=Integer.valueOf(args[r+1]);
        }else {
            System.out.println("如果需要生成题目，请先输入-r的参数再运行程序!");
            System.out.println(waring);
        }

        if (e!=-1&&(e+1)<=length&&a!=-1&&(a+1)<length){
            this.e=isFile(args[e+1]);
            this.a=isFile(args[a+1]);
        }else if(e!=-1||a!=-1){
            System.out.println(waring);
        }

    }

    //路径是否合格
    public String isFile(String path){
        File file = new File(path);
        if (file.exists()) {
            return path;
        } else {
            return null;
        }
    }

}
