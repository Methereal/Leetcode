package leetcode.difficult;

import java.util.Arrays;

import static java.util.Arrays.sort;
/*
此题解法不符合题目要求，时间复杂度过大为(m+n)。
如何把时间复杂度降低到 O(log(m+n)) 呢？
如果对时间复杂度的要求有 log，通常都需要用到二分查找，这道题也可以通过二分查找实现。
 */
public class p4 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double rt=0;
        int[] cb= Arrays.copyOf(nums1,nums1.length+nums2.length);
        System.arraycopy(nums2,0,cb,nums1.length,nums2.length);
        sort(cb);
        if(cb.length%2==0){
            rt=(double)(cb[cb.length/2]+cb[cb.length/2-1])/2;
        }else{
            rt=(double)cb[cb.length/2];
        }
        return rt;
    }
}
