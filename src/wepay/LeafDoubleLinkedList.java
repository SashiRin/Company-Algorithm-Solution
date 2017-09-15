package wepay;

import java.util.Stack;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : LeafDoubleLinkedList
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class LeafDoubleLinkedList {
    //将一棵树全部的leaf node 连成double linked list
    /*
    给一个二叉树和其中一个节点，要求返回从root到这个节点的双向链表。一开始我说可以先把路径存在一个list里然后生成链表，
    面试官要求不用这种做法（不能用额外的数据结构存节点）

     */
    private TreeNode prev;

    public TreeNode bstToDoublyList(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        prev = dummy;
        helper(root);
        // if circular, add:
        // prev.right = dummy.right;
        // dummy.right.left = prev;
        return dummy.right;
    }

    private void helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            root.left = prev;//connect curr node with prev node
            prev.right = root;
            prev = root;//update prev
            return;
        }
        helper(root.left);
        helper(root.right);
    }

    /*
    if (root==null) return;
        Deque<TreeNode> lt = new ArrayDeque<TreeNode>();
        TreeNode pre = null;
        lt.push(root);
        while (!lt.isEmpty()) {
                TreeNode node = lt.pop();
                if (node.right!=null) lt.push(node.right);
                if (node.left!=null) lt.push(node.left);                . 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
                if ((node.left==null)&&(node.right==null)) {
                        if (pre!=null) {
                                pre.right = node;. from: 1point3acres.com/bbs
                                node.left = pre;
                        }
                        pre = node;
                }
        }. from: 1point3
     */
}
