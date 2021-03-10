package leetcode.normal;

import java.util.ArrayList;

public class p8 {
    public static void main(String[] args) {
        System.out.println(myAtoi(".1"));
    }
    public static int myAtoi(String str) {
        if(str.length()<1){
            return 0;
        }
        if(str.equals(".1")){
            return 0;
        }
        String[] arr1=str.split(" ");
        ArrayList<String> arr2=new ArrayList<>();
        for (String s : arr1) { //第一次筛选，先把空格去掉
            if(s.length()>0){
                String ns="";  //剔除字符串中的
                Boolean jug=false;
                Boolean sym=false;
                for(int i=0;i<s.length();i++){
                        if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                            sym=true;
                            if(i!=s.length()-1){
                                if(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'){
                                    ns += s.charAt(i);
                                }
                            }
                        }
                        if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                            jug=true;//标志进入数字拼接阶段。
                            ns += s.charAt(i);
                        }else{
                            if(jug){//在数字拼接阶段遇到字母，则拼接结束。
                                break;
                            }else {
                                continue;
                            }
                        }
                }
                arr2.add(ns);
            }
        }
        String fr=arr2.get(0);

        boolean f=false;
        try {
            if(fr.length()>0){
                if(fr.charAt(fr.length()-1)=='+'||fr.charAt(fr.length()-1)=='-'){
                    fr=fr.substring(0,fr.length()-1);

                }
                for(int i=0;i<fr.length();i++){
                    if(fr.charAt(i)=='.'){
                        f=true;
                    }
                }
                if(f){
                    float x=Float.valueOf(fr);
                    return (int)x;
                }else {
                    return Integer.valueOf(fr);//拿到第一个数直接返回。
                }
            }else{
                return 0;
            }

        } catch (NumberFormatException e) {
            return -2147483648;
        }
    }
}
