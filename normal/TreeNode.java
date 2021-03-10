package leetcode.normal;

public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       Boolean tag=false;
       public TreeNode() {
       }

       TreeNode(int val) { this.val = val; }

       public TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
       }
}
