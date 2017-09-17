import houzz.TreeNode;

import java.util.*;

import static indeed.TiltBinaryTree.tilt;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : PACKAGE_NAME
 * File Name : Test
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class Test {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }

    }

    public static int tiltNumber(TreeNode head) {
        if (head == null || head.left == null && head.right == null) return 0;
        int[] result =  {0};
        helper(head, result);
        return result[0];
    }
    public static int helper(TreeNode head, int[] result) {
        if (head == null) return 0;

        int left = helper(head.left, result);
        int right = helper(head.right,result);
        result[0] += Math.abs(left - right);
        return left + right + head.val;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        //root.right.right = new TreeNode(7);
        System.out.println(tiltNumber(root));
    }
}
