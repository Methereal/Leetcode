package leetcode.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p102 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        createBinaryTree(root);
        List<List<Integer>> res=levelOrder(root);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.println(integer);
            }
        }
    }
    /**
     * 构建二叉树
     *        3
     *     9     20
     *         15   7
     */
    public static void createBinaryTree(TreeNode root){
        TreeNode nodeB = new TreeNode(9);
        TreeNode nodeC = new TreeNode(20);
        TreeNode nodeD = new TreeNode(15);
        TreeNode nodeE = new TreeNode(7);
        root.left = nodeB;
        root.right = nodeC;
        nodeC.left = nodeD;
        nodeC.right = nodeE;
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int l=q.size();//每次队列装的是二叉树一层的结点
            List<Integer> list=new ArrayList<>();//这层结点的值存储在这里
            while(l>0){
                TreeNode node=q.poll(); //当队列不为空则把最前面的出队列，（队列先进先出）
                list.add(node.val);   //把当前结点的值存储
                if(node.left!=null){  //当前结点是否有左子树
                    q.add(node.left);  //有则进队列
                }
                if(node.right!=null){   //当前结点是否有右子树
                    q.add(node.right);//有则进队列
                }
                l--; //本层第一个结点已经存储并且已经把其左右子节点进队列，然后访问队列下一个，无则退出循环
            }
            res.add(list);//把本层的所有结点的list存入res里
        }
        return res;
    }
}
/*
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

 

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

 */