package leetcode.easy;

public class p110 {
    public static void main(String[] args) {
        System.out.println(isBalanced(new TreeNode(3)));
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
    public static boolean isBalanced(TreeNode root) {
        return height(root)>=0;
    }
    public static int height(TreeNode root) {
        if(root == null)
            return 0;
        int lh = height(root.left), rh = height(root.right);
        if(lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }
}
