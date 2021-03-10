package leetcode.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p347 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3},2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] r=new int[k];
        Map<Integer,Integer> m=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(m.containsKey(nums[i])){
                int tp=m.get(nums[i]);
                m.replace(nums[i],++tp);
            }else {
                m.put(nums[i], 1);
            }
        }
        for(int i=0;i<k;i++){
            int max=0;
            int maxk=0;
            for(Integer key : m.keySet()){
                Integer value = m.get(key);
                if(max<value){
                    max=value;
                    maxk=key;
                }
            }
            r[i]=maxk;
            m.remove(maxk);
        }

        return r;
    }
}
/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]

 */
