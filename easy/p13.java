package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class p13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        if(s==null){
            return 0;
        }
        int rt=0;
        Map<Character,Integer> m=new HashMap<>();
        m.put('I',1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);
        if(s.length()==1){
            return m.get(s.charAt(0));
        }
        rt+=m.get(s.charAt(s.length()-1));
        for (int i = s.length()-1; i >0 ; i--) {
            char pre=s.charAt(i);
            char next=s.charAt(i-1);
            if(m.get(pre)>m.get(next)) {
                rt -=m.get(next);
            } else {
                rt +=m.get(next);
            }
        }
        return rt;
    }
}
