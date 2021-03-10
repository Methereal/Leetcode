package leetcode.easy;

import org.junit.Test;

import java.util.*;

public class p108 {
    public static void main(String[] args) {
       TreeNode tree=sortedArrayToBST(new int[]{-10,-3,0,5,9});
        List<List<Integer>> res=levelOrder(tree);
        for (List<Integer> re : res) {
            System.out.println(re.toString());
            for (Integer integer : re) {
                System.out.println(integer);
            }
        }
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
    public static TreeNode sortedArrayToBST(int[] nums) {
        // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        int l=nums.length;
        if(l==0){
            return null;
        }
        TreeNode root=buildTree(nums,0,nums.length-1);
        return root;
    }
    public static TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }
}
