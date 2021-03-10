package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        for (int i : twoSum(new int[]{2, 7, 11, 15}, 9)) {
            System.out.println(i);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m=new HashMap();
        for(int i=0;i<nums.length;i++){
            m.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int x=target-nums[i];
            if(m.containsKey(x)&&m.get(x)!=i){
                return new int[]{i,m.get(x)};
            }
        }
        return null;
    }
}
//AC，3ms
/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

 */
