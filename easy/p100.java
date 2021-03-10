package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class p100 {
    public static void main(String[] args) {
        TreeNode rootA=new TreeNode(1);
        TreeNode rootB=new TreeNode(1);
        createBinaryTreeA(rootA);
        createBinaryTreeB(rootB);
        System.out.println(isSameTree(rootA,rootB));
    }
    /**
     * 构建二叉树
     *        3
     *     9     20
     *         15   7
     */
    public static void createBinaryTreeA(TreeNode root){
        TreeNode nodeB = new TreeNode(2);
        root.left = nodeB;
    }
    public static void createBinaryTreeB(TreeNode root){
        TreeNode nodeB = new TreeNode(2);
        root.right = nodeB;
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val==q.val){
            return isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }

}
/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 */