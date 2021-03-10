package leetcode.easy;


import java.util.*;

public class p107 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        createBinaryTree(root);
        List<List<Integer>> res=levelOrderBottom(root);
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
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res=new LinkedList<>();
        List<List<Integer>> fres=new LinkedList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            ArrayList<Integer> tpr=new ArrayList<>();
            while(s>0){
                TreeNode node=q.poll();
                tpr.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                s--;
            }
            res.add(tpr);
        }
        for(int i=res.size()-1;i>=0;i--){//逆序输出
            fres.add(res.get(i));
        }
        return fres;
    }

}
