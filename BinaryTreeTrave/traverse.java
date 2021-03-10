package BinaryTreeTrave;

import java.util.ArrayList;
import java.util.Scanner;

public class traverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please input root node value：");
        TreeNode root=new TreeNode(sc.nextInt());
        create_Tree(root);

    }
    public static void create_Tree(TreeNode root){
        Scanner sc=new Scanner(System.in);
        System.out.println("input the left node:");
        ArrayList a=new ArrayList();
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        while(sc.hasNext()){
            treeNodes.add(new TreeNode(sc.nextInt()));
        }
        for (TreeNode treeNode : treeNodes) {

        }
        

    }
    public void preorderTraversal(TreeNode root,ArrayList<Integer> ret){
        int rootvalue = root.val;
        ret.add(rootvalue);
        if(root.left != null){
            inorderTraversal(root.left,ret);
        }
        if(root.right != null){
            inorderTraversal(root.right,ret);
        }
    }
    public void inorderTraversal(TreeNode root, ArrayList<Integer> ret){
        if(root.left != null){
            inorderTraversal(root.left,ret);
        }
        int rootvalue = root.val;
        ret.add(rootvalue);
        if(root.right != null){
            inorderTraversal(root.right,ret);
        }
    }
    public void postorderTraversal(TreeNode root,ArrayList<Integer> ret){
        if(root.left != null){
            inorderTraversal(root.left,ret);
        }
        if(root.right != null){
            inorderTraversal(root.right,ret);
        }
        int rootvalue = root.val;
        ret.add(rootvalue);
    }
}
