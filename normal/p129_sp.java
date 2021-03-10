package leetcode.normal;

public class p129_sp {
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
        return dfs(root, 0);
    }
    public static int dfs(TreeNode root,int subsum){
        if(root==null){
            return 0;
        }
        int sum=subsum*10+root.val;
        if(root.right==null&&root.left==null){
            return sum;//迭代dfs访问到了叶子结点返回sum值
        }else{ //剩余三种情况，其中left或者right为空的情况有root==null保证不会出错。
            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }
}
