package leetcode.normal;

import java.util.HashMap;
import java.util.Map;
/*
本题解法采用滑动窗口思想。
 */
public class p3_2 {
    public static void main(String[] args) {
            System.out.println(lengthOfLongestSubstring("dvdf"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s==null) return 0;
        int maxl=0;
        for(int i=0;i<s.length();i++){
            Map<Character,Boolean> m=new HashMap<>();
            char left=s.charAt(i);
            String tps=""+left;
            m.put(left,true);
            for(int j=i+1;j<s.length();j++){
                char mid=s.charAt(j);
                if(m.containsKey(mid)){
                    break;
                }else{
                    m.put(mid,true);
                    tps+=mid;
                }
            }
            maxl=Math.max(tps.length(),maxl);
        }
        return maxl;
    }
}
/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 */
/*

 */
