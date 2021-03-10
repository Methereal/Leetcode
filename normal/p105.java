package leetcode.normal;

import java.util.*;

public class p105 {
    /**
     *
     * preorder第一个元素为root，在inorder里面找到root，在它之前的为左子树（长l1），
     * 之后为右子树（长l2）。preorder[1]到preorder[l1]为左子树,之后为右子树，分别递归。
     */
    public static void main(String[] args) {
        TreeNode tree=buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        List<List<Integer>> res=levelOrder(tree);
        for (List<Integer> re : res) {
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
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==preorder[0]){
                root.left=buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
                root.right=buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
                break;
            }

        }
        return root;
    }
}
/**
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
