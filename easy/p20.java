package leetcode.easy;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Stack;
public class p20 {
    public static void main(String[] args) {
        System.out.println(isValid2("[(]"));
    }
    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i)=='('){
                stk.push(')');
                continue;
            }
            if(s.charAt(i)=='{'){
                stk.push('}');
                continue;
            }
            if(s.charAt(i)=='['){
                stk.push(']');
                continue;
            }
            if(!stk.empty()&&stk.peek()==s.charAt(i)){
                stk.pop();
            }else{
                return false;
            }
        }
        return stk.empty();
    }
    //方法二思路：
    /*
    符合要求的字符串初始一定至少有一对成对出现的三种括号之一。比如()，{},或者[]
    本方法是迭代的方式，从内向外连续消除成对的括号，
    最终消除整个字符串则表示所有括号都是符合规范的闭合的。
     */
    public static boolean isValid2(String s) {//方法二：代码简单但是复杂度高
        while(s.contains("()")||s.contains("{}")||s.contains("[]")){
            s = s.replace("()", "");
            s = s.replace("{}","");
            s = s.replace("[]","");
        }
        return s.isEmpty();
    }

}
