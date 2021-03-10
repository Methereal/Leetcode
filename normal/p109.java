package leetcode.normal;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p109 {

    public static void main(String[] args) {
        ListNode head=new ListNode(-10);
        createList(head);
        TreeNode tree=sortedListToBST(head);

        List<List<Integer>> res=levelOrder(tree);
        for (List<Integer> re : res) {
            System.out.println(re.toString());
            for (Integer integer : re) {
                System.out.println(integer);
            }
        }
    }
    public static void createList(ListNode fir){
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        fir.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;
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
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        else if(head.next == null) return new TreeNode(head.val); //单元素
        //ListNode pre = head;
        ListNode p = head.next; //慢
        ListNode q = p.next;  //快
        ListNode front_p=head;//p前面的结点，分割链表需要
        /**
         * 开始状态:
         * -10  -3  0  5  9
         *       p  q
         */
        /**
         * 状态1:
         * -10  -3  0  5  9
         *          *          p     q
         */
        //找到链表的中点p
        /**
         * 这里采用了链表查找中点的快慢指针方法
         * 快指针q每次移动两个单位，慢指针每次移动一个单位，则当快指针到表尾，慢指针到中点
         */
        while(q!=null && q.next!=null){ //这里因为快指针每次移动两个元素，防止空指针异常，
                                       // 则需要判断本结点是否存在，然后看是否是链表尾，看next是否为空。
            //这里利用了指示器pre来固定了pre,p,q之间的位置，实现了指针的效果
            front_p=p;
            p=p.next;  //p走一步
            q=q.next.next; //q走两步
        }
        //分割链表
        //得到的链表为
        /**
         * list1:   -10 -3
         * list2:    5  9
         */
        TreeNode root=new TreeNode(p.val);
        front_p.next=null;//p元素被当做根结点创造树
        //这里分割链表不能直接吧p设置为null，这样并没有分割结点，必须把指向p的指针断掉才算分割。
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(p.next);
        return root;
        /**程序构造过程：
         *            0
         *----------------------------
         *            0
         *        -3
         *----------------------------
         *            0
         *        -3
         *     -10
         *----------------------------
         *            0
         *        -3     5
         *     -10
         *----------------------------
         *            0
         *        -3     9
         *     -10     5
         *----------------------------
         */
    }
}
