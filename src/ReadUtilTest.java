import Util.ReadUtil;
import org.junit.Test;

import java.util.ArrayList;

public class ReadUtilTest {

    @Test
    public void countLine() {
        System.out.println("line:"+ ReadUtil.CountLine("D:\\Users\\Desktop\\exp.txt"));
    }

    @Test
    public void getResult() {
        System.out.println(ReadUtil.GetResult("D:\\Users\\Desktop\\exp.txt",3));
        System.out.println(ReadUtil.GetResult("D:\\Users\\Desktop\\exp.txt",5));
    }

    @Test
    public void ResultCompare(){

        ArrayList<Integer>[] GetCompareResult = ReadUtil.ResultCompare("D:\\Users\\Desktop\\result.txt","D:\\Users\\Desktop\\result2.txt");
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
}