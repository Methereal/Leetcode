package leetcode.normal;

import java.util.*;

public class p113 {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        createTree(root);
        List<List<Integer>> lists = pathSum(root, 22);
        System.out.println("----------------------");
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

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
        nodeE.left=new TreeNode(5);
        nodeE.right=nodeH;
    }

    /**构造的二叉树如下
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     *
     *
     *
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return new LinkedList<>();
        }
        List<List<Integer>> res=new LinkedList<>();
        ArrayList<ArrayList<Integer>> paths = findpath(root);
        for (ArrayList<Integer> path : paths) {
            System.out.println(path.toString());
            int tpsum=0;
            for (Integer integer : path) {
                tpsum+=integer;
            }
            if(tpsum==sum) {
                res.add(path);
            }
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> findpath(TreeNode root){//dfs遍历所有路径存储在paths里
        ArrayList<ArrayList<Integer>> paths=new ArrayList<>();
        Stack<TreeNode> stk=new Stack<>();
        stk.add(root);
        ArrayList<Integer> tps=new ArrayList<>();
        while(!stk.empty()){
            TreeNode node=stk.pop();
            if(node.left!=null&&node.right!=null&&node.left.tag==true&&node.right.tag==true){//如果一个结点的孩子都有被路径作为终点过，则次结点也不会再被作为路径上的结点。
                node.tag=true;//左右结点都存在且都无价值则本结点也无价值
            } //排列组合三种情况
            if(node.left==null&&node.right!=null&&node.right.tag==true){//如果一个结点的孩子都有被路径作为终点过，则次结点也不会再被作为路径上的结点。
                node.tag=true;//无左结点,右结点存在且无价值则本结点也无价值
            }
            if(node.left!=null&&node.right==null&&node.left.tag==true){//如果一个结点的孩子都有被路径作为终点过，则次结点也不会再被作为路径上的结点。
                node.tag=true;//无右结点,左结点存在且无价值则本结点也无价值
            }
            if(node.tag!=true){ //如果本结点仍然有“价值“则进入把它进栈，这里的价值指的是本节点的子节点下还有tag为false的结点。
                tps.add(node.val);
            }
            if(node.right!=null&&node.right.tag!=true){//未被存过才进栈(本程序中无价值结点已经在上面被设置为true)
                stk.push(node.right);
            }
            if(node.left!=null&&node.left.tag!=true){
                stk.push(node.left);
            }

            if(node.right==null&&node.left==null&&node.tag==false){//路径结束，且此路径未被存储
                node.tag=true;//以路径终点标记本条路径已被存储
                paths.add(tps);//路径存入。
                tps=new ArrayList<>();
                //每次存完一条路清空栈，然后重新从root开始dfs探索。
                stk=new Stack<>();
                retag(root);//每次完成一次路径及时重新标号，把无价值的点tag改为true
                stk.add(root);
            }
            /*if(node.right==null&&node.left==null&&node.tag==true){//如果此路径已被存储则重来
                //重新从root开始dfs探索。
                stk=new Stack<>();
                stk.add(root);
            }*/
            //*****test***************
            System.out.println("test----------------");
            if(node.tag){
                System.out.println("Node:"+node.val+" tag:"+node.tag);
                //

            }
            System.out.println("tps:"+tps.toString());
            System.out.println("test----------------");
            //*****test***************

        }
        return paths;
    }
    public static void retag(TreeNode root) {//下面程序利用层次遍历检查每个结点的价值，更改其tag
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int l=q.size();//每次队列装的是二叉树一层的结点
            while(l>0){
                TreeNode node=q.poll(); //当队列不为空则把最前面的出队列，（队列先进先出）
                //-----------------------------
                if(node.left!=null&&node.right!=null&&node.left.tag==true&&node.right.tag==true){//如果一个结点的孩子都有被路径作为终点过，则次结点也不会再被作为路径上的结点。
                    node.tag=true;//左右结点都存在且都无价值则本结点也无价值

                } //排列组合三种情况
                if(node.left==null&&node.right!=null&&node.right.tag==true){//如果一个结点的孩子都有被路径作为终点过，则次结点也不会再被作为路径上的结点。
                    node.tag=true;//无左结点,右结点存在且无价值则本结点也无价值
                }
                if(node.left!=null&&node.right==null&&node.left.tag==true){//如果一个结点的孩子都有被路径作为终点过，则次结点也不会再被作为路径上的结点。
                    node.tag=true;//无右结点,左结点存在且无价值则本结点也无价值
                }
                //------------------------------
                if(node.left!=null){  //当前结点是否有左子树
                    q.add(node.left);  //有则进队列
                }
                if(node.right!=null){   //当前结点是否有右子树
                    q.add(node.right);//有则进队列
                }
                l--; //本层第一个结点已经存储并且已经把其左右子节点进队列，然后访问队列下一个，无则退出循环
            }
        }
    }

}
