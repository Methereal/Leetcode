package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class p1207 {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    }
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> m=new HashMap<>();
        Map<Integer,Integer> km=new HashMap<>();
        for (int num : arr) { //m中存储数组的映射，key存放元素，value存储出现次数。
            if(m.containsKey(num)){
                int rp=m.get(num)+1;
                m.replace(num,m.get(num),rp);
            }else{
                m.put(num,0);
            }
        }
        for(Integer key:m.keySet()){ //把m里的键值对键值关系翻转赋给km，然后看km是否有重复key；
            int value=m.get(key);
            if(km.containsKey(value)){

                return false;
            }else{
                km.put(value,0);
            }
        }
        return true;
    }
}
/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *  
 */
