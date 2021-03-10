package leetcode.normal;

/*
本题的思想是扩展中心，因为回文字符串的特点，所以每次我们选择一个字符或者字符的中间作为起始的中间点，
若字符串的长度为n，则可选择的中心点为2n-1即n+n-1，其中n是每个字符都可以作为中心点，然后n-1是所有字符的中间的空位的数目。
向左右两边探索，判断左右两边是否相同，然后得到每次的回文字符串的长度。
 */
public class p5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdecba"));
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); //奇数长度子串,左右都是i,
            int len2 = expandAroundCenter(s, i, i + 1);//偶数长度子串，左为i，右为i+1
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
