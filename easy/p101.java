package leetcode.easy;

public class p101 {
    public static void main(String[] args) {
        TreeNode rootA=new TreeNode(1);
        createBinaryTreeA(rootA);
        System.out.println(isSymmetric(rootA));
    }
    /**
     * 构建二叉树
     */
    public static void createBinaryTreeA(TreeNode root){
        TreeNode nodeB = new TreeNode(2);
        TreeNode nodeC = new TreeNode(2);
        root.left = nodeB;
        root.right=nodeC;
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        TreeNode left=root.left;
        TreeNode right=root.right;
        return compare(left,right);
    }
    public static boolean compare(TreeNode a,TreeNode b){
        if(a==null&&b==null){
            return true;
        }
        if(a!=null&&b!=null){
            if(a.val==b.val){
                return compare(a.left,b.right)&&compare(a.right,b.left);
            }else{
                return false;
            }
        }
        return false;
    }
}
/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
