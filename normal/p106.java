package leetcode.normal;

import java.util.*;

public class p106 {
    static HashMap<Integer,Integer> inorderArrayMap = new HashMap<>();
    static int[] post;
    public static void main(String[] args) {
        TreeNode tree=buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
        List<List<Integer>> res=levelOrder(tree);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.println(integer);
            }
        }
    }

    /**
     * 层次遍历函数
     * @param root
     * @return
     */
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


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++) {
            inorderArrayMap.put(inorder[i], i);//将节点值及索引全部记录在哈希表中
        }
        TreeNode root = buildTree(0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    public static TreeNode buildTree(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if(inorderEnd < inorderStart || postorderEnd < postorderStart) return null;
        TreeNode node = new TreeNode(post[postorderEnd]);//根据后序取根节点
        int rootIndexInInorderArray = inorderArrayMap.get(post[postorderEnd]);//获取根节点对应的索引
        node.left = buildTree(inorderStart, rootIndexInInorderArray - 1, postorderStart, postorderStart + rootIndexInInorderArray - inorderStart - 1);
        node.right = buildTree(rootIndexInInorderArray + 1, inorderEnd, postorderStart + rootIndexInInorderArray - inorderStart, postorderEnd - 1);
        return node;
    }
}
