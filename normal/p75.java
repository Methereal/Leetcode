package leetcode.normal;

import java.util.HashMap;
import java.util.Map;

public class p75 {
    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }
    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            for(int j = i+1; j <arr.length ;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min!=i){
                swap(arr, i, min);
            }
        }
    }
    //完成数组两元素间交换
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void sortColors(int[] nums) {
        selectSort(nums);

    }

    /*
    //本题目的一种简单的思想解法
    public void sortColors(int[] nums) {
        int[] colorNums = new int[3];
        for (int i = 0; i < nums.length; i++) {
           colorNums[nums[i]]++;
        }
        for (int i = 0; i < colorNums[0]; i++) nums[i] = 0;
        for (int i = 0; i < colorNums[1]; i++) nums[i + colorNums[0]] = 1;
        for (int i = 0; i < colorNums[2]; i++) nums[i + colorNums[0] + colorNums[1]] = 2;
    }
     */
}
/*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：

一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？

 */