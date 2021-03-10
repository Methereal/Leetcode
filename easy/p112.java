package leetcode.easy;

public class p112 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        createTree(root);
        System.out.println(hasPathSum(root,22));
    }
    public static void createTree(TreeNode root){
        TreeNode nodeA=new TreeNode(4);
        TreeNode nodeB=new TreeNode(8);
        TreeNode nodeC=new TreeNode(11);
        TreeNode nodeD=new TreeNode(13);
        TreeNode nodeE=new TreeNode(4);
        TreeNode nodeF=new TreeNode(7);
        TreeNode nodeG=new TreeNode(2);
        TreeNode nodeH=new TreeNode(1);
        root.left=nodeA;
        root.right=nodeB;
        nodeA.left=nodeC;
        nodeB.left=nodeD;
        nodeB.right=nodeE;
        nodeC.left=nodeF;
        nodeC.right=nodeG;
        nodeE.right=nodeH;
    }

    /**构造的二叉树如下
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     *
     *
     *
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.right==null&&root.left==null){
            return root.val==sum;
        }
        //这里的思想是每次进入下一层对sum减去当前结点的值
        //这里生成了很多sum值，去走各自的路径，只要有一条最后减到0即可所以是或的关系，看的是最底层的情况。
        //这里生成的sum值等于叶子结点的数目。
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
