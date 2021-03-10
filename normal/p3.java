package leetcode.normal;

import java.util.HashMap;
import java.util.Map;

public class p3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcaaa"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s==null){
            return 0;
        }
        Map<Character,Integer> m=new HashMap<>();
        int maxl=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            if(m.containsKey(s.charAt(i))){
                left= Math.max(left,m.get(s.charAt(i)) + 1);
            }
            m.put(s.charAt(i),i);
            maxl= Math.max(maxl,i-left+1);
        }
        return maxl;
    }

    /*public static int lengthOfLongestSubstring(String s) {
        Map<String,Integer> m=new HashMap<>();
        //设置一个map来存子串，key装子串，value装长度。

        int maxl=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length()+1;j++){  //这里j的约束条件为s.length()+1是因为substring的原因。为了保证最后一个字符被使用到。
                String tps=s.substring(i,j);//先不管子串是否符合规范，全部装入
                System.out.println("tps:"+tps+" len:"+tps.length());
                if(m.containsKey(tps)){
                    continue;
                }else{
                    m.put(tps,tps.length());
                }
            }
        }
        for (String s1 : m.keySet()) {
            Map<Character,Integer> tpm=new HashMap<>();
            Boolean jug=true;//判断子串是否符合规范即不能含重复字符。
            for(int i=0;i<s1.length();i++){
                char tpc=s1.charAt(i);
                if(tpm.containsKey(tpc)){
                    jug=false;//不符合规范
                    break;//不符合规范
                }else{
                    tpm.put(tpc,1);
                }
            }
            if(jug){
                if(maxl<m.get(s1)){
                    maxl=m.get(s1);
                }
            }
            tpm.clear();
        }
        return maxl;
    }*/
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

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */