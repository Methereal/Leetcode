package leetcode.easy;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class p14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs[0].length()==0){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        int snum=strs.length;
        int minlen=strs[0].length();//先拿到最短的字符串，方便后面校验避免空指针异常。
        for(int i=1;i<snum;i++){
            if(minlen>strs[i].length()){
                minlen=strs[i].length();
            }
        }
        for (int i=0;i<minlen;i++){//一个个字符比对
            Boolean jug=true;
            char test=strs[0].charAt(i);  //拿到当前要比对的字符
            for(int j=0;j<snum;j++){   //看大家此字符是否相同
                if(test!=strs[j].charAt(i)){ //只要出现不符合直接结束。
                    jug=false;
                    break;
                }
            }
            if(jug){
                sb.append(test);
            }else { //只要出现不符合，整个校验直接结束。
                break;
            }
        }
        return sb.toString();

    }

    /**
     * 方法2：
     * 思路：通过map存入每个字符，然后用最短的字符串按顺序找map中的字符对应的个数，flal,flla，比对不出来？bug?
     * key值为了分辨不同位置的字符，需要一个map存字符和位置。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs[0].length()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Map<Pair<Character,Integer>,Integer> map=new HashMap<>();
        int snum=strs.length;//字符串的个数
        int minlen=strs[0].length();//先拿到最短的字符串长度，方便后面校验避免空指针异常。
        for(int i=1;i<snum;i++){
            if(minlen>strs[i].length()){
                minlen=strs[i].length();
            }
        }
        for(int i=0;i<snum;i++){//把每个字符串的字符都遍历一遍
            for(int j=0;j<strs[i].length();j++){
                Pair<Character,Integer> p=new Pair<>(strs[i].charAt(j),j);
                map.put(p,0);
            }
        }

        return sb.toString();
    }

}
