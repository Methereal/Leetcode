package leetcode.normal;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p103 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        createBinaryTree(root);
        List<List<Integer>> res=zigzagLevelOrder(root);
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
    public static void createBinaryTree2(TreeNode root){
        TreeNode nodeB = new TreeNode(2);
        TreeNode nodeC = new TreeNode(3);
        TreeNode nodeD = new TreeNode(4);
        TreeNode nodeE = new TreeNode(5);
        root.left=nodeB;
        root.right=nodeC;
        nodeB.left=nodeD;
        nodeC.right=nodeE;

    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new LinkedList<>();
        }
        List<List<Integer>> res=new LinkedList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> tpl=new ArrayList<>();
            int l=q.size();
            while(l>0) {
                TreeNode node = q.poll();
                if(res.size()%2==0){ //初始的res的size是0，每add一个tpl则加一，这也表示的是层数，是从第0层开始的。
                    tpl.add(node.val);  //偶数层是根据原来队列来的时候进入tpl数组即顺序为left->right，
                                       // 奇数层是每次总是给tpl数组表头插入，则顺序与进入q队列的顺序相反是right->left的
                }else{
                    tpl.add(0,node.val);//这里是给索引为0处添加元素。
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                l--;
            }
            res.add(tpl);
        }
        return res;
    }
}
