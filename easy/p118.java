package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class p118 {
    public static void main(String[] args) {
        List<List<Integer>> ls=generate(5);
        for (List<Integer> l : ls) {
            System.out.println(l.toString());
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new LinkedList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> tpl=new LinkedList<>();
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || i == j) {
                    tpl.add(1);
                } else {
                    tpl.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(tpl);
        }
        return res;
    }
}
/**
 *  public List<List<Integer>> generate(int numRows) {
 *         List<List<Integer>> triangle = new ArrayList<List<Integer>>();
 *
 *         // First base case; if user requests zero rows, they get zero rows.
 *         if (numRows == 0) {
 *             return triangle;
 *         }
 *
 *         // Second base case; first row is always [1].
 *         triangle.add(new ArrayList<>());
 *         triangle.get(0).add(1);
 *
 *         for (int rowNum = 1; rowNum < numRows; rowNum++) {
 *             List<Integer> row = new ArrayList<>();
 *             List<Integer> prevRow = triangle.get(rowNum-1);
 *
 *             // The first row element is always 1.
 *             row.add(1);
 *
 *             // Each triangle element (other than the first and last of each row)
 *             // is equal to the sum of the elements above-and-to-the-left and
 *             // above-and-to-the-right.
 *             for (int j = 1; j < rowNum; j++) {
 *                 row.add(prevRow.get(j-1) + prevRow.get(j));
 *             }
 *
 *             // The last row element is always 1.
 *             row.add(1);
 *
 *             triangle.add(row);
 *         }
 *
 *         return triangle;
 *     }
 */
/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
