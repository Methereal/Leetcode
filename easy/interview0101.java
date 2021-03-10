package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class interview0101 {
    public static void main(String[] args) {
        System.out.println(isUnique("leetcode"));
    }
    public static boolean isUnique(String astr) {
        if(astr.length()==0) return true;
        Map<Character,Boolean> m=new HashMap<>();
        for(int i=0;i<astr.length();i++){
            if(m.containsKey(astr.charAt(i))){
                    return false;
            }else{
                m.put(astr.charAt(i),true);
            }
        }
        return true;
    }
}
/*
实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
示例 1：

输入: s = "leetcode"
输出: false
示例 2：

输入: s = "abc"
输出: true
 */