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
        int n = Arrays.asList(args).indexOf("-n");
        int r = Arrays.asList(args).indexOf("-r");
        int e = Arrays.asList(args).indexOf("-e");
        int a = Arrays.asList(args).indexOf("-a");
        int length = args.length;

        if (n!=-1&&args[n+1]!=null&&args[n+1].matches("\\d+")){
            this.n=Integer.valueOf(args[n+1]);
        }

        if (r!=-1&&args[r+1]!=null&&args[r+1].matches("\\d+")){
            this.r=Integer.valueOf(args[r+1]);
        }else {
            System.out.println("请先输入-r的参数再运行程序!");
        }

        if (e!=-1&&(e+1)<=length){
            this.e=isFile(args[e+1]);
        }

        if (a!=-1&&(a+1)<length){
            this.a=isFile(args[a+1]);
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
