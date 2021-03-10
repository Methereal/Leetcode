package leetcode.easy;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class q1512 {
    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }
    public static int numIdenticalPairs(int[] nums) {
        int r=0;
        sort(nums);
        if(nums==null){
            return r;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    r++;
                }
                else{
                    break;
                }
            }
        }
        return r;

    }
}
