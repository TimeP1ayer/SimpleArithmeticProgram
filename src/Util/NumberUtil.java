package Util;


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
    public static String[] CreateRandomFrac(int max,int min){
        if(max==0||min==0){
            return null;
        }

        //nume 分子
        //deno 分母
        int nume;
        int deno;

        //防止出现0
        do {
            nume = NumberUtil.CreateRandomInt(max, min);
            deno = NumberUtil.CreateRandomInt(max, min);
        } while (nume == 0 || deno == 0);

        //0存放分子，1存放分母，2存放TrueExp
        String[] map = new String[3];
        //分数的字符串形式
        String TrueExp;

        if(nume%deno!=0&&nume/deno!=0){
            //化为真分数
            //分子大于分母
            //整数部分
            int left = nume/deno;
            //新分子
            int nume1 = nume-left*deno;
            TrueExp = left+"'"+nume1+"/"+deno;
            System.out.println(TrueExp);
        }else if(nume/deno==0){
            TrueExp = nume+"/"+deno;
        }else {
            TrueExp = ""+nume/deno;
        }

        map[0]=""+nume;
        map[1]=""+deno;
        map[2]=""+TrueExp;


        return map;
    }
}
