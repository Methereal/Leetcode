package leetcode.easy;

import java.util.Map;
import java.util.Random;

public class p374 {
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
    public static int guessNumber(int n) {
        int left = 1, right = n, res, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            res = guess(mid);
            if (res == 0) return mid; //猜对了
            else if (res == 1) left = mid + 1;//猜小了
            else right = mid - 1; //猜大了
        }
        return -1;
    }
    public static int guess(int n){
        int rannum=6;
        if(n==rannum){
            return 0;
        }
        if(n<rannum){
            return 1;
        }
        if(n>rannum){
            return -1;
        }
        return 0;
    }
}
