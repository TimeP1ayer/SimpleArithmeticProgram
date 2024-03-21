import Util.CommandUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandUtilTest {

    @Test
    public void getParameter() {
        CommandUtil c = new CommandUtil();

        //正常输入参数
        String args[] = {  "-r","70"    ,       "-n","80"          ,"-a","-el","-e","-xp"};
        c.getParameter(args);

        System.out.println("A:"+c.getA());
        System.out.println("E:"+c.getE());
        System.out.println("R:"+c.getR());
        System.out.println("N:"+c.getN());

        System.out.println("-----------");

        //缺少不必要参数
        CommandUtil c1 = new CommandUtil();
        String args1[] = {"-n","80","-r","70","-e","-xp"};
        c1.getParameter(args1);

        System.out.println("A:"+c1.getA());
        System.out.println("E:"+c1.getE());
        System.out.println("R:"+c1.getR());
        System.out.println("N:"+c1.getN());

        System.out.println("-----------");

        //缺少必要参数
        CommandUtil c2 = new CommandUtil();
        String args2[] = {"-n","80","-e","-xp"};
        c2.getParameter(args2);

        System.out.println("A:"+c2.getA());
        System.out.println("E:"+c2.getE());
        System.out.println("R:"+c2.getR());
        System.out.println("N:"+c2.getN());
        System.out.println("-----------");

        //参数缺少

        CommandUtil c4 = new CommandUtil();
        String args4[] = {  "-r",      "-n"          ,   "-a","D:\\Users\\Desktop\\exp.txt"    ,   "-e","-xp"   };
        c4.getParameter(args4);

        System.out.println("A:"+c4.getA());
        System.out.println("E:"+c4.getE());
        System.out.println("R:"+c4.getR());
        System.out.println("N:"+c4.getN());

        System.out.println("-----------");

    }
}