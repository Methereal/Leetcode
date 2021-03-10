package leetcode.easy;


public class p7 {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
    /*public static int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }*/
    //两种方法都可以，本题的主要问题就是处理数据溢出。

    public static int reverse(int x) {
        int jug=1;
        if(x<0){
            jug=-1;
        }
        String sx=new StringBuffer(String.valueOf(Math.abs(x))).reverse().toString();

        try{return jug*Integer.valueOf(sx);}
        catch (Exception e){
            return 0;
        }
    }
}
/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21

 */
