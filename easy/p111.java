package leetcode.easy;

public class p111 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        createTree(root);
        System.out.println(minDepth(root));
    }
    public static void createTree(TreeNode root){
        TreeNode nodeA=new TreeNode(9);
        TreeNode nodeB=new TreeNode(20);
        TreeNode nodeC=new TreeNode(15);
        TreeNode nodeD=new TreeNode(7);
        root.left=nodeA;
        root.right=nodeB;
        nodeB.left=nodeC;
        nodeB.right=nodeD;
    }
    public static int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        // null节点不参与比较
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        // null节点不参与比较
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
}
/*
下面是求最大深度
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
}
 */