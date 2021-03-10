package leetcode.normal;

public class p29 {
    public static void main(String[] args) {
        System.out.println(divide(1,-1));
    }
    public static int divide(int dividend, int divisor) {
        int rt=0;
        if(Math.abs(dividend)<Math.abs(divisor)){
            return 0;
        }
        int bol=1;
        if(divisor<0&&dividend>0){
            bol=-1;
            divisor=Math.abs(divisor);
        }
        if(divisor>0&&dividend<0){
            bol=-1;
            dividend=Math.abs(dividend);
        }
        while (dividend>=divisor){
            dividend-=divisor;
            rt++;
        }
        return rt*bol;
    }
}
