package leetcode.normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class p129 {
    static int sum=0;
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        createBinaryTree(root);
        System.out.println(sumNumbers(root));
    }
    /**
     * 构建二叉树
     *        4
     *     9     0
     * 5     1
     */
    public static void createBinaryTree(TreeNode root){
        TreeNode nodeB = new TreeNode(9);
        TreeNode nodeC = new TreeNode(0);
        TreeNode nodeD = new TreeNode(5);
        TreeNode nodeE = new TreeNode(1);
        root.left = nodeB;
        root.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
    }
    public static int sumNumbers(TreeNode root) {

        ArrayList<ArrayList<Integer>> paths = findpath(root);
        for (ArrayList<Integer> path : paths) {
            //System.out.println(path.toString());
            int tpsum=0;
            for(int i=0;i<path.size();i++){
                tpsum=tpsum*10+path.get(i);
            }
            sum+=tpsum;
        }
        return sum;

    }
    public static ArrayList<ArrayList<Integer>> findpath(TreeNode root){//dfs遍历所有路径存储在paths里
        ArrayList<ArrayList<Integer>> paths=new ArrayList<>();
        Stack<TreeNode> stk=new Stack<>();
        stk.add(root);
        ArrayList<Integer> tps=new ArrayList<>();
        while(!stk.empty()){
            TreeNode node=stk.pop();
            if(node.left!=null&&node.right!=null&&node.left.tag==true&&node.right.tag==true){//如果一个结点的孩子都有被路径作为终点过，则次结点也不会再被作为路径上的结点。
                node.tag=true;
            } //排列组合三种情况
            if(node.left==null&&node.right!=null&&node.right.tag==true){//如果一个结点的孩子都有被路径作为终点过，则次结点也不会再被作为路径上的结点。
                node.tag=true;
            }
            if(node.left!=null&&node.right==null&&node.left.tag==true){//如果一个结点的孩子都有被路径作为终点过，则次结点也不会再被作为路径上的结点。
                node.tag=true;
            }
            if(node.tag!=true){
                tps.add(node.val);
            }
            if(node.right!=null&&node.right.tag!=true){//未被存过才进栈（本程序中访问过的路径仅仅把结尾即叶子设置为false）
                stk.push(node.right);
            }
            if(node.left!=null&&node.left.tag!=true){
                stk.push(node.left);
            }

            if(node.right==null&&node.left==null&&node.tag==false){//路径结束，且此路径未被存储
                node.tag=true;//以路径终点标记本条路径已被存储
                paths.add(tps);
                tps=new ArrayList<>();
                //每次存完一条路清空栈，然后重新从root开始dfs探索。
                stk=new Stack<>();
                stk.add(root);
            }
            /*if(node.right==null&&node.left==null&&node.tag==true){//如果此路径已被存储则重来
                //重新从root开始dfs探索。
                stk=new Stack<>();
                stk.add(root);
            }*/
        }
        return paths;
    }

}
/*
简单代码：
public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

 */
/*
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。

示例 1:

输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
示例 2:

输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.

 */