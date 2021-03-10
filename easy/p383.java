package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
/*
本题思路为
第一个循环先把第一个字符串的字符映射初始值为-1，然后每次再遇到同样字符则给value减一。
第二个循环是在上面建立的map上进行key值查询，然后每次找到对应key则对其value加一
第三个增强for则是遍历map判断所有key值对应的value是否有小于0的，则表示后面串的字符无法构成字符串一则直接返回false。全部合规则return true；
 */
public class p383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa","aab"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> m=new HashMap<>();
        for (int i = 0; i <ransomNote.length() ; i++) {
            if(m.containsKey(ransomNote.charAt(i))){
                //int newval=m.get(ransomNote.charAt(i))-1;
                m.replace(ransomNote.charAt(i),m.get(ransomNote.charAt(i))-1);
                //m.put(ransomNote.charAt(i),newval);
            }else{
                m.put(ransomNote.charAt(i),-1);
            }
        }
        for (int i = 0; i <magazine.length() ; i++) {
            if(m.containsKey(magazine.charAt(i))){
                int newval=m.get(magazine.charAt(i))+1;
                m.put(magazine.charAt(i),newval);
            }
        }
        for (char c : m.keySet()) {
            if(m.get(c)<0){
                return false;
            }
        }
        return true;
    }
}
/*
给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。

(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)

 

注意：

你可以假设两个字符串均只含有小写字母。

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

 */