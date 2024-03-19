package Util;

public class NumberUtilTest {

    @org.junit.Test
    public void createRandomInt() {
        System.out.println(NumberUtil.CreateRandomInt(10,0));
    }

    @org.junit.Test
    public void createRandomFrac() {
        String []map;
        map=NumberUtil.CreateRandomFrac(20,1);
        for (int i =0;i<3;i++){
            System.out.println(map[i]);
        }
    }
}