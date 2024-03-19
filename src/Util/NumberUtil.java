package Util;

import java.util.Map;

public class NumberUtil {
    /**
     * @param max 数字的最小值
     * @param min 数字的最大值
     * @return num int型数字
     */
    public static int CreateRandomInt(int max,int min){
        if (min<0){
            return 0;
        }
        //生成整数  (最小值+Math.random()*(最大值-最小值+1))
        //同时题目要求为[min,max)
        int num = (int) (min+Math.random()*((max-1)-min+1));
        return num;
    }

    /**
     *
     * @param max 数字的最小值
     * @param min 数字的最大值
     * @return map集合，包含分数和分数的字符串形式
     */
    public static Map CreateRandomFrac(int max,int min){

    }
}
